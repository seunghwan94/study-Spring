package com.example.thymeleaf.domain.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.ToString;

/*
 * @MappedSuperclass
 *    (JPA) 공통적으로 사용할 필드나 메서드를 정의할 때 사용, 
 *    createdDate, modifiedDate 등 사용하기 위한 목적
 * @EntityListeners(value = AuditingEntityListener.class)
 *    (JPA) Listener 설정 - Auditing 기능(@CreatedDate, @LastModifiedDate)을 활성화
 *    엔티티의 생성, 수정 이벤트 발생 시 자동으로 시간 정보를 기록
 * 
 * ※ 중요
 * application class - @EnableJpaAuditing 추가하여 Auditing 기능 전역으로 활성화
 */

@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
@Getter
@ToString
public abstract class BaseEntity {
  @CreatedDate
  @Column(name = "regdate", updatable = false) 
  private LocalDateTime regDate;

  @LastModifiedDate
  @Column(name = "moddate")
  private LocalDateTime modDate;
}
