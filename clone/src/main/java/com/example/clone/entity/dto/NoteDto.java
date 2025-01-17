package com.example.clone.entity.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder.Default;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NoteDto {
  private Long num;
  private String title;
  private String content;
  private Long memberMno;
  private String memberEmail;
  private String memberName;
  private long likesCnt;
  private long AttachCnt;

  @Default
  private List<AttachDto> attachDtos = new ArrayList<>();
}
