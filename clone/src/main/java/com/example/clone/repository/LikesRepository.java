package com.example.clone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.clone.entity.Likes;
import com.example.clone.entity.composite.LikesId;

public interface LikesRepository extends JpaRepository<Likes,LikesId> {
  
}
