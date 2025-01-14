package com.example.clone.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.clone.security.util.JWTUtil;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class JWTTests {
  private JWTUtil jwtUtil;

  @BeforeEach
  public void init(){
    log.info("====================== testBefore");
    jwtUtil = new JWTUtil();
  }

  @Test
  public void testCreate() throws Exception{
    String email = "user100@a.com";
    String str = jwtUtil.generateToken(email);
    log.info(str);
    // eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3MzY4MTYwMTUsImV4cCI6MTczOTQ5NDQxNSwic3ViIjoidXNlcjEwMEBhLmNvbSJ9.HpOBVkIea2aD9BLyER-m80lg1Vo-ZEnyVUAks2vZ-Fw
  }

  @Test
  public void testVal() throws Exception{
    String email = "user100@a.com";
    String str = jwtUtil.generateToken(email);
    Thread.sleep(5000);
    String resultEmail = jwtUtil.validateExtract(str);
    log.info(resultEmail);
  }
}
