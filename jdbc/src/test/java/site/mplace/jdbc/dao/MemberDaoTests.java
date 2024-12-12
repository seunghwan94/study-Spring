package site.mplace.jdbc.dao;

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
}
