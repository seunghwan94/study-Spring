package com.example.thymeleaf.controllerTests;

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

@SpringBootTest
public class UserControllerTests {
  private MockMvc mockMvc;

  @BeforeEach
  public void init(WebApplicationContext ctx){
    mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
  }

  @Test
  public void testList() throws Exception{
    mockMvc.perform(get("/api/v1/user/"))
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
    .andDo(print());
  }

  @Test
  public void testFindBy() throws Exception{
    mockMvc.perform(get("/api/v1/user/2"))
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
    .andDo(print());
  }

  @Test
  public void testRepository() throws Exception{
    String jsonStr = "{\r\n" + //
                     "    \"email\" : \"user11@test.com\",\r\n" + //
                     "    \"password\" : \"1234\",\r\n" + //
                     "    \"name\" : \"수정이름\"\r\n" + //
                     "}";
    mockMvc.perform(post("/api/v1/user")
      .content(jsonStr)
      .contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
    .andDo(print());
  }

  @Test
  public void testModify() throws Exception{
    String jsonStr = "{\r\n" + //
                     "    \"email\" : \"user11@test.com\",\r\n" + //
                     "    \"password\" : \"1234\",\r\n" + //
                     "    \"name\" : \"수정이름2\"\r\n" + //
                     "}";
    mockMvc.perform(put("/api/v1/user/12")
      .content(jsonStr)
      .contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
    .andDo(print());
  }

  @Test
  public void testRemove() throws Exception{
    mockMvc.perform(delete("/api/v1/user/12")
      .contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
    .andDo(print());
  }

}
