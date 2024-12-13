package com.example.member_post.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@Alias("post")
public class Post {
	private final Long pno;
	private final int cno;
	private final String title;
	private final String writer;
	private final String content;
	private final Long viewCount;
	private final Date createDate;
	private final Date updateDate;
	private final boolean attachFlag;
	
	@Builder.Default
	private List<Attach> attachs = new ArrayList<>();


	public Post(Long pno, int cno, String title, String writer, String content, Long viewCount, Date createDate,
			Date updateDate,boolean attachFlag) {
		this.pno = pno;
		this.cno = cno;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.viewCount = viewCount;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.attachFlag = attachFlag;
	}
	
	
}
