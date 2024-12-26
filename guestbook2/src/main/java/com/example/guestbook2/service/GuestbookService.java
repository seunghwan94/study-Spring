package com.example.guestbook2.service;


import com.example.guestbook2.domain.dto.GuestbookDto;
import com.example.guestbook2.domain.dto.GuestbookModifyDto;
import com.example.guestbook2.domain.dto.GuestbookViewDto;
import com.example.guestbook2.domain.dto.PageRequestDto;
import com.example.guestbook2.domain.dto.PageResultDto;
import com.example.guestbook2.domain.entity.Guestbook;

public interface GuestbookService {
  Long write(GuestbookDto dto);

  PageResultDto<GuestbookDto, Guestbook> list(PageRequestDto dto);


  void modify(GuestbookModifyDto dto);
  void remove(Long gno);

  GuestbookViewDto get(Long gno);

  // interface를 구체화시키는 방법 두가 지 static default
  // dto >>> entity 변환 메서드 정의
  default Guestbook toEntity(GuestbookDto dto){
    return Guestbook.builder()
      .gno(dto.getGno())
      .title(dto.getTitle())
      .content(dto.getContent())
      .writer(dto.getWriter())
      .build();
  }

  // dto가 필요하다는거는 화면쪽에 뿌릴예정이다.
  // entity >>> dto 변환 메서드 정의
  default GuestbookDto toDto(Guestbook guestbook){
    return GuestbookDto.builder()
      .gno(guestbook.getGno())
      .title(guestbook.getTitle())
      .content(guestbook.getContent())
      .writer(guestbook.getWriter())
      .regDate(guestbook.getRegDate())
      .modDate(guestbook.getModDate())
      .build();
  }

}
