package com.example.guestbook2.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.guestbook2.domain.entity.Board;
import com.example.guestbook2.repository.search.SearchBoardRepository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>, SearchBoardRepository{
  // jpql 사용 한다.
  @Query("select b, m  from tbl_board b left join member m where b.bno = :bno")
  Object getBoardWithMember(@Param("bno") Long bno);
  
  @Query("select b,r from tbl_board b left join tbl_reply r on b = r.board where b.bno = :bno")
  List<Object[]> getBoardWithReply(@Param("bno") Long bno);

  @Query(value = "select count(r), b, m from tbl_board b\r\n" + //
                  "left join member m\r\n" + //
                  "left join tbl_reply r on b = r.board\r\n" + //
                  "group by b"
    ,countQuery = "select count(b) from tbl_board b"
    ) // nativeQuery = true : jpql기능을 없에겠다.(가능하면 사용 X)
  Page<Object[]> getBoardWithReplyCounf(Pageable pageable);


  @Query("select count(r), m, b\r\n" + //
          "FROM tbl_board b\r\n" + //
          "left join member m\r\n" + //
          "left join tbl_reply r on b = r.board\r\n" + //
          "where b.bno = :bno")
  Object getBoardByBno(@Param("bno") Long bno);


}
