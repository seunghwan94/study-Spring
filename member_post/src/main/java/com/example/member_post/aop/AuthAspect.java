package com.example.member_post.aop;


import java.io.IOException;
import java.net.URLEncoder;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.example.member_post.vo.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Aspect
@Component
@AllArgsConstructor
@Log4j2
public class AuthAspect {
  private HttpSession session;
  private HttpServletRequest req;
  private HttpServletResponse resp;

  @Before("@annotation(com.example.member_post.aop.MyPost)")
  public void myPost(JoinPoint joinPoint) { 
    Object obj= session.getAttribute("member");
    String id = ((Member) obj).getId(); // 현재로그인 사용자

    Object[] args = joinPoint.getArgs();
    // String writerParam = myPost.value();


    // if(obj == null || ((Member)obj).getId().equals(post.getWriter())){
    //   throw new RuntimeException("본인 게시글 아님");
    // }
  }

  @Before("@annotation(com.example.member_post.aop.SigninCheck)")
  public void signinCheck(JoinPoint jp) throws IOException{
    String url = "/member/signin?url=" + URLEncoder.encode(req.getRequestURI() + "?" + req.getQueryString(), "utf-8");

    if (session.getAttribute("member") == null ){
      resp.sendRedirect("/msg?msg=" + URLEncoder.encode("로그인이 필요한 페이지 입니다.", "utf-8")+ "&url="+url);
    }
  }

}
