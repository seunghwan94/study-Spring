package com.example.guestbook2.domain.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardDto {
  private Long bno;
  private String titile;
  private String content;
  private String memberEmail;
  private String memberName;
  private LocalDateTime regDate;
  private LocalDateTime modDate;
  private int replyCnt;
}
