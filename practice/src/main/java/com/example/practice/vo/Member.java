package com.example.practice.vo;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Alias("member")
@AllArgsConstructor
public class Member {
  private String id;
	private String pw;
	private String name;
	private String email;
	private String roadAddr;
	private String detailAddr;
	private Date createDate;
}
