package com.example.guestbook2.repository;

import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.guestbook2.domain.entity.GuestbookEntity;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class GuestbookRepositoryTests {
  @Autowired
  private GuestbookRepository repository;

  // @Test
  // public void testExist(){
  //   log.info(guestbookRepository);
  // }
  @Test
  public void testInsert() {
    repository.saveAll(
    IntStream.rangeClosed(1, 300).mapToObj(i->{
      return GuestbookEntity.builder()
        .title("제목"+i)
        .content("내용"+i)
        .writer("작성자"+(i % 10)) 
        .build();
    }).toList());
  }

  @Test
  public void testSelectList(){
    repository.findAll().forEach(log::info);
  }

  @Test
  public void testSelectOne(){
    log.info(repository.findById(1L));
  }

  @Test
  public void testModify(){
    Long gno = 1L;

    Optional<GuestbookEntity> opt = repository.findById(gno);
    if(!opt.isPresent()){
      return;
    }
    GuestbookEntity entity = opt.get();
    GuestbookEntity modifiedEntity = GuestbookEntity.builder()
      .gno(entity.getGno())
      .title(entity.getTitle())
      .content("변경된 내용")
      .writer(entity.getWriter())
      .build();
    repository.save(modifiedEntity);
  }
  @Test
  public void testModify2(){
    Optional<GuestbookEntity> opt = repository.findById(1L);
    opt.ifPresent(e -> {
      GuestbookEntity modifiedEntity = GuestbookEntity.builder()
      .gno(e.getGno())
      .title(e.getTitle())
      .content("변경된 내용")
      .writer(e.getWriter())
      .build();
    repository.save(modifiedEntity);
    });
  }
}
