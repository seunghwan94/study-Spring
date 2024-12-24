package com.example.guestbook2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.guestbook2.domain.dto.GuestbookListDto;
import com.example.guestbook2.domain.dto.GuestbookModifyDto;
import com.example.guestbook2.domain.dto.GuestbookViewDto;
import com.example.guestbook2.domain.dto.GuestbookWriteDto;
import com.example.guestbook2.domain.entity.GuestbookEntity;
import com.example.guestbook2.repository.GuestbookRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class GuestbookServiceImpl implements GuestbookService{
  private GuestbookRepository repository;

  @Override
  public GuestbookViewDto get(Long gno) {
    Optional<GuestbookEntity> opt = repository.findById(gno);
    if(!opt.isPresent()){
      return null;
    }
    return new GuestbookViewDto(opt.get());
  }

  @Override
  public List<GuestbookListDto> list() {
    return repository.findAll().stream().map(GuestbookListDto :: new).toList();
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
  public void write(GuestbookWriteDto dto) {
    repository.save(dto.toEntity());
  }
  
}
