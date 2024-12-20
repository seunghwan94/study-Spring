package com.example.member_post.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
// @EnableScheduling
public class MyTask {
  
  // @Scheduled(cron = "0 0 5 * * 4")
  // @Scheduled(cron = "0 0 0 * * *")
  // @Scheduled 가 지정된 메서드는 파라미터 X, 반환 X 
  // @Async : 비동기일때 사용 (멀티스레드)
  @Async
  @Scheduled(cron = "0/5 * * * * *")
  public void printTime(){
    log.info(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(new Date()));
  }
}

