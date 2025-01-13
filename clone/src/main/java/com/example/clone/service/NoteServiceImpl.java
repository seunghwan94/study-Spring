package com.example.clone.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.clone.entity.dto.NoteDto;
import com.example.clone.repository.NoteRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class NoteServiceImpl implements NoteService{
  
  private NoteRepository repository;
  
  @Override
  public NoteDto get(Long num) {
    return toDto(repository.findByNum(num));
  }

  @Override
  public List<NoteDto> list(String email) {

    return repository.findByMemberEmail(email).stream().map(this::toDto).toList();
  }

  @Override
  public int modify(NoteDto dto) {
    repository.save(toEntity(dto));
    return 1;
  }

  @Override
  public int remove(Long num) {
    repository.deleteById(num);
    return 1;
  }

  @Override
  public NoteDto write(NoteDto dto) {
    return toDto(repository.save(toEntity(dto)));
  }
  


}
