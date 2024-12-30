package com.example.guestbook2.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.guestbook2.domain.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, String>{
  
}
