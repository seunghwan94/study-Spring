package com.example.clone.repository;

import java.util.stream.LongStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.example.clone.entity.Member;
import com.example.clone.entity.Note;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
@Transactional
public class NoteRepositoryTests {
  @Autowired
  private NoteRepository repository;

  @Test
  public void testExist(){
    log.info(repository);
  }

  @Test
  @Rollback(false)
  public void testSave(){
    LongStream.rangeClosed(1, 5).boxed().map(l->
      Note.builder()
        .title("제목"+l)
        .content("내용"+l)
        .member(Member.builder()
          .mno(100L)
          .build()
        ).build()).forEach(repository::save);
  }

  @Test
  public void testOne(){
    log.info(repository.findByNum(1L));
  }

  @Test
  public void testListMon(){
    repository.findByMemberMno(100L).forEach(log::info);
  }

  @Test
  public void testListEmail(){
    repository.findByMemberEmail("user100@a.com").forEach(log::info);
  }

  @Test
  public void testFindNotesBy(){
    repository.findNotesBy("user100@a.com").forEach(log::info);
  }

}
