package com.example.thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.thymeleaf.domain.entity.User;

/*
 * JpaRepository<User, Long>
 *   (JPA) CRUD(Create, Read, Update, Delete) 작업 및 페이징, 정렬 같은 기능 제공
 *   User => entity
 *   Long => User ID Type
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
  
}
