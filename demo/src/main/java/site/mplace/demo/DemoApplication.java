package site.mplace.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;



@SpringBootApplication
// // bean 대상 추적
// @Component
// @Controller
// @Service
// // 탐색 범위를 지정 (basePackages)
// @ComponentScan(basePackages = "site.mplace.demo") 
// // 이 페이지 위치보다 밑에 있어야 탐색 대상이 된다.
public class DemoApplication {


	@Bean // 반환 대상이 인스턴스이면 가능하다. (반환타입이 참조자료형이면 된다.)
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
