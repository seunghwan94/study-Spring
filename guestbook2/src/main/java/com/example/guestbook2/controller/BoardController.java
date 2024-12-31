package com.example.guestbook2.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.guestbook2.domain.dto.BoardDto;
import com.example.guestbook2.domain.dto.PageRequestDto;
import com.example.guestbook2.service.BoardService;

import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;




@RestController
@RequestMapping("api/v1/board")
@Log4j2
public class BoardController {
  @Autowired
  private BoardService service;

  @GetMapping("list")
  public ResponseEntity<?> list(PageRequestDto dto) {
    return ResponseEntity.ok().body(service.list(dto));
  }

  @GetMapping("{bno}")
  public ResponseEntity<?> view(@PathVariable Long bno) {
    return ResponseEntity.ofNullable(service.get(bno));
  }
  @DeleteMapping("{bno}")
  public ResponseEntity<?> remove(@PathVariable Long bno) {
    service.remove(bno);
    return ResponseEntity.ok().body("success");
  }
  
  @PostMapping
  public ResponseEntity<?> register(@RequestBody BoardDto dto) {
    service.register(dto);
    return ResponseEntity.ok().body("success");
  }

  @PutMapping("{bno}")
  public ResponseEntity<?> modify(@RequestBody BoardDto dto, @PathVariable Long bno) {
    dto.setBno(bno);
    log.error(dto);
    service.modify(dto);
    return ResponseEntity.ok().body("success");
  }
  

  @GetMapping("test")
  public String test() {
    return "test";
  }
  



}
