package com.example.member_post.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;


import com.example.member_post.dto.Criteria;
import com.example.member_post.mapper.AttachMapper;
import com.example.member_post.mapper.PostMapper;
import com.example.member_post.utils.Mybatisinit;
import com.example.member_post.vo.Post;

public class PostServiceImpl implements PostService {
//	public static void main(String[] args) {
//		new PostServiceImpl().write(Post.builder().title("제목").content("내용").writer("test").cno(2).build());
//		
//	}
	
	@Override
	public int write(Post post) {
		try(SqlSession session =  Mybatisinit.getInstance().sqlSessionFactory().openSession(true)){
			PostMapper mapper = session.getMapper(PostMapper.class);
			AttachMapper attachMapper = session.getMapper(AttachMapper.class);
			
			mapper.insert(post);
			post.getAttachs().forEach(a->{
				a.setPno(post.getPno());
				attachMapper.insert(a);
			});
			
			return 0;
		}
	}
	@Override
	public int modify(Post post) {
		try(SqlSession session =  Mybatisinit.getInstance().sqlSessionFactory().openSession(true)){
			PostMapper mapper = session.getMapper(PostMapper.class);
			return mapper.update(post);
		}
	}
	@Override
	public int remove(Long pno) {
		try(SqlSession session =  Mybatisinit.getInstance().sqlSessionFactory().openSession(true)){
			PostMapper mapper = session.getMapper(PostMapper.class);
			AttachMapper attachMapper = session.getMapper(AttachMapper.class);
			attachMapper.delete(pno);
			return mapper.delete(pno);
		}
	}
	@Override
	public Post findBy(Long pno) {
		try(SqlSession session =  Mybatisinit.getInstance().sqlSessionFactory().openSession(true)){
			
			PostMapper mapper = session.getMapper(PostMapper.class);
			Post post = mapper.selectOne(pno);
			return post;
		}
	}
	@Override
	public List<Post> list(Criteria cri) {
		try(SqlSession session =  Mybatisinit.getInstance().sqlSessionFactory().openSession(true)){
			PostMapper mapper = session.getMapper(PostMapper.class);
			return mapper.selectList(cri);
		}
	}
	@Override
	public int count(Criteria cri) {
		try(SqlSession session =  Mybatisinit.getInstance().sqlSessionFactory().openSession(true)){
			PostMapper mapper = session.getMapper(PostMapper.class);
			return mapper.getCount(cri);
		}
	}
	@Override
	public Post view(Long pno) {
		try(SqlSession session =  Mybatisinit.getInstance().sqlSessionFactory().openSession(true)){
			PostMapper mapper = session.getMapper(PostMapper.class);
			AttachMapper attachMapper = session.getMapper(AttachMapper.class);
			mapper.increaseViewCount(pno);
			Post post = mapper.selectOne(pno);
			post.setAttachs(attachMapper.selectList(pno));
			return post;
		}
	}
	
	
}
