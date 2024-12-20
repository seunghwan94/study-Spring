package com.example.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo.domain.TodoEntity;

public interface TodoRepository extends JpaRepository<TodoEntity, Long>{
  
}
