package com.example.thymeleaf.serviceTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.thymeleaf.domain.entity.User;
import com.example.thymeleaf.service.UserService;

@SpringBootTest
public class UserServiceTests {
  @Autowired
  private UserService service;

  @Test
  public void testList(){
    // when
    List<User> user = service.list();
    // then
    assertTrue(user.size() > 0);
  }

  @Test
  public void testWrite(){
    // get
    User user = User.builder()
      .email("email@naver.com")
      .password("1234")
      .name("testCode")
    .build();
    // when
    Long uno = service.write(user);
    // then
    assertTrue(uno > 0);
  }

  @Test
  public void testModify(){
    // target
    Long uno = 2L;
    // get
    User user = service.findById(uno);
    User modifyUser = User.builder()
      .uno(user.getUno())
      .email("email@naver.com")
      .password("1234")
      .name("testCode")
    .build();
    // when
    service.modify(modifyUser);
    // then
    user = service.findById(uno);
    assertEquals("email@naver.com",user.getEmail());
    assertEquals("1234",user.getPassword());
  }

  @Test
  public void testRemove(){
    // target
    Long uno = 6L;
    // get
    User user = service.findById(uno);
    assertNotNull(user);
    // when
    service.remove(user.getUno());
    // then
    user = service.findById(uno);
    assertNull(user);
  }
}
