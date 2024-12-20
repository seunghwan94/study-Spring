package com.example.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.todo.dto.TodoWriteDto;
import com.example.todo.service.TodoService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@AllArgsConstructor
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
  
}
