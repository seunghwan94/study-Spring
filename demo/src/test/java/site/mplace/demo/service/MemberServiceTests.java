package site.mplace.demo.service;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class MemberServiceTests {
  @Autowired
  private MemberService memberService;
  @Autowired
  private MemberService memberService2;
  @Autowired
  private MemberService memberService3;

  @Test
  public void testExist(){
    log.info(memberService);
  }

  @Test
  public void testSelectNow(){
    memberService.selectNow();
  }

  @Test
  public void testSame(){
    assertSame(memberService, memberService2);
    assertSame(memberService, memberService3);
    assertSame(memberService2, memberService3);
  }
}
