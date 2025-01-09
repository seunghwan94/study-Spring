package com.example.thymeleaf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.thymeleaf.domain.entity.User;
import com.example.thymeleaf.service.UserService;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("api/v1/user")
@AllArgsConstructor
public class UserController {
  private UserService service;

  @GetMapping({"","/"})
  public ResponseEntity<?> list() {
      return ResponseEntity.ok().body(service.list());
  }
  
  @GetMapping("{uno}")
  public ResponseEntity<?> findBy(@PathVariable Long uno) {
      return ResponseEntity.ok().body(service.findById(uno));
  }
  
  @PostMapping
  public ResponseEntity<?> register(@RequestBody User user) {
    Long uno = service.write(user);
    return ResponseEntity.ok().body("User registered success: " + uno);
  }
  
  @PutMapping("{uno}")
  public ResponseEntity<?> modify(@RequestBody User user, @PathVariable Long uno) {
    User modifyUser = User.builder()
      .uno(uno)  
      .email(user.getEmail())
      .password(user.getPassword())
      .name(user.getName())
    .build();
    service.modify(modifyUser);
    return ResponseEntity.ok().body("success");
  }

  @DeleteMapping("{uno}")
  public ResponseEntity<?> remove(@PathVariable Long uno){
    service.remove(uno);
    return ResponseEntity.ok().body("success");
  }

}
