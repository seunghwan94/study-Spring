package com.example.guestbook2.repository;

import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.annotation.Rollback;

import com.example.guestbook2.domain.entity.Board;
import com.example.guestbook2.domain.entity.Reply;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ReplyRepositoryTests {
  @Autowired
  private ReplyRepository repository;

  @Test
  @DisplayName("글 작성 테스트 데이터 만들기") // 실제 보여질 test name
  @Transactional // 트랜잭션 주기 (rollback;)
  @Rollback(false)
  public void testInsertMany() {

    IntStream.rangeClosed(1, 500).forEach(i-> {
      Reply reply = Reply.builder()
        .text("text"+"1234")
        .replayer("replyer"+i)
        .board(Board.builder().bno( 0L+((int)(Math.random() * 99+1))).build())
        .build();
      repository.save(reply);
    });
  
  }

  @Test
  public void testSelectOne(){
    Reply reply = repository.findById(1L).orElse(null);
    log.info(reply);
    // 댓글의 작성글의 작성자 이름 출력
    log.info(reply.getBoard().getMember().getName());
    
  }

  @Test
  public void testDelete(){

  }

  @Test
  @Transactional
  @Rollback(false)
  public void testDeleteByBno(){
    repository.deleteByBoardBno(2L);
  }
}
