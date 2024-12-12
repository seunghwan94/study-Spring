package com.example.member_practice.ex03_DI;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
@Aspect
public class StudentAspect {
  
  @Pointcut("execution(* *(..)) && args(student)")
  public void start(Student student){}

  @Before("start(student)")
  public void studentBefore(JoinPoint joinPoint, Student student){
    log.info(joinPoint.getSignature().getName() + "시작");
  }

  @Around("execution(* end(..))")
  public Object studentAround(ProceedingJoinPoint pjp) throws Throwable{
    log.info("around before");
    Object o = pjp.proceed();
    log.info("around after");
    return o;
  }

  @After("execution(* bye(..))")
  public void simpleAfter(JoinPoint joinPoint){
    log.info("점수다");
  }

}
