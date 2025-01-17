package com.example.clone.service;

import com.example.clone.entity.Likes;
import com.example.clone.entity.Member;
import com.example.clone.entity.Note;
import com.example.clone.entity.dto.LikesDto;

public interface LikesService {
  boolean toggle(LikesDto dto);
  boolean get(LikesDto dto);

  default Likes toEntity(LikesDto dto){
    return Likes.builder()
      .member(Member.builder().mno(dto.getMno()).build())
      .note(Note.builder().num(dto.getNum()).build())
    .build();
  }

  default LikesDto toDto(Likes likes){
    return LikesDto.builder()
      .email(likes.getMember().getEmail())
      .mno(likes.getMember().getMno())
      .modDate(likes.getModDate())
      .regDate(likes.getRegDate())
      .num(likes.getNote().getNum())
    .build();
  }

}
