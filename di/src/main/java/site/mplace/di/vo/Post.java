package site.mplace.di.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
  private Long pno;
  private String title;
  private String writer;
  private LocalDateTime regdate;
}
