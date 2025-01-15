package com.example.clone.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.example.clone.entity.Attach;
import com.example.clone.entity.Note;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class AttacheRepositoryTests {
  @Autowired
  private AttachRepository repository;

  @Test
  @Transactional
  @Rollback(false)
  public void testSave(){
  for(int i = 0 ; i < 5; i++){
    Attach attach = Attach.builder()
      .uuid(""+i)
      .origin("test")
      .image(false)
      .note(Note.builder().num(21L).build())
    .build();
    repository.save(attach);
    }
  }

}
