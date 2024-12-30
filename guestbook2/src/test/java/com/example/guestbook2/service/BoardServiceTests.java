package com.example.guestbook2.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardServiceTests {
  @Autowired
  private BoardService service;

  @Test
  public void testGet(){
    log.info(service.get(2L));
  }

}
