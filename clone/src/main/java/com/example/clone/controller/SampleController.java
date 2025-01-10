package com.example.clone.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.clone.security.dto.AuthMemberDto;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("sample")
public class SampleController {
  @GetMapping("all")
  public void exAll(@AuthenticationPrincipal AuthMemberDto dto) {
    // UsernamePasswordAuthenticationToken token;
    // AuthenticationManager manager;
    // AuthenticationProvider provider;
    log.info(dto);
    log.info("ex all");
  }
  @GetMapping("member")
  public void exMember(@AuthenticationPrincipal AuthMemberDto dto) {
    log.info(dto);
    log.info("ex all");
  }
  @GetMapping("admin")
  @PreAuthorize("hasRole('ADMIN')")
  public void exAdmin(@AuthenticationPrincipal AuthMemberDto dto) {
    log.info(dto);
    log.info("ex all");
  }
  @GetMapping("api")
  @PreAuthorize("isAuthenticated()")
  // @PreAuthorize("isAnonymous()")
  @ResponseBody
  public AuthMemberDto getSampleApi(@AuthenticationPrincipal AuthMemberDto dto) {
      return dto;
  }

  @GetMapping("exMemberOnly")
  @ResponseBody
  @PreAuthorize("#dto != null && #dto.username eq \"user2@a.com\"")
  public String exMemberOnly(@AuthenticationPrincipal AuthMemberDto dto) {
    log.info(dto.getUsername());
    return dto.getEmail();
  }
  
  
}
