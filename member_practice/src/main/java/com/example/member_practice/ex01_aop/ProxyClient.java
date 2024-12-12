package com.example.member_practice.ex01_aop;


import org.springframework.aop.framework.ProxyFactory;

import com.example.member_practice.ex01_aop.adv.Seasoning;
import com.example.member_practice.ex01_aop.adv.Sourcing;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ProxyClient {
  public static void main(String[] args) {
    ProxyFactory factory = new ProxyFactory();
    factory.setTarget(new Chicken());
    factory.addAdvice(new Seasoning());
    factory.addAdvice(new Sourcing());

    Chicken chicken = (Chicken)factory.getProxy();
    chicken.cook("하와이안");
    
  }

}
