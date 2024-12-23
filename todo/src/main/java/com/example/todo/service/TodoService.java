package com.example.todo.service;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.todo.domain.TodoEntity;
import com.example.todo.dto.TodoListDto;
import com.example.todo.dto.TodoWriteDto;
import com.example.todo.repository.TodoRepository;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TodoService {
  private final TodoRepository repository;
  private EntityManager manager;

  @PostConstruct
  public void init(){
    repository.saveAll(
      Stream.of(
        TodoEntity.builder().task("첫일").build(),
        TodoEntity.builder().task("둘일").build(),
        TodoEntity.builder().task("셋일").build()
      ).toList()
    );
  }

  // 목록조회
  public List<TodoListDto> list(){
    // 1. 기본
    // return repository.findAll().stream().map(TodoListDto::new).toList();
    // 2. 정렬
    // return repository.findAll(Sort.by(Direction.DESC, "task","id")).stream().map(TodoListDto::new).toList();
    // 3. Repository 수정 (다른방식의 정렬) 
    // return repository.findByOrderByTaskDescIdAsc().stream().map(TodoListDto::new).toList();
    // 4. sort 다른방식 
    return repository.findAll(Sort.by(Order.desc("task"))).stream().map(TodoListDto::new).toList();
  }
  // 등록
  public void writer(TodoWriteDto dto) {
    repository.save(dto.toEntity());
  }
  // 삭제
  public void remove(Long id){
    // repository.delete(TodoEntity.builder().id(id).build());
    repository.deleteById(id);
  }

  // 수정
  @Transactional
  public void modify(Long id) {
    // Optional<TodoEntity> entitiy = repository.findById(id);
    // // null 아닐 때 (비영속)
    // entitiy.ifPresent(e-> {
    //   e.setDone(true);
    //   // (영속화)
    //   repository.save(e);
    // });
    repository.updateTodoDoneById(id);
  }

  // 수정2
  @Transactional
  public void modify2(Long id){
    manager.find(TodoEntity.class, id).setDone(true);
  }
}
