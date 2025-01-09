package com.example.clone.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.ToString;


// entity 전역 설정 방법
@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
@Getter
@ToString
public class BaseEntity {
  
  @CreatedDate
  @Column(name = "regdate", updatable = false) // 내부적으로 수정 못하게 하는 updatable
  private LocalDateTime regDate;
  
  @LastModifiedDate
  @Column(name = "moddate")
  private LocalDateTime modDate;
  
}
