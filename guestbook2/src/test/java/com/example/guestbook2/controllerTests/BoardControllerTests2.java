package com.example.guestbook2.controllerTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;



@SpringBootTest
@AutoConfigureMockMvc
public class BoardControllerTests2 {
  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testTest() throws Exception{
    mockMvc.perform(get("/api/v1/board/test"));
  }
}
