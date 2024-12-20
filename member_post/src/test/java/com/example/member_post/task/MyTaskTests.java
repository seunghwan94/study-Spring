package com.example.member_post.task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyTaskTests {
  @Autowired
  private MyTask task;

  @Test
  public void testPrintTime(){
    task.printTime();
  }
}
