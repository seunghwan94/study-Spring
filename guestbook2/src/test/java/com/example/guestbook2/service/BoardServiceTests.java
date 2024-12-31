package com.example.guestbook2.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.example.guestbook2.domain.dto.BoardDto;
import com.example.guestbook2.domain.dto.PageRequestDto;
import com.example.guestbook2.domain.dto.PageResultDto;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardServiceTests {
  @Autowired
  private BoardService service;

  @Test
  public void testGet(){
    log.info(service.get(1L));
  }

  @Test
  @Transactional // 트랜잭션 주기 (rollback;)
  public void testRegister(){
    // given 
    BoardDto dto = BoardDto.builder()
      .title("제목")
      .content("내용")
      .memberEmail("user11@test.com")
      .memberName("user11")
    .build();
    // when
    Long result = service.register(dto);
    // then
    assertNotNull(result);
  }
  @Test
  public void testList(){
    PageResultDto<BoardDto, Object[]> dto = service.list(PageRequestDto.builder().page(1).size(10).build());
    log.info(dto);
    dto.getDtoList().forEach(log::info);
  }

  @Test
  @Transactional
  @Rollback(false)
  // 이부분 수정해야 됨
  public void testModify(){
    BoardDto dto = service.get(1L);
    dto.setMemberEmail("user11@test.com");
    service.modify(dto);
  }

  @Test
  public void testRemove(){
    service.remove(3L);
  }
}
