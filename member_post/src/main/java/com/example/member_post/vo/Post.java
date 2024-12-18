package com.example.member_post.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Alias("post")
public class Post {
	private  Long pno;
	private  Integer cno;
	private  String title;
	private  String writer;
	private  String content;
	private  Long viewCount;

	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private  Date createDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private  Date updateDate;
	
	private  boolean attachFlag;
	private List<Attach> attachs = new ArrayList<>();

	
	
}
