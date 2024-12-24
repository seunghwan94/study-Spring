package com.example.guestbook2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // Base Entity 전역 설정
public class Guestbook2Application {

	public static void main(String[] args) {
		SpringApplication.run(Guestbook2Application.class, args);
	}

}
