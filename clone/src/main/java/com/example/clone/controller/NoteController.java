package com.example.clone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.clone.entity.dto.NoteDto;
import com.example.clone.service.NoteService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
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
  
  @SuppressWarnings("unchecked")
  @GetMapping("{num}")
  public ResponseEntity<?> get(@PathVariable("num") Long num) {
    log.error("get 확인");
    return service.get(num).map(ResponseEntity::ok)
      .orElseGet(() -> {
        Map<String, Object> ret = new HashMap<>();
        ret.put("code", 404);
        ret.put("message", "NOT_FOUND");
        ResponseEntity<?> entity = new ResponseEntity<>(ret, HttpStatus.NOT_FOUND);
        return (ResponseEntity<NoteDto>) entity;
      });
    // 오류날때 전역 처리해야된다. RestController advice를 thorw로 해야된다.
  }

  @GetMapping("list")
  public ResponseEntity<?> list(@RequestParam("email") String email) {
    log.error("list");
    log.error(email);
    return ResponseEntity.ok().body(service.list(email));
  }

  @GetMapping("listall")
  public ResponseEntity<?> list() {
    return ResponseEntity.ok().body(service.listAll());
  }

  @PostMapping
  public ResponseEntity<?> write(@RequestBody NoteDto dto) {
    log.error("write");
    service.write(dto);
    return ResponseEntity.ok().body("success");
  }
  
  @PutMapping("{num}")
  public String modify(@PathVariable("num") Long num, @RequestBody NoteDto dto) {
    return service.modify(dto) > 0 ? "success" : "fail";
  }

  @DeleteMapping("{num}")
  public String remove(@PathVariable("num") Long num){
    return service.remove(num) > 0 ? "success" : "fail";
  }

}
