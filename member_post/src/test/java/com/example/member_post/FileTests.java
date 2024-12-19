package com.example.member_post;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class FileTests {
  @Test
  public void testDeleteFiles(){
    File file = new File("C:\\upload\\2024\\12\\19","02e3955e-0238-4a6e-98c3-273afa21641f.jpg");
    file.delete();
  }

  @Test
  public void testListFiles(){
    File file = new File("C:\\upload\\2024\\12\\19");
    log.info(file.isDirectory());
    log.info(file.isFile());

    new ArrayList<>(Arrays.asList(file.listFiles(pathname -> pathname.getName().endsWith("jpg")))).forEach(log::info);
  }

}
