package com.example.clone.security.filter;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.example.clone.security.util.JWTUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ApiLoginFilter extends AbstractAuthenticationProcessingFilter{
  private JWTUtil jwtUtil;

  public ApiLoginFilter(String defaultFilterProcessUrl, JWTUtil jwtUtil){
    super(defaultFilterProcessUrl);
    this.jwtUtil = jwtUtil;
  }


  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
      throws AuthenticationException, IOException, ServletException {
        
    log.info("===================== ApiLoginFilter.attemptAuthentication()");
    String email = request.getParameter("email");
    String pw = "1234";
    log.info("email ::" + email);
    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, pw);
    log.info(authenticationToken.getPrincipal());
    return getAuthenticationManager().authenticate(authenticationToken);
  }
  
  @Override
  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
      Authentication authResult) throws IOException, ServletException {
    log.info(authResult.getName());
    log.info(authResult);
    String email = authResult.getName();
    try{
      String token = jwtUtil.generateToken(email);
      response.setContentType("text/plain");
      response.getOutputStream().write(token.getBytes());
      log.info("========================= api login success");
      log.info(token);

    }catch(Exception e){
      e.printStackTrace();
    }

    SecurityContextHolder.getContext().setAuthentication(authResult);
    // super.successfulAuthentication(request, response, chain, authResult);
  }
}
