package com.example.clone.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.clone.entity.Member;
import com.example.clone.entity.Note;
import com.example.clone.entity.dto.LikesDto;
import com.example.clone.repository.MemberRepositroy;
import com.example.clone.repository.NoteRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class LikeServiceTests {
  @Autowired
  private LikesService service;
  @Autowired
  private MemberRepositroy memberRepositroy;
  @Autowired
  private NoteRepository noteRepository;


  private LikesDto dto;

  @BeforeEach
  public void init(){
    dto = LikesDto.builder().mno(1L).num(4L).build();
  }

  @Test
  public void testGet(){
    assertTrue(service.get(dto));
  }

  @Test
  public void testToggle(){
    service.toggle(dto);
  }


  @Test
  public void testInsert(){
    List<Long> mnos = new ArrayList<>(memberRepositroy.findAll().stream().map(Member::getMno).toList());
    List<Long> nums = new ArrayList<>(noteRepository.findAll().stream().map(Note::getNum).toList());
    
    Collections.shuffle(mnos);
    Collections.shuffle(nums);

    List<LikesDto> likesDtos = new ArrayList<>();

    for (int i = 0; i < mnos.size(); i++){
      for(int j = 0; j < nums.size(); j++){
        likesDtos.add(LikesDto.builder()
          .mno(mnos.get(i))
          .num(nums.get(j))
        .build());
      }
    }

    log.info(likesDtos.size());

    likesDtos = likesDtos.subList(0, likesDtos.size() / 5);
    log.info(likesDtos.size());

    likesDtos.forEach(service::toggle);
  }
}
