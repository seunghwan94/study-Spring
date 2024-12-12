package site.mplace.aop.ex05;

import org.springframework.aop.Advisor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Client {
  public static void main(String[] args) {

    // 1번째
    // ApplicationContext ctx = SpringApplication.run(Client.class, args);
    // First first = ctx.getBean(First.class);
    // first.one();
    // first.two();
    // first.two2();

    // // Seasoning seasoning = ctx.getBean(Seasoning.class);
    // ProxyFactory factory = ctx.getBean(ProxyFactory.class);
    // factory.setTarget(first);
    // factory.addAdvisor(ctx.getBean(Advisor.class));

    // First proxy = (First)factory.getProxy();
    // proxy.one();
    // proxy.two();
    // proxy.two2();

    // 2번째
    ApplicationContext ctx = SpringApplication.run(Client.class, args);
    First proxy = ctx.getBean("proxy",First.class);
    proxy.one();
    proxy.two();
    proxy.two2();
  }
}
