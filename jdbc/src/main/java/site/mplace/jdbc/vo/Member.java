package site.mplace.jdbc.vo;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Member {
  private String id;
  private String pw;
  private String name;
  private String email;
  private String road_addr;
  private String detail_addr;
  private LocalDateTime create_date;
}
