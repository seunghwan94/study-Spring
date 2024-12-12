package com.example.member_practice.ex03_DI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentTests {
  @Autowired
  private StudentService service;

  @Test
  public void testRun(){
    service.run();
  }
}
