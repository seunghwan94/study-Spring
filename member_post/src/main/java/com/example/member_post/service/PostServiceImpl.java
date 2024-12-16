package com.example.member_post.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.member_post.dto.Criteria;
import com.example.member_post.mapper.AttachMapper;
import com.example.member_post.mapper.PostMapper;
import com.example.member_post.mapper.ReplyMapper;
import com.example.member_post.vo.Post;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class PostServiceImpl implements PostService {
	private PostMapper mapper;
	private AttachMapper attachMapper;
	private ReplyMapper replyMapper;

	@Override
	public int write(Post post) {
		mapper.insert(post);

		post.getAttachs().forEach(a->{
			a.setPno(post.getPno());
			attachMapper.insert(a);
		});
		return 0;
	}

	@Override
	public int modify(Post post) {
		return mapper.update(post);
	}
	
	@Override
	public int remove(Long pno) {
		attachMapper.delete(pno);
		replyMapper.deleteAll(pno);
		return mapper.delete(pno);
	}
	
	@Override
	public Post findBy(Long pno) {
		Post post = mapper.selectOne(pno);
		return post;
	}

	@Override
	public List<Post> list(Criteria cri) {
		return mapper.selectList(cri);
	}

	@Override
	public int count(Criteria cri) {
		return mapper.getCount(cri);
	}

	@Override
	public Post view(Long pno) {
		mapper.increaseViewCount(pno);
		Post post = mapper.selectOne(pno);
		post.setAttachs(attachMapper.selectList(pno));
		return post;
	}
}
