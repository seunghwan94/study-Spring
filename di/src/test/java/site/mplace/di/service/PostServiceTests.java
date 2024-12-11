package site.mplace.di.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class PostServiceTests {

  // @Autowired(required = false) // 의존성 끊기
  @Autowired // 의존성 기본 True
  @Qualifier("postService") // 특정화 하다. target을 정할수 있다.
  private PostService service;

  @Test
  public void testExist(){
    assertNotNull(service);
  }

  @Test
  public void testList(){
    service.list().forEach(log::info);
  }

}
