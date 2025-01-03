package com.example.guestbook2.service;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.guestbook2.domain.dto.GuestbookDto;
import com.example.guestbook2.domain.dto.PageRequestDto;
import com.example.guestbook2.domain.dto.PageResultDto;
import com.example.guestbook2.domain.entity.Guestbook;
import com.example.guestbook2.domain.entity.QGuestbook;
import com.example.guestbook2.repository.GuestbookRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Service
@AllArgsConstructor
@Log4j2
public class GuestbookServiceImpl implements GuestbookService{
  private GuestbookRepository repository;

  @Override
  public GuestbookDto read(Long gno) {
    Optional<Guestbook> opt = repository.findById(gno);
    return opt.isPresent() ? toDto(opt.get()) : null;
  }

  
  @Override
  public PageResultDto<GuestbookDto, Guestbook> list(PageRequestDto dto) {
    Pageable pageable = dto.getPageable(Sort.by(Direction.DESC, "gno"));
    BooleanBuilder booleanBuilder = getSearch(dto);
    
    Page<Guestbook> page = repository.findAll(booleanBuilder,pageable);
    Function<Guestbook, GuestbookDto> fn = e -> toDto(e);
    PageResultDto<GuestbookDto, Guestbook> resultDto = new PageResultDto<>(page, fn);
    return resultDto;
  }

  @Override
  public void modify(GuestbookDto dto) {
    repository.save(toEntity(dto));
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
  




  private BooleanBuilder getSearch(PageRequestDto dto){
    String type = dto.getType();
    BooleanBuilder builder = new BooleanBuilder();
    QGuestbook qGuestbook = QGuestbook.guestbook;
    BooleanExpression expression = qGuestbook.gno.gt(0L);
    builder.and(expression);
    if(type == null || type.trim().isEmpty()){
      return builder;
    }

    BooleanBuilder conditionBuilder = new BooleanBuilder();
    String keyword = dto.getKeyword();
    if(type.contains("T")){
      conditionBuilder.or(qGuestbook.title.contains(keyword));
    }
    if(type.contains("C")){
      conditionBuilder.or(qGuestbook.content.contains(keyword));
    }
    if(type.contains("W")){
      conditionBuilder.or(qGuestbook.writer.contains(keyword));
    }
    
    builder.and(conditionBuilder);
    return builder;
  }
}
