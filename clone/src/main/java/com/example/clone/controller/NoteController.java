package com.example.clone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clone.entity.dto.NoteDto;
import com.example.clone.service.NoteService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("api/v1/note")
@AllArgsConstructor
@Log4j2
public class NoteController {
  private NoteService service;
  
  @GetMapping("{num}")
  public ResponseEntity<?> get(@PathVariable Long num) {
      return ResponseEntity.ok().body(service.get(num));
  }

  @GetMapping("list")
  public ResponseEntity<?> list(String email) {
    log.error("list");
    log.error(email);
    return ResponseEntity.ok().body(service.list(email));
  }

  @PostMapping
  public ResponseEntity<?> write(@RequestBody NoteDto dto) {
    log.error("write");
    log.error(dto);
    service.write(dto);
    return ResponseEntity.ok().body("success");
  }
  
  @PutMapping("{num}")
  public String modify(@PathVariable Long num, @RequestBody NoteDto dto) {
    return service.modify(dto) > 0 ? "success" : "fail";
  }

  @DeleteMapping("{num}")
  public String remove(@PathVariable Long num){
    return service.remove(num) > 0 ? "success" : "fail";
  }

}
