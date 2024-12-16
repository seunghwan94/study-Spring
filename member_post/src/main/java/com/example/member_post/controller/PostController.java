package com.example.member_post.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.member_post.dto.Criteria;
import com.example.member_post.dto.PageDto;
import com.example.member_post.service.PostService;
import com.example.member_post.vo.Post;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;



@Controller
@RequestMapping("post")
@AllArgsConstructor
@Log4j2
public class PostController {
  private PostService service;

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
  public void write(@ModelAttribute("cri") Criteria cri) { }
  
  @PostMapping("write")
  public String postWrite(Post post, Criteria cri) { 
    log.info(post);
    log.info(cri);
    post.setCno(cri.getCategory());
    service.write(post);
    return "redirect:list?" + cri.getQs2();

  }
  
}
