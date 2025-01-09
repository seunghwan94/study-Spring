package com.example.thymeleaf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.thymeleaf.domain.entity.Reply;
import com.example.thymeleaf.service.ReplyService;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("api/v1/reply")
@AllArgsConstructor
public class ReplyController {
  private ReplyService service;

  @GetMapping({"","/"})
  public ResponseEntity<?> list() {
    return ResponseEntity.ok().body(service.list());
  }

  @GetMapping("{rno}")
  public ResponseEntity<?> findBy(@PathVariable int rno) {
    return ResponseEntity.ok().body(service.findById(rno));
  }
  
  @PostMapping
  public ResponseEntity<?> register(@RequestBody Reply reply) {
    service.write(reply);
    return ResponseEntity.ok().body("success");
  }

  @PutMapping("{rno}")
  public ResponseEntity<?> modify(@PathVariable int rno, @RequestBody Reply reply) {
    service.modify(reply, rno);    
    return ResponseEntity.ok().body("success");
  }

  @DeleteMapping("{rno}")
  public ResponseEntity<?> remove(@PathVariable int rno){
    service.remove(rno);
    return ResponseEntity.ok().body("success");
  }
  

}
