package com.example.guestbook2.repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;

import com.example.guestbook2.domain.entity.Board;
import com.example.guestbook2.domain.entity.Member;


import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {
  @Autowired
  private BoardRepository repository;

  @Test
  @DisplayName("글 작성 테스트 만들기") // 실제 보여질 test name
  @Transactional
  @Rollback(false)
  public void testInsert() {
    // Board board = Board.builder()
    //   .title("title")
    //   .content("123")
    //   .member(Member.builder().email("user@test.com").build())
    //   .build();
    // repository.save(board);
  }

  @Test
  @DisplayName("글 작성 테스트 데이터 만들기") // 실제 보여질 test name
  @Transactional // 트랜잭션 주기 (rollback;)
  @Rollback(false)
  public void testInsertMany() {

    IntStream.rangeClosed(2, 100).forEach(i-> {
      Board board = Board.builder()
        .title("title"+i)
        .content("123")
        .member(Member.builder().email("user"+i+"@test.com").build())
        .build();
      repository.save(board);
    });
  
  }

  @Test
  @Transactional // 필요할때만 상위 객체를 가져올때 사용한다. 이게 있으면 (entity쪽 tostring 및 fetch lazy 해야됨)
  public void testSelectOne(){
    Board board = repository.findById(2L).get();
    log.info(board);
    log.info(board.getMember()); // 이걸 실행할때만 tbl_member 쿼리를 실행하고, 이게 없으면 tbl_member쪽은 실행안한다.
  }

  @Test
  public void testGetBoardWithMember(){
    Object result = repository.getBoardWithMember(2L);
    Object[] arr = (Object[]) result;
    log.info(Arrays.toString(arr));
    
  }

  @Test
  public void testGetBoardWithReply(){
    List<Object[]> result = repository.getBoardWithReply(2L);
    result.forEach(arr -> log.info(Arrays.toString(arr)));
  }

  @Test
  public void testGetBoardWithReplyCounf(){
    Pageable pageable = PageRequest.of(0, 10, Sort.by(Direction.DESC,"bno"));
    Page<Object[]> result = repository.getBoardWithReplyCounf(pageable);
    result.forEach(arr -> log.info(Arrays.toString(arr)));
  }

  @Test
  public void testGetBoardByBno(){
    Object[] result = (Object[])repository.getBoardByBno(2L);
    log.info(result);
  }

  @Test
  public void testSearch1(){
    repository.search1();
  }

  @Test
  public void testSearchPage(){
    // repository.searchPage("T","제목",PageRequest.ofSize(10));
    repository.searchPage("T","제목",PageRequest.of(0,10,Sort.by(Direction.DESC, "bno", "title")));
  }
}
