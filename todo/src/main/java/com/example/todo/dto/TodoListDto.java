package com.example.todo.dto;

import com.example.todo.domain.TodoEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TodoListDto {
  private Long id;
  private String task;
  private boolean done;

  public TodoListDto(TodoEntity entity){
    this.id = entity.getId();
    this.task = entity.getTask();
    this.done = entity.isDone();
  }

  // dto >> entity
  public TodoEntity toEntity(){
    return TodoEntity.builder().id(id).task(task).done(done).build();
  }
}
