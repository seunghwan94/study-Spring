package site.mplace.aop.ex06;

import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

// target
@Log4j2
@Component
public class MyDependency {
  public void hello(int intValue){
    log.info("hello ::" + intValue);
  }
  public void bye(){
    log.info("bye()");
  }

}
