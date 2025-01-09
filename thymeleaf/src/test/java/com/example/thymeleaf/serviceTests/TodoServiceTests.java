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

import com.example.thymeleaf.domain.entity.Todo;
import com.example.thymeleaf.domain.entity.User;
import com.example.thymeleaf.repository.UserRepository;
import com.example.thymeleaf.service.TodoService;


@SpringBootTest
public class TodoServiceTests {
  @Autowired
  private UserRepository repository;
  @Autowired
  private TodoService service;

  @Test
  public void testList(){
    // when
    List<Todo> todo = service.list();
    // then
    assertTrue(todo.size() > 0);
  }

  @Test
  public void testWrite(){
    // target
    Long uno = 9L;
    // get
    Optional<User> userOpt = repository.findById(uno);
    assertTrue(userOpt.isPresent());
    
    Todo todo = Todo.builder()
      .title("service")
      .content("practice")
      .user(userOpt.get())
    .build();
    // when
    Long tno = service.write(todo);
    // then
    assertTrue(tno > 0);
  }

  @Test
  public void testModify(){
    // target
    Long tno = 2L;
    // get
    Todo todo = service.findById(tno);
    Todo modifyTodo = Todo.builder()
      .tno(todo.getTno())
      .title("수정제목")
      .content("수정내용")
      .user(todo.getUser())
    .build();
    // when
    service.modify(modifyTodo,tno);
    // then
    todo = service.findById(tno);
    assertEquals("수정제목",todo.getTitle());
    assertEquals("수정내용",todo.getContent());
  }

  @Test
  public void testRemove(){
    // target
    Long tno = 4L;
    // get
    Todo todo = service.findById(tno);
    assertNotNull(todo);
    // when
    service.remove(todo.getTno());
    // then
    todo = service.findById(tno);
    assertNull(todo);
  }

}
