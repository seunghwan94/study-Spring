package com.example.guestbook2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/todo")
// @CrossOrigin("http://localhost:3000")
public class ApiController {
  
  @GetMapping("list")
  // @CrossOrigin(origins = "http://localhost:3000")
  public List<?> todo() throws InterruptedException{
    List<?> list = IntStream.rangeClosed(1, 3).boxed().map(i->{
      Map<String, Object> map = new HashMap<>();
      map.put("id", i);
      map.put("content", "내용");
      map.put("writer", "작성자");
      map.put("regDate", LocalDateTime.now());
      return map;
    }).toList();

    Thread.sleep(3000);
    return list;

  }
}
