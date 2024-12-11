package site.mplace.demo.test;

// interface 로 만든 전제 조건은 public 이다.
@FunctionalInterface
public interface MyInter {
  Integer run(String str);

  // instence method
  default Integer de(String str){
    return Integer.parseInt(str);
  }

  static Integer sm(String str){
    return Integer.parseInt(str);
  }
} 
