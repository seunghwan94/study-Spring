package com.example.member_post.mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class MemberMapperTests {
  @Autowired
  private MemberMapper mapper;

  @Test
  @DisplayName("MemberMapper 생성 여부 확인")
  public void testMapper(){
    assertNotNull(mapper,"메시지");
  }

  @Test
  public void testSignin(){
    log.info(mapper.selectOne("test"));
  }
}
