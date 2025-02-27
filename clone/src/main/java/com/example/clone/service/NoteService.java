package com.example.clone.service;

import java.util.List;
import java.util.Optional;

import com.example.clone.entity.Attach;
import com.example.clone.entity.Member;
import com.example.clone.entity.Note;
import com.example.clone.entity.dto.AttachDto;
import com.example.clone.entity.dto.NoteDto;


public interface NoteService{
  Optional<NoteDto> get(Long num);
  List<NoteDto> list(String email);
  List<NoteDto> listAll();
  NoteDto write(NoteDto dto);
  int modify(NoteDto dto);
  int remove(Long num);

  default Note toEntity(NoteDto dto){
    Note note = Note.builder()
      .num(dto.getNum())
      .title(dto.getTitle())
      .content(dto.getContent())
      .member( Member.builder()
        .mno(dto.getMemberMno())
        .email(dto.getMemberEmail())
        .name(dto.getMemberName())
      .build())
    .build();    
     
    note.setAttachs(dto.getAttachDtos().stream().map(a -> 
      Attach.builder()
        .uuid(a.getUuid())
        .origin(a.getOrigin())
        .image(a.isImage())
        .path(a.getPath())
        .size(a.getSize())
        .mime(a.getMime())
        .fileName(a.getFileName())
        .ext(a.getExt())
        .url(a.getUrl())
        .note(note)
      .build())
    .toList());
    return note;
  }

  default NoteDto toDto(Note note){
    return NoteDto.builder()
      .num(note.getNum())
      .title(note.getTitle())
      .content(note.getContent())
      .memberMno(note.getMember().getMno())
      .memberEmail(note.getMember().getEmail())
      .memberName(note.getMember().getName())
      .attachDtos(note.getAttachs().stream().map(a->
        AttachDto.builder()
          .uuid(a.getUuid())
          .origin(a.getOrigin())
          .image(a.isImage())
          .path(a.getPath())
          .size(a.getSize())
          .mime(a.getMime())
          .fileName(a.getFileName())
          .ext(a.getExt())
          .url(a.getUrl())
        .build()).toList())
    .build();
  }
}
