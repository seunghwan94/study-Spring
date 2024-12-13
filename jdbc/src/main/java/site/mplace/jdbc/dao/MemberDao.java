package site.mplace.jdbc.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import site.mplace.jdbc.vo.Member;

@Component
@AllArgsConstructor
public class MemberDao {
  private JdbcTemplate jdbcTemplate;

  public String getTime(){
    return jdbcTemplate.queryForObject("select now()", String.class);
  }

  // create
  public int register(Member member){
    return jdbcTemplate.update("insert into tbl_member (id,pw,name) values(?,?,?)",
    member.getId(),member.getPw(), member.getName());
  }

  // // select 
  // public List<Map<String, Object>> selectList(){
  //   return jdbcTemplate.queryForList("select * from tbl_member");
  // }

  // // selectOne
  // public Map<String, Object> selectOne(String id){
  //   // jdbcTemplate.queryForMap();
  //   return jdbcTemplate.queryForMap("select * from tbl_member where id = ?", new Object[] {id});
  // }

  // select 
  public List<Member> selectList(){
    return jdbcTemplate.query("select * from tbl_member", new MyMapper());
  }
  // selectOne
  public Member selectOne(String id){
    return jdbcTemplate.queryForObject("select * from tbl_member where id = ?", new MyMapper(), id);
  }

  // update
  public int update(Member member){
    return jdbcTemplate.update("update tbl_member set pw = ?, name = ? where id = ?", member.getPw(),member.getName(),member.getId() );
  }
  // delete
  public int delete(String id){
    return jdbcTemplate.update("delete from tbl_member where id = ?", id);
  }





  class MyMapper implements RowMapper<Member>{

    // mybits에서 reusltMap 이라고 생각하면된다.
    @Override
    @Nullable
    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
      return Member
        .builder()
        .id(rs.getString("id"))
        .pw(rs.getString("pw"))
        .name(rs.getString("name"))
        .email(rs.getString("email"))
        .road_addr(rs.getString("road_addr"))
        .detail_addr(rs.getString("detail_addr"))
        .create_date(rs.getTimestamp("create_date").toLocalDateTime())
        .build();
    }
    
  }
}
