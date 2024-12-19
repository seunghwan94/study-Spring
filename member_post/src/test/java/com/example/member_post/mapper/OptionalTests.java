package com.example.member_post.mapper;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class OptionalTests {
  @Test
  public void testOptional(){
    Optional<String> o = Optional.ofNullable(null);
    log.info(o);
    log.info(o.isPresent());
    log.info(o.get());
    log.info(o.or(()->Optional.of("가")));
  }

}
