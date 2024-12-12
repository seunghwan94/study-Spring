package site.mplace.aop.ex06;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AspectJTests {
  @Autowired
  private MyBean bean;

  @Test
  public void testBean(){
    bean.run();
  }
}
