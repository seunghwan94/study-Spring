package com.example.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.thymeleaf.domain.entity.Todo;
import com.example.thymeleaf.domain.entity.User;
import com.example.thymeleaf.repository.ReplyRepository;
import com.example.thymeleaf.repository.TodoRepository;
import com.example.thymeleaf.repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor
@Log4j2
public class UserServiceImpl implements UserService{
  private UserRepository userRepository;
  private TodoRepository todoRepository;
  private ReplyRepository replyRepository;

  @Override
  public User findById(Long uno) {
    Optional<User> todoOpt = userRepository.findById(uno);
    if(!todoOpt.isPresent()) return null;
    return todoOpt.get();
  }

  @Override
  public List<User> list() {
    return userRepository.findAll();
  }
  
  @Override
  public Long write(User user) {
    return userRepository.save(user).getUno();
  }
  
  @Override
  public void modify(User user) {
    userRepository.save(user);
  }

  @Override
  public void remove(Long uno) {
    List<Todo> todos = todoRepository.findByUser_Uno(6L);
    todos.forEach((todo)->{
      replyRepository.deleteByTodo(todo.getTno());
    });
    replyRepository.deleteByUser(uno);

    todoRepository.deleteByUser(uno);
    
    userRepository.deleteById(uno);
  }

  

}
