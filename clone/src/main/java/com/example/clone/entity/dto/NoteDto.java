package com.example.clone.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
}
