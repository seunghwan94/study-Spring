package site.mplace.di.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
  
  @GetMapping("/")
  @ResponseBody
  public String index(){
    return "hello world";
  }

}
