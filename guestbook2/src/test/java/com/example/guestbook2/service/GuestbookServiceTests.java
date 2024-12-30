package com.example.guestbook2.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.guestbook2.domain.dto.GuestbookDto;
import com.example.guestbook2.domain.dto.PageRequestDto;
import com.example.guestbook2.domain.dto.PageResultDto;
import com.example.guestbook2.domain.entity.Guestbook;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class GuestbookServiceTests {
  @Autowired
  private GuestbookService service;

  @Test
  @DisplayName("글 작성 서비스 테스트") // 실제 보여질 test name
  @Transactional // 트랜잭션 주기 (rollback;)
  public void testWrite(){
    GuestbookDto dto = GuestbookDto.builder()
      .title("연습2")
      .content("내용3")
      .writer("test")
    .build();
    Long gno = service.write(dto);
    assertNotNull(gno);
  }

  @Test
  public void testList(){
    // PageRequestDto dto = new PageRequestDto();
    PageRequestDto dto = PageRequestDto.builder().page(1).size(10).type("TC").keyword("!제목").build();
    PageResultDto<GuestbookDto, Guestbook> resultDto = service.list(dto);
    log.info(resultDto);

    resultDto.getDtoList().forEach(log::info);
    // service.list(new PageRequestDto(10, 10)).getDtoList().forEach(log::info);

  }

  // @Test
  // public void testListPage(){
  //   PageResultDto<GuestbookDto,Guestbook> dto = service.list(new PageRequestDto(2,10));
  //   log.info(dto);
  //   dto.getPageList().forEach(log::info);
  // }
}
