package com.example.guestbook2.repository;

import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.example.guestbook2.domain.entity.Guestbook;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

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
      return Guestbook.builder()
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

    Optional<Guestbook> opt = repository.findById(gno);
    if(!opt.isPresent()){
      return;
    }
    Guestbook entity = opt.get();
    Guestbook modifiedEntity = Guestbook.builder()
      .gno(entity.getGno())
      .title(entity.getTitle())
      .content("변경된 내용")
      .writer(entity.getWriter())
      .build();
    repository.save(modifiedEntity);
  }
  @Test
  public void testModify2(){
    Optional<Guestbook> opt = repository.findById(1L);
    opt.ifPresent(e -> {
      Guestbook modifiedEntity = Guestbook.builder()
      .gno(e.getGno())
      .title(e.getTitle())
      .content("변경된 내용")
      .writer(e.getWriter())
      .build();
    repository.save(modifiedEntity);
    });
  }

  @Test
  public void testQuerydsl(){
    // Pageable pageable = PageRequest.of(2, 2, Sort.by(Direction.DESC, "gno"));
    
    // // q도메인에 대한 객체 취득 방식
    // QGuestbook entity = QGuestbook.guestbook;

    // String keyword = "제";

    // // where절에 값넣기위한 조건이 들어가는 builder 
    // BooleanBuilder builder = new BooleanBuilder();
    // // entity가 정보를 알고 있기 때문에 contains... BooleanExpression 타입으로 사용해서 표현
    // BooleanExpression expression = entity.title.contains(keyword);
    // // // 기존에 있던 where 조건에 and를 넣어 추가한다. (여기서 추가한다.) 
    // // builder.and(expression);
    // // builder.or(expression);
    // // // 이것도 가능 (위 아래 같음)
    // builder.and(expression).or(expression);

    // Page<Guestbook> result = repository.findAll(builder, pageable);
    // result.forEach(log::info);

  }
}
