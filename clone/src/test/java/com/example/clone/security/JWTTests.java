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
    // eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3MzY3NTE1NTgsImV4cCI6MTczOTQyOTk1OCwic3ViIjoidXNlcjEwMEBhLmNvbSJ9._4ezdNKtHsoB8Er9FeZT3gpG-KdfbgouxY4eO-1803s
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
