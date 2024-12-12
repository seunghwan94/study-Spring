package site.mplace.aop.ex06;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Aspect
@Log4j2
public class MyAdvice {
  
  @Pointcut("execution(* *(..)) && args(intValue)")
  public void hello(int intValue){}

  @Pointcut("bean(myDependency)")
  public void beanPointcut(){}

  @Before("hello(intValue) && beanPointcut()")
  public void simpleBefore(JoinPoint joinPoint, int intValue){
    if(intValue > 5000){
      log.info(joinPoint.getSignature().getName()+"샘플");
    }
  }

  // around만 proceedingJoinPoint 사용해야되고 나머진 joinPoint 사용
  @Around("execution(* bye(..))")
  public Object simpleAround(ProceedingJoinPoint pjp) throws Throwable{
    log.info("around before");
    Object o = pjp.proceed();
    log.info("around after");
    return o;
  }

  @After("execution(* bye(..))")
  public void simpleAfter(JoinPoint joinPoint){
    log.info("myAfter");
  }
}
