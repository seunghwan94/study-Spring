package com.example.thymeleaf.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.thymeleaf.domain.entity.Todo;
import com.example.thymeleaf.domain.entity.User;


@SpringBootTest
public class TodoRepositoryTest {
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private TodoRepository repository;

  @Test
  public void testSave(){
    Optional<User> user = userRepository.findById(2L);
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
    Optional<Todo> todo = repository.findById(1L);
    assertTrue(todo.isPresent());
    
    repository.deleteById(todo.get().getTno());
    todo = repository.findById(1L);
    assertTrue(todo.isEmpty());
  }

}
