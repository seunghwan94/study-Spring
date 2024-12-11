package site.mplace.aop.ex01;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class HelloworldImpl implements HelloWorld{
  
  @Override
  public void sayHello(String msg){
    log.info(msg + ":: hello world");
  }

}
