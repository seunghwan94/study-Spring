package com.example.thymeleaf.repositoryTests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.thymeleaf.domain.entity.Todo;
import com.example.thymeleaf.domain.entity.User;
import com.example.thymeleaf.repository.ReplyRepository;
import com.example.thymeleaf.repository.TodoRepository;
import com.example.thymeleaf.repository.UserRepository;


@SpringBootTest
public class TodoRepositoryTest {
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private ReplyRepository replyRepository;
  @Autowired
  private TodoRepository repository;

  @Test
  public void testSave(){
    Optional<User> user = userRepository.findById(4L);
    assert(user).isPresent();

    Todo saveTodo = repository.save(Todo.builder()
      .title("test")
      .content("연습")
      .user(user.get())
    .build());

    assertNotNull(saveTodo.getUser());
    assertNotNull(saveTodo.getUser().getUno());
  }

  @Test
  public void testUpdate(){
    Optional<User> user = userRepository.findById(2L);
    assert(user).isPresent();

    Todo saveTodo = repository.save(Todo.builder()
      .tno(user.get().getUno())
      .title("test")
      .content("연습")
      .user(user.get())
    .build());

    Optional<Todo> todo = repository.findById(saveTodo.getTno());
    
    assert(todo).isPresent();
    assertNotNull(todo.get().getTno());
  }

  @Test
  public void testSelectAll(){
    List<Todo> todos = repository.findAll();
    assertNotNull(todos);
    assertTrue(todos.size() > 0);
  }

  @Test
  public void testDelete(){
    // target
    Long tno = 8L;
    
    Optional<Todo> todo = repository.findById(tno);
    assertTrue(todo.isPresent());
    // when
    replyRepository.deleteByTodo(todo.get().getTno());
    repository.deleteById(todo.get().getTno());
    // then
    todo = repository.findById(tno);
    assertTrue(todo.isEmpty());
  }

}
