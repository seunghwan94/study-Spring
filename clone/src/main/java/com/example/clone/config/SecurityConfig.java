package com.example.clone.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.clone.security.filter.ApiCheckFilter;
import com.example.clone.security.filter.ApiLoginFilter;
import com.example.clone.security.handler.ApiLoginFailHandler;
import com.example.clone.security.handler.LoginSuccessHandler;
import com.example.clone.security.util.JWTUtil;

@Configuration
@EnableMethodSecurity //접근 제한 걸기
public class SecurityConfig{

  @Autowired
  private UserDetailsService userDetailsService;


  @Bean
  public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception{
    AuthenticationManagerBuilder builder = http.getSharedObject(AuthenticationManagerBuilder.class);
    builder.userDetailsService(userDetailsService)
      .passwordEncoder(passwordEncoder()).setBuilder(builder);

    AuthenticationManager authenticationManager = builder.build();
    return authenticationManager;

  }


  @Bean
  public ApiCheckFilter apiCheckFilter() {
    return new ApiCheckFilter("/api/v1/**", jwtUtil());
  }

  @Bean
  public JWTUtil jwtUtil(){
    return new JWTUtil();
  }


  @Bean
  public ApiLoginFilter apiLoginFilter(AuthenticationManager authenticationManager) throws Exception{
    ApiLoginFilter apiLoginFilter = new ApiLoginFilter("/api/login",jwtUtil());
    apiLoginFilter.setAuthenticationManager(authenticationManager);
    apiLoginFilter.setAuthenticationFailureHandler(new ApiLoginFailHandler());
    return apiLoginFilter;
  }

  @Bean
  public PasswordEncoder passwordEncoder(){
      return new BCryptPasswordEncoder();
  };

    

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf(csrf -> csrf.disable()) // CSRF 비활성화 (필요에 따라 활성화)
        .authorizeHttpRequests(auth -> auth
          .requestMatchers("/sample/all").permitAll() // `/public/` 경로는 인증 없이 접근 가능
          .requestMatchers("/sample/member").hasRole("USER") // `/public/` 경로는 인증 없이 접근 가능
          // .requestMatchers("/sample/admin").hasRole("ADMIN") // `/public/` 경로는 인증 없이 접근 가능
          // .anyRequest().authenticated() // 나머지는 인증 필요
          .anyRequest().permitAll()
        )
        .formLogin(f -> f.permitAll()) // 기본 로그인 폼 활성화
        .logout(l -> l.logoutUrl("/member/signout"))
        .oauth2Login(o -> o.successHandler(loginSuccessHandler()))
        .rememberMe(r -> r.tokenValiditySeconds(60 * 60 * 24 * 14)
          .userDetailsService(userDetailsService)
          .rememberMeCookieName("remember-id"));

    http
      .addFilterBefore(apiCheckFilter(), UsernamePasswordAuthenticationFilter.class)
      .addFilterBefore(apiLoginFilter(authenticationManager(http)), UsernamePasswordAuthenticationFilter.class);
    return http.build();
  }

  @Bean
  public LoginSuccessHandler loginSuccessHandler(){
    return new LoginSuccessHandler(passwordEncoder());
  }


}
