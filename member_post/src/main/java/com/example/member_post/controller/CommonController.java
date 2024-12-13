package com.example.member_post.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class CommonController {
  
  @GetMapping({"/","/index"})
  // @ResponseBody
  public String index(){
    return "common/index";
  }
}
