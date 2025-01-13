package com.example.clone.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.clone.entity.Member;
import com.example.clone.entity.dto.NoteDto;
import com.example.clone.repository.MemberRepositroy;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class NoteServiceTests {
  @Autowired
  private NoteService service;
  @Autowired
  private MemberRepositroy repositroy;

  @Test
  public void testGet(){
    log.info(service.get(1L));
  }

  @Test
  public void testList(){
    log.info(service.list("user100@a.com"));
  }

  @Test
  public void testWrite(){
    Member member = repositroy.findByEmail("user100@a.com");

    log.info(service.write(
      NoteDto.builder()
        .title("title")
        .content("content")
        .memberMno(member.getMno())
        .memberEmail(member.getEmail())
        .memberName(member.getName())
      .build()
    ));
  }

  @Test
  public void testModify(){
    // Member member = repositroy.findByEmail("user100@a.com");

    log.info(service.modify(
      NoteDto.builder()
        .num(10L)
        .title("titl2")
        .content("content")
        .memberMno(100L)
      .build()
    ));
  }

  @Test
  public void testRemove(){
    log.info(service.remove(8L));
  }

}
