package site.mplace.aop.ex02.adv;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import lombok.extern.log4j.Log4j2;

// around
@Log4j2
public class Sourcing implements MethodInterceptor{

  @Override
  public Object invoke(MethodInvocation invocation) throws Throwable {
    String source = invocation.getArguments()[0].toString();
    log.info(source + " 양념을 만든다.");
    Object o = invocation.proceed();
    log.info(source + " 양념을 바른다.");
    return o;
  }
  
}
