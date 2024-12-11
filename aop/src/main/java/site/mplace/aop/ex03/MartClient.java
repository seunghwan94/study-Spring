package site.mplace.aop.ex03;

import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import site.mplace.aop.ex02.adv.Packaging;
import site.mplace.aop.ex03.adv.ThrowLog;

public class MartClient {
  public static void main(String[] args) {
    // 1.ProxyFactory 생성
    ProxyFactory factory = new ProxyFactory();
    // 2. target을 MartImpl로 지정
    factory.setTarget(new MartImpl());
    // 3. ex02의 packaging을 advice로 지정
    factory.addAdvice(new Packaging());
    // 4. ex03의 ThrowLog를 advice로 지정
    factory.addAdvice(new ThrowLog());
    // 5. proxy객체 생성 후 getProduct 호출
    Mart mart = (Mart)factory.getProxy();
    mart.getProduct("뭐래");


    // try{
    //   ((Mart)factory.getProxy()).getProduct("간장");
    // }catch(RuntimeException r){
    //   // log.error(r.getMessage());
    // }
  }
}
