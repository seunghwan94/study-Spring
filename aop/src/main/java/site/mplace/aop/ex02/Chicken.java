package site.mplace.aop.ex02;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Chicken {
  public void cook(String source){
    log.info("치킨을 튀긴다");
  }
}
