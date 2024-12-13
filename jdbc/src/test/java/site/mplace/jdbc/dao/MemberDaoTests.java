package site.mplace.jdbc.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;
import site.mplace.jdbc.vo.Member;

@SpringBootTest
@Log4j2
public class MemberDaoTests {
  @Autowired
  private MemberDao dao;

  @Test
  public void getNow(){
    log.info(dao.getTime());
  }

  @Test
  public void testRegister(){
    log.info(dao.register(Member.builder().id("testzzz").pw("123").name("testzzzz").build()));
  }

  @Test
  public void testList(){
    dao.selectList().forEach(log::info);
    // dao.selectList().forEach(map -> log.info(map.get("id")));

    // // 제네릭이 없다면 이런식으로 해야된다.
    // dao.selectList().forEach(map -> {
    //   if(map instanceof Map){
    //     Object id = ((Map)map).get("id");
    //     if(id instanceof String){
    //       String idStr = (String)id;
    //     }
    //   }
    // });
  }

  @Test
  public void testListOne(){
    log.info(dao.selectOne("test"));
  }

  @Test
  public void testUpdate(){
    Member member = dao.selectOne("test");
    log.info(dao.selectOne("test"));
    member.setPw("test");
    member.setName("뭔데");

    int result = dao.update(member);
    assertEquals(1, result);

    log.info(dao.selectOne("test"));
  }
  @Test
  public void testDelete(){
    log.info(dao.register(Member.builder().id("testzzz").pw("123").name("testzzzz").build()));
    log.info(dao.selectOne("testzzz"));
    int result = dao.delete("testzzz");
    assertEquals(1, result);

  }




  @Test
  public void testObject(){
    // Object o = "asdf";
    Object o = new Date();

    if(o instanceof String){
      if ((o+"").matches("^[0-9]*$")){
        Long l = Long.parseLong(o+"") + 2000;
        log.info(l);
      }
    }
  }
  
  @Test
  public void testTecherObject(){
    // Object o = "asdf";
    Object o = new Date();
    
    log.info(o.getClass().getName());
    log.info(o instanceof String);

    try{
      String s = (String)o;
      Long l = Long.valueOf(s);
      log.info(l+2000);
    }catch( ClassCastException e){
      log.info("cast 과정 문제");
    }catch(NumberFormatException e){
      log.info("문자열이지만 숫자 구성 X");
    }
    

  }
}
