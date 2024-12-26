package com.example.guestbook2.domain.dto;

import java.time.LocalDateTime;

import com.example.guestbook2.domain.entity.Guestbook;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GuestbookModifyDto {
  private Long gno;
  private String title;
  private String writer;
  private String content;
  private LocalDateTime regDate;
  private LocalDateTime modDate;

  public Guestbook toEntity(){
    return Guestbook.builder()
      .gno(gno)
      .title(title)
      .content(content)
      .writer(writer)
      .build();
  }



}
