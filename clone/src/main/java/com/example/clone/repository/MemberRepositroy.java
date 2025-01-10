package com.example.clone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.clone.entity.Member;


public interface MemberRepositroy extends JpaRepository<Member,Long>{
  Member findByEmail(String email);
  Member findByEmailAndFromSocial(String email, Boolean fromSocial);
}
