package com.example.guestbook2.service;


import com.example.guestbook2.domain.dto.GuestbookDto;
import com.example.guestbook2.domain.dto.PageRequestDto;
import com.example.guestbook2.domain.dto.PageResultDto;
import com.example.guestbook2.domain.entity.Guestbook;
import com.example.guestbook2.domain.entity.QGuestbook;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

public interface GuestbookService {
  Long write(GuestbookDto dto);

  PageResultDto<GuestbookDto, Guestbook> list(PageRequestDto dto);


  void modify(GuestbookDto dto);
  void remove(Long gno);

  GuestbookDto read(Long gno);



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

  private BooleanBuilder getSearch(PageRequestDto dto){
    String type = dto.getType();
    BooleanBuilder builder = new BooleanBuilder();
    QGuestbook qGuestbook = QGuestbook.guestbook;
    BooleanExpression expression = qGuestbook.gno.gt(0L);
    builder.and(expression);
    if(type == null || type.trim().isEmpty()){
      return builder;
    }
    
    BooleanBuilder conditionBuilder = new BooleanBuilder();
    String keyword = dto.getKeyword();
    if(type.contains("T")){
      conditionBuilder.or(qGuestbook.title.contains(type));
    }
    if(type.contains("C")){
      conditionBuilder.or(qGuestbook.content.contains(type));
    }
    if(type.contains("W")){
      conditionBuilder.or(qGuestbook.writer.contains(type));
    }
    builder.and(conditionBuilder);
    return builder;
  }
  
}
