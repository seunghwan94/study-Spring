package com.example.thymeleaf.service;

import java.util.List;

import com.example.thymeleaf.domain.entity.Reply;

public interface ReplyService {
  Reply findById(int rno);
  List<Reply> list();
  int write(Reply reply);

  void modify(Reply reply, int rno);
  void remove(int rno);
}
