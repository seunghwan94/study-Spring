package site.mplace.aop.ex05;

import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component("target")
public class First {
  
  public void one(){
    log.info("First.one()");
  }
  public void two(){
    log.info("First.two()");
  }

  public void two2(){
    log.info("First.two2()");
  }
}
