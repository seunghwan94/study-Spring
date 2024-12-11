package site.mplace.aop.ex03.adv;

import org.springframework.aop.ThrowsAdvice;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ThrowLog implements ThrowsAdvice{
  public void afterThrowing(Exception ex){
    log.info("예외 발생::"+ ex.getMessage());
  }
}
