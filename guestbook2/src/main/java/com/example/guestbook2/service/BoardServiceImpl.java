package com.example.guestbook2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.guestbook2.domain.dto.BoardDto;
import com.example.guestbook2.domain.entity.Board;
import com.example.guestbook2.repository.BoardRepository;

import lombok.Data;

@Service
@Data
public class BoardServiceImpl implements BoardService{
  @Autowired
  private BoardRepository repository;

  @Override
  public BoardDto get(Long bno) {
    return toDto(repository.getBoardByBno(bno));
  }

  @Override
  public Long register(BoardDto dto) {
    Board board = toEntity(dto);
    repository.save(board);
    return board.getBno();
  }
  
}
