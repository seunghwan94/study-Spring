package com.example.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.thymeleaf.domain.entity.Reply;
import com.example.thymeleaf.domain.entity.Todo;
import com.example.thymeleaf.domain.entity.User;
import com.example.thymeleaf.repository.ReplyRepository;
import com.example.thymeleaf.repository.TodoRepository;
import com.example.thymeleaf.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService{
  private ReplyRepository repository;
  private TodoRepository todoRepository;
  private UserRepository userRepository;

  @Override
  public Reply findById(int rno) {
    Optional<Reply> relpyOpt = repository.findById(rno);
    if(!relpyOpt.isPresent()) return null;
    return relpyOpt.get();
  }

  @Override
  public List<Reply> list() {
    return repository.findAll();
  }
  
  @Override
  public int write(Reply reply) {
    return repository.save(reply).getRno();
  }
  
  @Override
  public void modify(Reply reply, int rno) {
    Optional<Todo> todo = todoRepository.findById(reply.getTodo().getTno());
    Optional<User> user = userRepository.findById(reply.getUser().getUno());

    Reply modifyReply = Reply.builder()
      .rno(rno)
      .text(reply.getText())
      .todo(todo.get())
      .user(user.get())
    .build();
    repository.save(modifyReply);
  }

  @Override
  public void remove(int rno) {
    repository.deleteById(rno);
  }

  

}
