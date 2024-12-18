package com.example.member_post.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.member_post.dto.Criteria;
import com.example.member_post.service.PostService;
import com.example.member_post.vo.MyVo;
import com.example.member_post.vo.Post;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestParam;


// @Controller
@RestController // Controller 역할, 소유한 모든 메서드의 반환형태 @ResponseBody
@RequestMapping("oldreply")
@Log4j2
public class OldReplyController {
  // 중요 어노테이션
  // @RequestBody
  // @PathVariable
  
  // @ResponseBody
  @RequestMapping("test")
  public String test(){
    log.info("도착 지점 확인 reply/test");
    return "hello";
  }

  // void String ResponseEntity
  // entity: 개체
  @RequestMapping("re")
  public ResponseEntity<String> re(){
    // return ResponseEntity.status(200).build();
    // return ResponseEntity.notFound().build(); // 404
    // return ResponseEntity.ok("my re");
    // return ResponseEntity.ok().build();
    return new ResponseEntity<String>("본문", HttpStatus.NOT_FOUND);
  }

  @GetMapping(value = "arr")
  public int[] getMethodName() {
      return new int[] {3,4,5,6};
  }
  
  @GetMapping("list")
  public List<String> list() {
    List<String> list = new ArrayList<>();
    list.add("가");
    list.add("나");
    list.add("다");
    list.add("라");
    list.add("마");
    return list;
  }

  @GetMapping("map")
  public Map<String,String> map() {
    Map<String,String> map = new HashMap<>();
    map.put("1", "하나");
    map.put("2", "둘");
    map.put("3", "셋");
    map.put("4", "넷");
    return map;
  }
  @GetMapping("Students")
  public List<?> students() {
    List<Map<?,?>> list = new ArrayList<>();
    Map<String,Object> map = new HashMap<>();

    map.put("no", 1);
    map.put("name", "새똥이");
    map.put("score", 100);
    list.add(map);
    
    map = new HashMap<>();
    map.put("no", 2);
    map.put("name", "개똥이");
    map.put("score", 80);
    list.add(map);

    return list;
  }
  @Autowired
  private PostService service;
  @GetMapping("post")
  public Post post() {
    return service.findBy(170L);
  }

  // http://localhost:9999/reply/postList
  @Autowired
  private Criteria cri;
  @GetMapping("postList")
  public List<Post> postList() {
    return service.list(cri);
  }

  // http://localhost:9999/reply/mypost?title=sss
  @GetMapping("mypost")
  public Post myPost(Post post) {
      return post;
  }
  
  // http://localhost:9999/reply/p1?arr=1&arr=2
  @GetMapping("p1")
  public int[] p1(@RequestParam("arr") int[] arr) {
      return arr;
  }

  // http://localhost:9999/reply/p2?arr=1&arr=2
  @GetMapping("p2")
  public List<?> p2(@RequestParam("arr") List<?> list) {
      return list;
  }

  // http://localhost:9999/reply/myvo?data=1234&posts%5B3%5D.title=제목?
  @GetMapping("myvo")
  public MyVo mv(MyVo myVo) {
      return myVo;
  }

  // 전역설정
  @InitBinder
  public void init(WebDataBinder binder){
    binder.registerCustomEditor(Data.class, new CustomDateEditor(new SimpleDateFormat("yyyy_MM_dd"),false));
  }

  
}
