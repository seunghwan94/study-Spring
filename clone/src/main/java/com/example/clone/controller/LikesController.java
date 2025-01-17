package com.example.clone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clone.entity.dto.LikesDto;
import com.example.clone.service.LikesService;

import lombok.extern.log4j.Log4j2;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("api/v1/likes")
@Log4j2
public class LikesController {
  @Autowired
  private LikesService service;  
  
  @GetMapping
  public boolean get(LikesDto dto){
    log.info(dto);
    return service.get(dto);
  }
  
  @PostMapping
  public ResponseEntity<?> postMethodName(@RequestBody LikesDto dto) {
    return ResponseEntity.ok().body(Map.of("result", service.toggle(dto)));
  }
}
