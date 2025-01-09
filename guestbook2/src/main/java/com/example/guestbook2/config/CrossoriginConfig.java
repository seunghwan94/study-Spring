package com.example.guestbook2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrossoriginConfig {
  @Bean
  public WebMvcConfigurer configurer(){
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry){
        registry
          .addMapping("/**")
          .allowedOrigins("http://localhost:3000", "http://localhost");
      }
    };
  }
}
