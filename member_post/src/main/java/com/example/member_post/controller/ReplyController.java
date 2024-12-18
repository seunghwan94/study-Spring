package com.example.member_post.controller;


import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.member_post.dto.ReplyCri;
import com.example.member_post.service.ReplyService;
import com.example.member_post.vo.Member;
import com.example.member_post.vo.Reply;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("reply")
@Log4j2
@AllArgsConstructor
public class ReplyController{
  private ReplyService service;

  // 목록 조회
  // optional 은 포장한다. 타입 확인하려면 .get 으로 하고 isPresent() 사용해서 판단. => 대체는 orElse()사용한다.
  @GetMapping({"list/{pno}", "list/{pno}/{lastRno}", "list/{pno}/{lastRno}/{amount}"})
  public Map<?,?> list(
      @SessionAttribute(required = false,name = "member") Member member, 
      @PathVariable("pno") Long pno, 
      ReplyCri cri, 
      @PathVariable(required = false, name = "lastRno") Optional<Long> lastRno,
      @PathVariable(required = false, name="amount") Optional<Integer> amount){
    // null 인경우엔 10 들어가고 값이 있으면 그값으로 들어간다.
    // cri.setAmount(amount.orElse(10));
    cri.setAmount(amount.orElseGet(()->10));
    cri.setLastRno(lastRno.orElse(10L));
    log.info(cri);
    return service.list(pno, cri, member);
  }

  // 단일 조회
  @Operation(summary = "reply single select", description = "@PathVariavle인 rno값을 입력 받고 해당 댓글을 json으로 리턴")
  @GetMapping("view/{pno}")
  public Reply view(@PathVariable Long pno){
    return service.findBy(pno);
  }


  // 등록
  @PostMapping
  @Operation(summary = "댓글 작성", description = "댓글 작성을 위해 필요한 값을 전달 받음. content, writer, 게시글 번호"
    ,responses = {
      @ApiResponse(responseCode = "200", description = "작성성공", content = @Content(schema=@Schema(implementation = ResponseEntity.class)) ),
      @ApiResponse(responseCode = "500", description = "작성실패")
    })
  public ResponseEntity<?> write(@RequestBody Reply reply){
    return service.write(reply) > 0 ? ResponseEntity.ok().body("success") : ResponseEntity.internalServerError().build();
  }

  // 수정
  @PutMapping
  public ResponseEntity<?> modify(@RequestBody Reply reply) {
    return service.modify(reply) > 0 ? ResponseEntity.ok().body("success") : ResponseEntity.internalServerError().build();
  }


  // 삭제
  @DeleteMapping("{rno}")
  public ResponseEntity<?> remove(@PathVariable Long rno) {
    return service.remove(rno) > 0 ? ResponseEntity.ok().body("success") : ResponseEntity.internalServerError().build();
  }

}