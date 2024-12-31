package com.example.guestbook2.controllerTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;



// @SpringBootTest
// @WebMvcTest() // 핵심 키워드기 때문에
@SpringBootTest
public class BoardControllerTests1 {
  // mock (초안)
  private MockMvc mockMvc;
  
  @BeforeEach
  public void init(WebApplicationContext ctx){
    mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
  }

  @Test
  public void testTest() throws Exception{
    mockMvc.perform(get("/api/v1/board/test"))
      .andExpect(status().isOk())
      // .andExpect(content().string("test1")); // 이러면 오류
      .andExpect(content().string("test"));
  }
  
  @Test
  public void testList() throws Exception{
    mockMvc.perform(get("/api/v1/board/list")
      .param("page", "3")
      .param("size", "5")
      .param("type", "TC")
      .param("keyword", "제목")
    )
    .andExpect(status().isOk())
    .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
  }

  @Test
  public void testRegister() throws Exception{
    String jsonStr = "{\r\n" + //
                  "    \"title\" : \"수정된 제목\",\r\n" + //
                  "    \"content\" : \"등록\",\r\n" + //
                  "    \"memberEmail\" : \"user11@test.com\"\r\n" + //
                  "}";

    mockMvc.perform(post("/api/v1/board")
      .content(jsonStr)
      .contentType(MediaType.APPLICATION_JSON))
    .andDo(print());
  }

  @Test
  public void testModify() throws Exception{
    String jsonStr = "{\r\n" + //
                  "    \"title\" : \"수정된 제목\",\r\n" + //
                  "    \"content\" : \"등록\",\r\n" + //
                  "    \"memberEmail\" : \"user11@test.com\"\r\n" + //
                  "}";

    mockMvc.perform(put("/api/v1/board/1")
      .content(jsonStr).param("bno","1")
      .contentType(MediaType.APPLICATION_JSON))
    .andDo(print());
  }

}
