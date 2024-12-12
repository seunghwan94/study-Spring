package com.example.member_practice.ex03_DI;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StudentService {
  private Student student;

  public void run(){
    student.start(student.builder().no(1).name("새똥이").mat(20).eng(90).kor(100).build());
    student.end();
    // student.start(student.builder().no(2).name("개똥이").mat(50).eng(60).kor(10).build());
    // student.end();
    // student.start(student.builder().no(3).name("대똥이").mat(40).eng(40).kor(30).build());
    // student.end();
    // student.start(student.builder().no(4).name("래똥이").mat(30).eng(70).kor(50).build());
    // student.end();
  };
}
