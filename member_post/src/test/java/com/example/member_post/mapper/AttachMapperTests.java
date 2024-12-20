package com.example.member_post.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.member_post.vo.Attach;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class AttachMapperTests {
  @Autowired
  private AttachMapper attachMapper;

  String date = "2024/12/20";
  @Test
  public void testSelectAttach(){
    List<Attach> list = attachMapper.selectListByPath(date);
    list.forEach(log:: info);
    log.info("------------------------------------------");
    List<File> file = new ArrayList<>(Arrays.asList(new File("c:/upload",date).listFiles()));
    file.forEach(log:: info);

    log.info("------------------------------------------");
    List<File> list2 = list.stream().map(Attach::toFile).toList();

    list2.forEach(log::info);
    log.info(list2.size());
    log.info("------------------------------------------");

  }

  @Test
  public void testConvert2Attach(){
    List<Attach> files = new ArrayList<>(Arrays.asList(new File("c:/upload",date).listFiles())
    .stream()
    .map(Attach::fromFile)
    .toList());

    files.forEach(log::info);
    log.info("------------------------------------------");
    List<Attach> dbs = new ArrayList<>( attachMapper.selectListByPath(date) );
    List<Attach> thumbs = dbs.stream().filter(Attach::isImage).map(a->Attach.builder().uuid("t_"+a.getUuid()).build()).toList();


    log.info(thumbs);
    log.info(thumbs.size());

    dbs.addAll(thumbs);

    log.info("------------------------------------------");
    files.removeAll(dbs);
    // files.forEach(log::info);
    log.info(files.size());
  }


  @Test
  // 테스트 이름 주는 코드이다.
  @DisplayName("Attach 객체의 equals() 와 hashcode() 의 재정의 확인 용도")
  public void testAttachEqualsAndHashcode(){
    Attach attach1  = Attach.builder().uuid("1.png").build();
    Attach attach2  = Attach.builder().uuid("1.png").build();
    Attach attach3  = Attach.builder().uuid("2.png").build();
    Attach attach4  = attach1;

    assertTrue(attach1.equals(attach2));
    assertTrue(!attach1.equals(attach3));
    assertTrue(!attach2.equals(attach3));

    assertEquals(attach1, attach2);
    assertSame(attach1, attach4);

    log.info(attach1.hashCode());
    log.info(attach2.hashCode());
    log.info(attach3.hashCode());

    log.info(attach1.getUuid().hashCode());

    Set<Attach> set = new HashSet<>(Stream.of(attach1, attach2, attach3, attach4).collect(Collectors.toSet()));
    log.info(set);
    log.info(set.size());

  }

  // stream map연습
  @Test
  public void testBi(){
    Map<String, Integer> map = new HashMap<>();

    map.put("A", 1);
    map.put("B", 2);
    map.put("C", 3);

    map.replaceAll((k,v)-> v * v);
    log.info(map);
    map.forEach((k,v)-> log.info(k+"::"+ v));
    map.forEach(log::info);
  }
}
