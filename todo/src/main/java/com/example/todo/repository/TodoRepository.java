package com.example.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.todo.domain.TodoEntity;

public interface TodoRepository extends JpaRepository<TodoEntity, Long>{
  @Modifying
  @Query("update todo t set t.done = true where t.id = :id")
  int updateTodoDoneById(@Param("id") Long id);

  List<TodoEntity> findByOrderByTaskDescIdAsc();
}
