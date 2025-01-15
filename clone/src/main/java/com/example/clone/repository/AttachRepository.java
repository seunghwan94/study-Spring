package com.example.clone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.clone.entity.Attach;

public interface AttachRepository extends JpaRepository<Attach, String>{
  
}
