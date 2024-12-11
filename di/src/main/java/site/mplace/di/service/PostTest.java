package site.mplace.di.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class PostTest {
  public static void main(String[] args) {
    SpringApplication application = new SpringApplication(PostTest.class);
    ApplicationContext ctx = application.run(args);
    PostService service = ctx.getBean(PostService.class);
    service.list().forEach(log::info);

  }
}
