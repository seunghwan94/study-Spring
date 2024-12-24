package com.example.guestbook2.repository;

import java.util.Optional;

import org.apache.logging.log4j.message.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.guestbook2.domain.entity.GuestbookEntity;

@Repository
public interface GuestbookRepository extends JpaRepository<GuestbookEntity, Long>
// , QuerydslPredicateExecutor<GuestbookEntity>
{

  Message save(Optional<GuestbookEntity> findbook);
  
}
