package com.example.clone.service;

import java.util.List;
import java.util.Optional;

import com.example.clone.entity.Member;
import com.example.clone.entity.Note;
import com.example.clone.entity.dto.NoteDto;


public interface NoteService{
  Optional<NoteDto> get(Long num);
  List<NoteDto> list(String email);
  List<NoteDto> listAll();
  NoteDto write(NoteDto dto);
  int modify(NoteDto dto);
  int remove(Long num);

  default Note toEntity(NoteDto dto){
    return Note.builder()
      .num(dto.getNum())
      .title(dto.getTitle())
      .content(dto.getContent())
      .member( Member.builder()
        .mno(dto.getMemberMno())
        .email(dto.getMemberEmail())
        .name(dto.getMemberName())
      .build())
    .build();
  }

  default NoteDto toDto(Note note){
    return NoteDto.builder()
      .num(note.getNum())
      .title(note.getTitle())
      .content(note.getContent())
      .memberMno(note.getMember().getMno())
      .memberEmail(note.getMember().getEmail())
      .memberName(note.getMember().getName())
    .build();
  }
}
