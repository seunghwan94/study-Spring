package com.example.member_post.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.micrometer.common.lang.Nullable;
import lombok.extern.log4j.Log4j2;


@Controller
@Log4j2
public class CommonController {
  
  @GetMapping({"/","/index"})
  // @ResponseBody
  public String index(){
    return "common/index";
  }
    
  @RequestMapping(value = "msg")
  public String msg(@ModelAttribute("msg") String msg, @RequestParam("url") @Nullable String url,Model model) throws UnsupportedEncodingException {
    
    if(url != null){
      int idx = url.lastIndexOf("?")+1;
      String urlStr = url.substring(0,idx) + URLEncoder.encode(url.substring(idx), "utf-8");
      model.addAttribute("url",urlStr);
    }

    return "common/msg";
  }
}
