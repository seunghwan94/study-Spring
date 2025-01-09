package com.example.clone.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.clone.security.dto.AuthMemberDto;



@Controller
@Log4j2
@RequestMapping("sample")
public class SampleController {
  @GetMapping("all")
  public void exAll() {
    // UsernamePasswordAuthenticationToken token;
    // AuthenticationManager manager;
    // AuthenticationProvider provider;
    log.info("ex all");
  }
  @GetMapping("member")
  public void exMember() {
    log.info("ex all");
  }
  @GetMapping("admin")
  public void exAdmin() {
    log.info("ex all");
  }
  @GetMapping("api")
  @ResponseBody
  public AuthMemberDto getSampleApi(@AuthenticationPrincipal AuthMemberDto dto) {
      return dto;
  }
  
}
