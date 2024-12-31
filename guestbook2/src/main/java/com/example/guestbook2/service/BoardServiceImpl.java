package com.example.guestbook2.service;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.guestbook2.domain.dto.BoardDto;
import com.example.guestbook2.domain.dto.PageRequestDto;
import com.example.guestbook2.domain.dto.PageResultDto;
import com.example.guestbook2.domain.entity.Board;
import com.example.guestbook2.repository.BoardRepository;
import com.example.guestbook2.repository.ReplyRepository;

import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Service
@Data
@Log4j2
public class BoardServiceImpl implements BoardService{
  @Autowired
  private BoardRepository repository;
  @Autowired
  private ReplyRepository replyRepository;

  @Override
  public BoardDto get(Long bno) {
    return toDto((Object[])repository.getBoardByBno(bno));
  }

  @Override
  public Long register(BoardDto dto) {
    Board board = toEntity(dto);
    repository.save(board);
    return board.getBno();
  }

  @Override
  public PageResultDto<BoardDto, Object[]> list(PageRequestDto dto) {
    Pageable pageable = dto.getPageable(Sort.by(Direction.DESC, "bno"));
    
    Page<Object[]> page = repository.searchPage(dto.getType(),dto.getKeyword(), pageable);
    Function<Object[], BoardDto> fn = e -> toDto(e);
    PageResultDto<BoardDto, Object[]> resultDto = new PageResultDto<>(page, fn);
    return resultDto;
  }

  @Override
  public void modify(BoardDto dto) {
    Board board = toEntity(dto);
    repository.save(board);
  }

  @Override
  @Transactional
  public void remove(Long bno) {
    replyRepository.deleteByBoardBno(bno);
    repository.deleteById(bno);
  }

  
  
}
