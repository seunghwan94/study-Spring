package com.example.member_post.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import io.micrometer.common.lang.Nullable;


@Controller
public class CommonController {
  
  @GetMapping({"/","/index"})
  // @ResponseBody
  public String index(){
    return "common/index";
  }
    
  @RequestMapping(value = "msg")
  public String msg(@ModelAttribute("msg") String msg, @ModelAttribute("url") @Nullable String url) {
    
    return "common/msg";
  }
}
