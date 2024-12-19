package com.example.practice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.practice.vo.Member;

@Mapper
public interface MemberMapper {
  @Select("select * from tbl_member")
  List<Member> select();

  @Select("select * from tbl_member where id = #{id} and pw = #{pw}")
  Member selectOne(@Param("id") String id, @Param("pw") String pw);

  @Delete("delete from tbl_member where id = #{id}")
  int delete(@Param("id") String id);

  int insert(Member member);

  int update(Member member);
  
  
}