package site.mplace.aop.ex02;

import org.springframework.aop.framework.ProxyFactory;

import lombok.extern.log4j.Log4j2;
import site.mplace.aop.ex02.adv.Packaging;
import site.mplace.aop.ex02.adv.Seasoning;
import site.mplace.aop.ex02.adv.Sourcing;

@Log4j2
public class ProxyClient {
  public static void main(String[] args) {
    // 염지
    // 양념 만들기
    // 튀기기
    // 양념 바르기
    // 포장하기

    // 양념 만들기
    // 바베큐
    // 양념 바르기
    // 포장하기

    ProxyFactory factory = new ProxyFactory();
    
    factory.setTarget(new Chicken());
    factory.addAdvice(new Seasoning());
    factory.addAdvice(new Sourcing());
    factory.addAdvice(new Packaging());

    Chicken chicken = (Chicken)factory.getProxy();
    chicken.cook("파닭");

    log.info("===================");

    factory = new ProxyFactory(new Bbq());
    factory.addAdvice(new Sourcing());
    factory.addAdvice(new Packaging());

    Bbq bbq = (Bbq) factory.getProxy();
    bbq.cook("간장");
    
  }
}
