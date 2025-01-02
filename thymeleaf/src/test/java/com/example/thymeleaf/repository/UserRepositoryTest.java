package com.example.thymeleaf.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.thymeleaf.domain.entity.User;


@SpringBootTest
public class UserRepositoryTest {
  @Autowired
  private UserRepository repository;

  @Test
  public void testSave(){
    User saveUser = repository.save(User.builder()
      .email("test")
      .password("1234")
      .name("연습")
    .build());

    Optional<User> user = repository.findById(saveUser.getUno());

    assert(user).isPresent();
    assertNotNull(user.get().getUno());
  }


  @Test
  public void testUpdate(){
    User saveUser = repository.save(User.builder()
      .uno(1L)
      .email("test1")
      .password("1234")
      .name("연습")
    .build());

    Optional<User> user = repository.findById(saveUser.getUno());
    
    assert(user).isPresent();
    assertNotNull(user.get().getUno());
  }

  @Test
  public void testSelectAll(){
    List<User> users = repository.findAll();
    assertNotNull(users);
    assertTrue(users.size() > 0);
  }

  @Test
  public void testDelete(){
    Optional<User> user = repository.findById(1L);
    assertTrue(user.isPresent());
    
    repository.deleteById(user.get().getUno());
    user = repository.findById(1L);
    assertTrue(user.isEmpty());
  }

}
