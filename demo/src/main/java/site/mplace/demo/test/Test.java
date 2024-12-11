package site.mplace.demo.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Test {
  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>(Stream.of(1,2,3,4,5).toList());
    log.info(list);
    
    // Comparator는 결국 interface
    Comparator<Integer> c = (a,b) -> b - a;
    list.sort(c);
    log.info(list);

    // interface 이기 때문에 추상메서드를 가져와서 불완전하다.
    MyInter myInter = new MyInter() {
      public Integer run(String str){
        return 10;
      }

      // public Integer de(String str){
      //   return 20;
      // }
    };

    log.info(myInter.run("test"));
    log.info(myInter.de("100"));
    log.info(MyInter.sm("30"));

    // 추상메서드 한개여야 이걸 사용가능하다.
    MyInter myInter2 = a -> 50; // 메서드의 선언
    
    log.info(myInter2.run(null)); // 메서드의 호출
  }
}
