package com.example.practice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.practice.service.MemberService;
import com.example.practice.vo.Member;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("member")
@AllArgsConstructor
@Log4j2
public class MemberController {
  private MemberService service;

  @GetMapping("list")
  public List<Member> list() {
      return service.list();
  }

  // http://localhost:9999/member/findBy?id=test&pw=123
  @GetMapping("findBy")
  public Member findBy(
    @RequestParam("id") String id,
    @RequestParam("pw") String pw, 
    HttpSession session) {
      Member member = service.findBy(id,pw);
      session.setAttribute("member", member);
      return member;
  }

  @PostMapping
  public int add(@SessionAttribute(name = "member", required = false) Member member) {
    log.info(member);
    return service.add(member);
  }

  @PutMapping
  public int modi(@SessionAttribute(name = "member", required = false) Member member) {
    log.info(member);
    return service.modify(member);
  }
  
  @DeleteMapping
  public int remove(@RequestParam("id") String id){
    return service.remove(id);
  }
  
}
