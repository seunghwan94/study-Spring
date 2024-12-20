package com.example.todo.dto;

import com.example.todo.domain.TodoEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TodoWriteDto {
  private Long id;
  private String task;
  private boolean done;

  public TodoWriteDto(TodoEntity entity){
    this.id = entity.getId();
    this.task = entity.getTask();
    this.done = entity.isDone();
  }

  // dto >> entity
  public TodoEntity toEntity(){
    return TodoEntity.builder().task(task).build();
  }
}
