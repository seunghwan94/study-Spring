package com.example.thymeleaf.service;

import java.util.List;

import com.example.thymeleaf.domain.entity.User;

public interface UserService {
  User findById(Long uno);
  List<User> list();
  Long write(User user);

  void modify(User user);
  void remove(Long uno);
}
