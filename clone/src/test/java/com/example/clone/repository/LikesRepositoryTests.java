package com.example.clone.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.example.clone.entity.Likes;
import com.example.clone.entity.Member;
import com.example.clone.entity.Note;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class LikesRepositoryTests {
  @Autowired
  private LikesRepository repository;

  @Test
  @Transactional
  @Rollback(false)
  public void testSave(){
    
    Likes likes = Likes.builder()
      .member(Member.builder().mno(1L).build())
      .note(Note.builder().num(17L).build())
    .build();

    repository.save(likes);

  }

  @Test
  public void testDelete(){
    repository.delete(Likes.builder()
      .member(Member.builder().mno(1L).build())
      .note(Note.builder().num(17L).build())
    .build());
  }

  @Test
  public void testCountByNum() {
    repository.count(Example.of(Likes.builder().note(Note.builder().num(1L).build()).build()));
  }
}
