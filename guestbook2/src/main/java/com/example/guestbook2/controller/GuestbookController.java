package com.example.guestbook2.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.guestbook2.domain.dto.GuestbookDto;
import com.example.guestbook2.domain.dto.PageRequestDto;
import com.example.guestbook2.service.GuestbookService;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("guestbook")
@Log4j2
public class GuestbookController {
  @javax.inject.Inject // AutoWired랑 같은데 동작 순서만 다름
  private GuestbookService service;

  @GetMapping({"","/","list"})
  public String list(Model model, PageRequestDto dto) {
    model.addAttribute("result", service.list(dto));
    return "/guestbook/list";
  }

  @GetMapping("register")
  public void register() {
      
  }
  
  @PostMapping("register")
  public String register(GuestbookDto dto, RedirectAttributes rttr) {
    rttr.addFlashAttribute("msg", service.write(dto));
    return "redirect:list";
  }

  @GetMapping({"read","modify"})
  public void read(Long gno,Model model,@ModelAttribute("pageDto") PageRequestDto pageDto) {
    model.addAttribute("dto", service.read(gno));
  }

  @PostMapping("modify")
  public String modify(GuestbookDto dto, RedirectAttributes rttr, @ModelAttribute("pageDto") PageRequestDto pageDto) {
    service.modify(dto);
    rttr.addAttribute("page", pageDto.getPage());
    return "redirect:list";
  }
  
  @PostMapping("remove")
  public String remove(GuestbookDto dto, Model model, RedirectAttributes rttr, @ModelAttribute("pageDto") PageRequestDto pageDto) {
    service.remove(dto.getGno());
    rttr.addAttribute("page", pageDto.getPage());
    return "redirect:list";
  }
  
  

}
