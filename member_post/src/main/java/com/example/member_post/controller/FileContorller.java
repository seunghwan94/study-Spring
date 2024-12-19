package com.example.member_post.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.member_post.vo.Attach;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class FileContorller {
  // 업로드
  @PostMapping("upload")
  public List<Attach> upload(@RequestParam("file") List<MultipartFile> files) throws Throwable, IOException{
    return files.stream().map(Attach::new).toList();
  }
  // 다운로드

  // 이미지 뷰

  // 파일 삭제
}
