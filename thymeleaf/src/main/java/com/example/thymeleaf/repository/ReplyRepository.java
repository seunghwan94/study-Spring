package com.example.thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.thymeleaf.domain.entity.Reply;


@Repository
public interface ReplyRepository extends JpaRepository<Reply, Integer>{
  
  @Modifying
  @Transactional
  @Query("DELETE FROM tbl_reply r WHERE r.todo.tno = :tno")
  void deleteByTodo(@Param("tno") Long tno);

  @Modifying
  @Transactional
  @Query("DELETE FROM tbl_reply r WHERE r.user.uno = :uno")
  void deleteByUser(@Param("uno") Long uno);

}
