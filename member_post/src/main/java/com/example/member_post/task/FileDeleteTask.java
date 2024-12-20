package com.example.member_post.task;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.member_post.mapper.AttachMapper;
import com.example.member_post.vo.Attach;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@EnableScheduling
@Component
@Log4j2
@AllArgsConstructor
public class FileDeleteTask {
  private AttachMapper attachMapper;

  @Scheduled(cron = "0 35 14 * * *")
  public void deleteFiles(){
    String date = "2024/12/20";
    List<Attach> files = new ArrayList<>(Arrays.asList(new File("c:/upload",date).listFiles())
    .stream()
    .map(Attach::fromFile)
    .toList());

    List<Attach> dbs = new ArrayList<>( attachMapper.selectListByPath(date) );
    List<Attach> thumbs = dbs.stream()
                             .filter(Attach::isImage)
                             .map(a->Attach.builder().uuid("t_"+a.getUuid()).build())
                             .toList();

    dbs.addAll(thumbs);

    files.removeAll(dbs);

    files.stream()
      .peek(a->a.setPath(date))
      .map(Attach::toFile)
      .forEach(File::delete);

    log.info(files.size()+ "개의 파일 삭제");

    // stream
    
    // 최종연산 : 반환값 void 
    //    (더이상 체이닝 못함, 중간연산만 있어도 수행이안되기 때문에 최종연산은 필수)
    // count() (최종연산) : 요소 갯수
    // forEach() (최종연산) : 반복 
    //    forEach(consumer) : 인자 -> 1개, return X (void이기 때문에)
    //                        ※ TIP. 인자 -> 두개(biConsumer)
    //    ex) .forEach(File::delete); == .forEach((files)->{files.delete();});
    // Collect(Collectors.toList()) : 



    // 중간연산 : 반환값 stream
    // filter(predicate) : 
    // map(function) : 
    // peek(consumer) : 중간에하는 forEach라 생각해라

    // supplier -> 인자 0 return 1
    log.info(()->{return "test";});

  }
}
