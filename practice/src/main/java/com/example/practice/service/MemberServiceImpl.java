package com.example.practice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.practice.mapper.MemberMapper;
import com.example.practice.vo.Member;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService{
  private MemberMapper mapper;

  @Override
  public List<Member> list() {
    return mapper.select();
  }

  @Override
  public Member findBy(String id, String pw) {
    return mapper.selectOne(id, pw);
  }

  @Override
  public int add(Member member) {
    return mapper.insert(member);
  }

  @Override
  public int modify(Member member) {
    return mapper.update(member);
  }

  @Override
  public int remove(String id) {
    return mapper.delete(id);
  }
}