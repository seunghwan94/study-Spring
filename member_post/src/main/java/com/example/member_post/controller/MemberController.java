package com.example.member_post.controller;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.member_post.service.MemberService;
import com.example.member_post.vo.Member;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
@RequestMapping("member")
@Log4j2
@AllArgsConstructor
public class MemberController {
  // return type
  //   String : "해당위치의 jsp" (ex: /WEB-INF/views/member/signin.jsp)로 forward
  //   void : 접속 requestURL 위치 반환 (/member) forward

  private MemberService service;

  // /member/signin
  @RequestMapping(value = "signin", method = RequestMethod.GET)
  public void signin() { }

  @PostMapping("signin")
  public String postSignin(
    Member member,
    @Nullable @RequestParam(required = false, value = "remember-id") String remember,
    HttpSession session, Model model, RedirectAttributes rttr, HttpServletResponse resp) {
  // public String postSignin(Member member,@Nullable @RequestParam("remember-id") String remember) {
      log.info(remember);
      log.info(member);

      if(service.login(member.getId(), member.getPw())){
        // 성공
        // 1. 세션에 member라는 이름의 attribute
        session.setAttribute("member", service.findBy(member.getId()));
        // 1-1. 아이디 저장시 cookie에 remember-id 저장
        Cookie cookie = new Cookie("remember-id", member.getId());
        cookie.setPath("/");
        if(remember != null){
          cookie.setMaxAge(60 * 60 * 24 * 7);
        }else{
          cookie.setMaxAge(0);
        }
        resp.addCookie(cookie);

        // 2. redirect index
        return "redirect:/";
      }else{
        // 실패
        // return "redirect:signin?msg=failed";

        // // model은 일반적인 포워드를 하기위 해사용한다. get 방식에만 사용
        // model.addAttribute("msg","failed");
        
        // redirect를 위한 rttr 이다.
        // //1. 쿼리스트링 사용
        // rttr.addAttribute("msg","failed");
        
        // // 2. 1회성 사용
        rttr.addFlashAttribute("msg", "failed");
        return "redirect:signin";
      }
  }

  @RequestMapping("logout")
  public String requestMethodName(HttpSession session) {
    session.invalidate();  
    return "redirect:/";
  }
  
  @GetMapping("signup")
  public void signup() { }

  @PostMapping("signup")
  public String postSignup(Member member) {
    service.register(member);
    return "redirect:signin";
  }
  
  
}
