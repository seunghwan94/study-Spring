package com.example.guestbook2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.guestbook2.domain.dto.PageRequestDto;
import com.example.guestbook2.service.GuestbookService;


import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;


@Controller
@RequestMapping("guestbook")
@Log4j2
public class GuestbookController {
  @javax.inject.Inject // AutoWired랑 같은데 동작 순서만 다름
  private GuestbookService service;

  @GetMapping({"","/","list"})
  public String list(Model model, PageRequestDto dto) {
    log.info("list");
    model.addAttribute("result", service.list(dto));
    return "/guestbook/list";
  }



}
