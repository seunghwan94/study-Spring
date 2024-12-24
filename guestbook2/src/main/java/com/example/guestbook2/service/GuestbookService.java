package com.example.guestbook2.service;

import java.util.List;

import com.example.guestbook2.domain.dto.GuestbookListDto;
import com.example.guestbook2.domain.dto.GuestbookModifyDto;
import com.example.guestbook2.domain.dto.GuestbookViewDto;
import com.example.guestbook2.domain.dto.GuestbookWriteDto;

public interface GuestbookService {
  void write(GuestbookWriteDto dto);
  void modify(GuestbookModifyDto dto);
  void remove(Long gno);

  List<GuestbookListDto> list();
  GuestbookViewDto get(Long gno);
}
