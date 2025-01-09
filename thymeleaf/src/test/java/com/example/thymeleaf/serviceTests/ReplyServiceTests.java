package com.example.thymeleaf.serviceTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.thymeleaf.domain.entity.Reply;
import com.example.thymeleaf.domain.entity.Todo;
import com.example.thymeleaf.domain.entity.User;
import com.example.thymeleaf.repository.TodoRepository;
import com.example.thymeleaf.repository.UserRepository;
import com.example.thymeleaf.service.ReplyService;


@SpringBootTest
public class ReplyServiceTests {
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private TodoRepository todoRepository;
  @Autowired
  private ReplyService service;

  @Test
  public void testList(){
    // when
    List<Reply> relpy = service.list();
    // then
    assertTrue(relpy.size() > 0);
  }

  @Test
  public void testWrite(){
    // target
    Long uno = 6L;
    Optional<User> userOpt = userRepository.findById(uno);
    assertNotNull(userOpt.isPresent());

    Long tno = 12L;
    Optional<Todo> todoOpt = todoRepository.findById(tno);
    assertNotNull(todoOpt.isPresent());
    
    // get
    Reply relpy = Reply.builder()
      .text("email@naver.com")
      .todo(todoOpt.get())
      .user(userOpt.get())
    .build();
    // when
    int rno = service.write(relpy);
    // then
    assertTrue(rno > 0);
  }

  @Test
  public void testModify(){
    // target
    int rno = 2;
    // get
    Reply relpy = service.findById(rno);
    Reply modifyReply = Reply.builder()
      .rno(relpy.getRno())
      .text("email@naver.com")
      .todo(relpy.getTodo())
      .user(relpy.getUser())
    .build();
    // when
    service.modify(modifyReply,rno);
    // then
    relpy = service.findById(rno);
    assertEquals("email@naver.com",relpy.getText());
  }

  @Test
  public void testRemove(){
    // target
    int rno = 11;
    // get
    Reply relpy = service.findById(rno);
    assertNotNull(relpy);
    // when
    service.remove(relpy.getRno());
    // then
    relpy = service.findById(rno);
    assertNull(relpy);
  }
}
