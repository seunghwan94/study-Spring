package com.example.member_practice.ex03_DI;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
// @Component
public class Student {
  private int no;
	private String name;
	private int kor;
	private int eng;
	private int mat;

	public void start(Student student){
		log.info("================== start");
		log.info(student);
	}
	public void end(){
		log.info("================== end");
	}
}
