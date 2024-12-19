package com.example.practice.service;

import java.util.List;

import com.example.practice.vo.Member;

public interface MemberService {
  // findBy
  Member findBy(String id, String pw);
  // list
  List<Member> list();
  // insert
  int add(Member member);
  // update
  int modify(Member member);
  // delete
  int remove(String id);
}
