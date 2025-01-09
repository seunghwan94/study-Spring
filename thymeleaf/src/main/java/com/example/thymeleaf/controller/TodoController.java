package com.example.thymeleaf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.thymeleaf.domain.entity.Todo;
import com.example.thymeleaf.service.TodoService;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("api/v1/todo")
@AllArgsConstructor
public class TodoController {
  private TodoService service;

  @GetMapping({"","/"})
  public ResponseEntity<?> list() {
    return ResponseEntity.ok().body(service.list());
  }

  @GetMapping("{tno}")
  public ResponseEntity<?> findBy(@PathVariable Long tno) {
      return ResponseEntity.ok().body(service.findById(tno));
  }
  
  @PostMapping
  public ResponseEntity<?> register(@RequestBody Todo todo) {
    service.write(todo);
    return ResponseEntity.ok().body("success");
  }

  @PutMapping("{tno}")
  public ResponseEntity<?> modify(@PathVariable Long tno, @RequestBody Todo todo) {
    service.modify(todo, tno);
    return ResponseEntity.ok().body("success");
  }
  
  @DeleteMapping("{tno}")
  public ResponseEntity<?> remove(@PathVariable Long tno){
    service.remove(tno);
    return ResponseEntity.ok().body("success");
  }

}
