package com.example.member_post.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.member_post.aop.annotation.MyPost;
import com.example.member_post.aop.annotation.SigninCheck;
import com.example.member_post.dto.Criteria;
import com.example.member_post.dto.PageDto;
import com.example.member_post.exception.UnsignedAuthException;
import com.example.member_post.service.PostService;
import com.example.member_post.vo.Member;
import com.example.member_post.vo.Post;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;




@Controller
@RequestMapping("post")
@AllArgsConstructor
@Log4j2
public class PostController {
  private PostService service;

  // // 예시
  // @GetMapping("list")
  // public String list(Criteria cri, Model model ) {
  //   model.addAttribute("posts", service.list(cri));
  //   model.addAttribute("pageDto", new PageDto(cri, service.count(cri)));
  //   return "forward:post/list";
  // }
  // 위에 코드가 이거랑 같음
  @GetMapping("list")
  public void list(Criteria cri, Model model ) {
    model.addAttribute("posts", service.list(cri));
    model.addAttribute("pageDto", new PageDto(cri, service.count(cri)));
  }
  

  @GetMapping("view")
  public void view(@ModelAttribute("cri") Criteria cri, Long pno, Model model){
    model.addAttribute("post",service.view(pno));
  }

  @GetMapping("write")
  @SigninCheck
  public void write(@ModelAttribute("cri") Criteria cri) { }
  
  @PostMapping("write")
  public String postWrite(Post post, Criteria cri) { 
    post.setCno(cri.getCategory());
    // service.write(post);
    log.error(post);
    return "redirect:list?" + cri.getQs2();

  }
  
  @GetMapping("modify")
  @SigninCheck
  public void modify(@RequestParam("pno") Long pno, Model model, Criteria cri,
   HttpSession session, @SessionAttribute(name = "member",required = false)  Member member, String writer) {
      Post post = service.findBy(pno);
     
      if(member == null || !member.getId().equals(post.getWriter())){
        throw new UnsignedAuthException("동일하지 않은 혹은 비로그인");
      }
    
    model.addAttribute("post", post);
  }
  




  @PostMapping("modify")
  @SigninCheck @MyPost
  public String postModify(Post post, Criteria cri) {
    service.modify(post);
    return "redirect:list?" + cri.getQs();
  }

  @RequestMapping("remove")
  public String remove(@RequestParam("pno") Long pno, Criteria cri) {
    service.remove(pno); 
    return "redirect:list?" + cri.getQs();
  }


}
