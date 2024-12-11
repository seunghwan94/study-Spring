package site.mplace.aop.ex04;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import lombok.extern.log4j.Log4j2;
import site.mplace.aop.ex02.adv.Seasoning;
import site.mplace.aop.ex04.adv.SimpleAdvs;

@Log4j2
public class Client {
  public static void main(String[] args) {
    ProxyFactory factory = new ProxyFactory(new First());
    factory.addAdvice(new Seasoning());

    ((First)factory.getProxy()).one();
    ((First)factory.getProxy()).two();
    log.info("=====================");

    factory = new ProxyFactory(new First());
    factory.addAdvisor(new DefaultPointcutAdvisor(new SimpleAdvs(),new Seasoning()));
    ((First)factory.getProxy()).one();
    ((First)factory.getProxy()).two();


  }
}
