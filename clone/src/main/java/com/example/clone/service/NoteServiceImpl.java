package com.example.clone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.clone.entity.Likes;
import com.example.clone.entity.Member;
import com.example.clone.entity.Note;
import com.example.clone.entity.dto.NoteDto;
import com.example.clone.repository.LikesRepository;
import com.example.clone.repository.MemberRepositroy;
import com.example.clone.repository.NoteRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor
@Transactional
@Log4j2
public class NoteServiceImpl implements NoteService{
  
  private NoteRepository repository;
  private MemberRepositroy memberRepositroy;
  private LikesRepository likesRepository;

  @Override
  public Optional<NoteDto> get(Long num) {
    long count = likesRepository.count(Example.of(Likes.builder().note(Note.builder().num(num).build()).build()));
    log.info(count);
    return repository.findById(num).map(this::toDto).map(d -> {
      d.setLikesCnt(count);
      return d;
    });
  }

  @Override
  public List<NoteDto> list(String email) {
    repository.findNotesBy(email).stream().map(o -> {
      NoteDto dto = toDto((Note)o[0]);
      dto.setLikesCnt((Long)o[1]);
      dto.setAttachCnt((Long)o[2]);
      return dto;
    }).toList();

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
    Member member = memberRepositroy.findByEmail(dto.getMemberEmail());
    dto.setMemberMno(member.getMno());
    return toDto(repository.save(toEntity(dto)));
  }

  @Override
  public List<NoteDto> listAll() {
    return repository.findNotes().stream().map(o -> {
      NoteDto dto = toDto((Note)o[0]);
      dto.setLikesCnt((Long)o[1]);
      dto.setAttachCnt((Long)o[2]);
      return dto;
    }).toList();
  }

}
