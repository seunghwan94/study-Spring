package com.example.clone.security.filter;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.clone.security.util.JWTUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import net.minidev.json.JSONObject;

@Log4j2
@Component
public class ApiCheckFilter extends OncePerRequestFilter{

  private AntPathMatcher antPathMatcher;
  private String pattern;
  private JWTUtil jwtUtil;

  public ApiCheckFilter(String pattern, JWTUtil jwtUtil){
    antPathMatcher = new AntPathMatcher();
    this.pattern = pattern;
    this.jwtUtil = jwtUtil;
  }

  @Override
  @SuppressWarnings("null")
  protected void doFilterInternal( HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    if(antPathMatcher.match(pattern, request.getRequestURI())){
      log.info("========================= api check filter =========================");
      log.info(request.getRequestURI());
      
      if (checkAuthHeader(request)){
        String token = request.getHeader("Authorization").substring(7);
        String email = jwtUtil.validateExtract(token);

        Authentication authentication = new UsernamePasswordAuthenticationToken(email, null, null);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
      } else {
        response.setContentType("application/json; charset=utf-8");
        response.setStatus(403);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 403);
        jsonObject.put("message", "Failed To Check API TOKEN");
        response.getWriter().print(jsonObject);
      }
      return;
    }
    log.info("여기");
    filterChain.doFilter(request, response);
  }

  // @Override
  // protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
  //     throws ServletException, IOException {
  //   if(antPathMatcher.match(pattern, request.getRequestURI())){
  //     log.info("========================= api check filter =========================");
  //     log.info(request.getRequestURI());
      
  //     return;
  //   }
  //   filterChain.doFilter(request, response);
  // }

  private boolean checkAuthHeader(HttpServletRequest request){
    boolean result = false;
    String authHeader = request.getHeader("Authorization");
    if(StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer ")){

      log.info("Authentication exist ::" + authHeader);
      String email = jwtUtil.validateExtract(authHeader.substring(7));
      log.info("valid email :: " + email);
      result = email.length() > 0;
      
      // if(authHeader.equals("12345678")){
      //   result = true;
      // }
    }
    return result;
  }
  
}
