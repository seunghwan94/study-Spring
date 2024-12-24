package com.example.guestbook2.controller;

import java.time.LocalDateTime;
import java.util.stream.LongStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.guestbook2.domain.SampleDto;

import lombok.extern.log4j.Log4j2;


@Controller
@RequestMapping("sample")
@Log4j2
public class SampleController {
  @GetMapping({"ex02","exLink"})
  public void ex02(Model model) {
    model.addAttribute("list",
    LongStream.rangeClosed(1, 20)
    .mapToObj(i->SampleDto.builder()
      .sno(i)
      .first("first"+i)
      .last("last"+i)
      .regTime(LocalDateTime.now())
    .build()));
  }
  @GetMapping("exInline")
  public String exInline(RedirectAttributes rttr) {
    rttr.addFlashAttribute("dto",SampleDto.builder()
      .sno(100L)
      .first("first")
      .last("last")
      .regTime(LocalDateTime.now())
    .build());
    rttr.addFlashAttribute("result","success");
    return "redirect:ex03";
  }
  
  @GetMapping("ex03")
  public void ex03() {
      log.info("ex03");
  }
  

  @GetMapping({"exLayout1","exLayout2","exTemplate","exSidebar"})
  public void exLayout1() {
    log.info("exLayout1");
  }
  
}
