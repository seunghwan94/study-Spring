package com.example.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.todo.dto.TodoWriteDto;
import com.example.todo.service.TodoService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;





@Controller
@AllArgsConstructor
@Log4j2
public class TodoController {
  private TodoService service;
  
  @GetMapping("todos")
  public String list(Model model) {
    model.addAttribute("todos",service.list());
    return "todo-list";
  }
  
  @PostMapping("todos")
  public String writer(TodoWriteDto dto) {
    service.writer(dto);
    return "redirect:todos";
  }
  
  @RequestMapping("todos/remove")
  public String remove(Long id) {
    log.info(id);
    service.remove(id);
    return "redirect:/todos";
  }
  
  @RequestMapping("todos/modify")
  public String modify(Long id) {
    // service.modify(id);
    service.modify2(id);
    return "redirect:/todos";
  }

}
