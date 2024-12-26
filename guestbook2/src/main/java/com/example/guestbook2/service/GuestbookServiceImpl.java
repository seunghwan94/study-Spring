package com.example.guestbook2.service;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.guestbook2.domain.dto.GuestbookDto;
import com.example.guestbook2.domain.dto.GuestbookModifyDto;
import com.example.guestbook2.domain.dto.GuestbookViewDto;
import com.example.guestbook2.domain.dto.PageRequestDto;
import com.example.guestbook2.domain.dto.PageResultDto;
import com.example.guestbook2.domain.entity.Guestbook;
import com.example.guestbook2.repository.GuestbookRepository;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Service
@AllArgsConstructor
@Log4j2
public class GuestbookServiceImpl implements GuestbookService{
  private GuestbookRepository repository;

  @Override
  public GuestbookViewDto get(Long gno) {
    Optional<Guestbook> opt = repository.findById(gno);
    if(!opt.isPresent()){
      return null;
    }
    return new GuestbookViewDto(opt.get());
  }

  
  @Override
  public PageResultDto<GuestbookDto, Guestbook> list(PageRequestDto dto) {
    Pageable pageable = dto.getPageable(Sort.by(Direction.DESC, "gno"));
    Page<Guestbook> page = repository.findAll(pageable);
    Function<Guestbook, GuestbookDto> fn = e -> toDto(e);
    PageResultDto<GuestbookDto, Guestbook> resultDto = new PageResultDto<>(page, fn);
    return resultDto;
  }

  @Override
  public void modify(GuestbookModifyDto dto) {
    repository.save(dto.toEntity());
  }

  @Override
  public void remove(Long gno) {
    repository.deleteById(gno);
  }


  @Override
  public Long write(GuestbookDto dto) {
    Guestbook guestbook = toEntity(dto);

    log.info(guestbook);
    repository.save(guestbook);
    log.info(guestbook);

    return guestbook.getGno();
  }
  
}
