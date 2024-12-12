package site.mplace.aop.ex05;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProxyTests {
  @Autowired
  @Qualifier("proxy")
  private First first;
  
  @Test
  public void testProxy(){
    first.one();
    first.two();
    first.two2();
  }
}
