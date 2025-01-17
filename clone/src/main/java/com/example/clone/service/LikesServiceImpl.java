package com.example.clone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.clone.entity.composite.LikesId;
import com.example.clone.entity.dto.LikesDto;
import com.example.clone.repository.LikesRepository;
import com.example.clone.repository.MemberRepositroy;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class LikesServiceImpl implements LikesService{
  @Autowired
  private LikesRepository repository;
  @Autowired
  private MemberRepositroy memberRepositroy;

  @Override
  public boolean get(LikesDto dto) {
    if(dto.getMno() == null){
      dto.setMno(memberRepositroy.findByEmail(dto.getEmail()).getMno());
    }
    return repository.findById(new LikesId(dto)).isPresent();
  }

  @Override
  public boolean toggle(LikesDto dto) {
    log.error(dto);
    if(dto.getMno() == null){
      dto.setMno(memberRepositroy.findByEmail(dto.getEmail()).getMno());
    }
    boolean ret = get(dto);
    if (get(dto)){
      repository.delete(toEntity(dto));
    }else{
      repository.save(toEntity(dto));
    }
    return ret;
  }
  
}
