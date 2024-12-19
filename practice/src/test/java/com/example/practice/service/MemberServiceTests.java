package com.example.practice.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class MemberServiceTests {
  @Autowired
  private MemberService service;

  @Test
  public void memberTest(){
    log.info(service.list());
  }

  @Test
  public void selectOneTest(){
    log.info(service.findBy("test","123"));
  }
}
