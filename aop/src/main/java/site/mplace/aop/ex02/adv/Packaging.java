package site.mplace.aop.ex02.adv;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.lang.Nullable;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Packaging implements AfterReturningAdvice{

  @Override
  public void afterReturning(@Nullable Object returnValue, Method method, Object[] args, @Nullable Object target)
      throws Throwable {
    log.info("포장을 진행한다.");
  }
  
}
