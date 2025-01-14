package com.example.clone.service;

import java.util.List;
import java.util.Optional;

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
  public Optional<NoteDto> get(Long num) {
    return repository.findById(num).map(this::toDto);
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

  @Override
  public List<NoteDto> listAll() {
    return repository.findAll().stream().map(this::toDto).toList();
  }

}
