package com.example.guestbook2.service;

import com.example.guestbook2.domain.dto.BoardDto;
import com.example.guestbook2.domain.dto.PageRequestDto;
import com.example.guestbook2.domain.dto.PageResultDto;
import com.example.guestbook2.domain.entity.Board;
import com.example.guestbook2.domain.entity.Member;

public interface BoardService {


  default Board toEntity(BoardDto dto){
    return Board.builder()
      .bno(dto.getBno())
      .title(dto.getTitle())
      .content(dto.getContent())
      .member(Member.builder()
        .email(dto.getMemberEmail())
        .name(dto.getMemberName())
        .build()
      )
      .build();
  }


  default BoardDto toDto(Object[] arr){
    if(arr == null) return null;
    
    BoardDto.BoardDtoBuilder builder = BoardDto.builder();

    boolean containBoard = false;
    for(Object o : arr){
      if(o == null) continue;
      System.out.println(o);
      Class<?> clazz = o.getClass();
      System.out.println(clazz);
      if(clazz == Long.class){
        builder.replyCnt(Long.parseLong(o.toString()));
      }
      else if(clazz == Member.class){
        builder.memberEmail(((Member)o).getEmail());
        builder.memberName(((Member)o).getName());
      }
      else if(clazz == Board.class){
        containBoard = true;
        Board b = (Board)o;
        builder.bno(b.getBno());
        builder.title(b.getTitle());
        builder.content(b.getContent());
        builder.regDate(b.getRegDate());
        builder.modDate(b.getModDate());
      }
    }

    return containBoard ? builder.build() : null;
  }

  Long register(BoardDto dto);
  BoardDto get(Long bno);

  PageResultDto<BoardDto, Object[]> list(PageRequestDto dto);
  void modify(BoardDto dto);
  void remove(Long bno);


}
