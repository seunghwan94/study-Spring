package com.example.guestbook2.domain.dto;

import com.example.guestbook2.domain.entity.GuestbookEntity;

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
public class GuestbookWriteDto {
  private Long gno;
  private String title;
  private String writer;
  private String content;

  public GuestbookEntity toEntity(){
    return GuestbookEntity.builder()
      .gno(gno)
      .title(title)
      .content(content)
      .writer(writer)
      .build();
  }


}
