package com.example.clone.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class SecurityTests {
  @Autowired
  private PasswordEncoder passwordEncoder;

  @Test
  public void testEncoder(){
    log.info(passwordEncoder);
    log.info(passwordEncoder.getClass().getName());

    String pw = "1234";
    String encode = passwordEncoder.encode(pw);
    log.info(pw);
    log.info(encode);
    log.info(passwordEncoder.matches(pw, encode));
    log.info(passwordEncoder.matches(pw, "$2a$10$UbvqDHBiM7rYl/.Z1n2i1uytHMTd1kGqT0FeE.9rc2dAHa/8o1mpG"));
  }

}
