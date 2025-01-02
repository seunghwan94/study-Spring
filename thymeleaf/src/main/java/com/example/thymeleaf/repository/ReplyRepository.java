package com.example.thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.thymeleaf.domain.entity.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Integer>{
  
}
