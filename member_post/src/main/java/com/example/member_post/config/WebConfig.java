package com.example.member_post.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

// web.xml 대체한다.
@Configuration
public class WebConfig implements WebMvcConfigurer{
  

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry
      .addResourceHandler("/**")
      .addResourceLocations("classpath:/static");
  }


  @Bean
  public ServletContextListener ServletContextListener(){
    return new ServletContextListener() {
    
      @Override
      public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("cp", sce.getServletContext().getContextPath() + "/");
      }

    };
  }

  
}
