package com.example.guestbook2.service;

import com.example.guestbook2.domain.dto.BoardDto;
import com.example.guestbook2.domain.entity.Board;
import com.example.guestbook2.domain.entity.Member;

public interface BoardService {


  default Board toEntity(BoardDto dto){
    return Board.builder()
      .bno(dto.getBno())
      .title(dto.getTitile())
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
    for(Object o : arr){
      Class<?> clazz = o.getClass();
      if(clazz == int.class || clazz == Integer.class){
        builder.replyCnt(Integer.parseInt(o.toString()));
      }
      else if(clazz == Member.class){
        builder.memberEmail(((Member)o).getEmail());
        builder.memberName(((Member)o).getName());
      }
      else if(clazz == Board.class){
        Board b = (Board)o;
        builder.bno(b.getBno());
        builder.titile(b.getTitle());
        builder.content(b.getContent());
        builder.regDate(b.getRegDate());
        builder.modDate(b.getModDate());
      }
    }

    return builder.build();
  }

  Long register(BoardDto dto);
  BoardDto get(Long bno);

}
