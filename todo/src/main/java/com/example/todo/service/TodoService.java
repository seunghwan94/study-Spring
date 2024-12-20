package com.example.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todo.dto.TodoListDto;
import com.example.todo.dto.TodoWriteDto;
import com.example.todo.repository.TodoRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TodoService {
  private final TodoRepository repository;
  // 목록조회
  public List<TodoListDto> list(){
    return repository.findAll().stream().map(TodoListDto::new).toList();
  }
  // 등록
  public void writer(TodoWriteDto dto) {
    repository.save(dto.toEntity());
  }
  

  // 삭제

}
