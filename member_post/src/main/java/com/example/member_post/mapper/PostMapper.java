package com.example.member_post.mapper;

import java.util.List;


import com.example.member_post.dto.Criteria;
import com.example.member_post.vo.Post;


public interface PostMapper {

	List<Post> selectList(Criteria cri);

	int insert(Post post);

	int update(Post post);

	int delete(Long pno);

	Post selectOne(Long pno);

	int getCount(Criteria cri);

	void increaseViewCount(Long pno);
	
	
	
}