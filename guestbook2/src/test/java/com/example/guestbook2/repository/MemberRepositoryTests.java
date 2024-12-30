package com.example.guestbook2.repository;

import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.annotation.Rollback;

import com.example.guestbook2.domain.entity.Member;


import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class MemberRepositoryTests {
  @Autowired
  private MemberRepository repository;

  @Test
  @DisplayName("글 작성 테스트 만들기") // 실제 보여질 test name
  @Transactional
  @Rollback(false)
  public void testInsert() {
    Member member = Member.builder()
      .email("t@s.c")
      .password("123")
      .name("새똥이")
      .build();
    repository.save(member);
  }

  @Test
  @DisplayName("글 작성 테스트 데이터 만들기") // 실제 보여질 test name
  @Transactional // 트랜잭션 주기 (rollback;)
  @Rollback(false)
  public void testInsertMany() {

    IntStream.rangeClosed(2, 100).forEach(i-> {
      Member member = Member.builder()
        .email("user"+i+"@test.com")
        .password("123")
        .name("user"+i)
        .build();
      repository.save(member);
    });
  
  }

}
