package site.mplace.aop.ex05;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class Seasoning implements MethodBeforeAdvice{
  @Override
  public void before(Method method, Object[] args, @Nullable Object target) throws Throwable {
    log.info("염지를 한다.");
  }
}