package com.example.clone.repository;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.clone.entity.Member;
import com.example.clone.entity.MemberRole;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class MemberRepositoryTests {
  @Autowired
  private MemberRepositroy repositroy;
  @Autowired
  private PasswordEncoder encoder;

  @Test
  public void testInsert(){
    IntStream.rangeClosed(1, 100).forEach(i->{
      Member m = Member.builder()
        .email("user" + i + "@a.com")
        .name("사용자" + i)
        .password(encoder.encode("1234"))
      .build();

      m.addMemberRole(MemberRole.USER);

      if(i > 80) m.addMemberRole(MemberRole.MANAGER);
      if(i > 90) m.addMemberRole(MemberRole.ADMIN);
      repositroy.save(m);
    });
  }

  @Test
  @Transactional
  public void testFindByEmail(){
    Member m = repositroy.findByEmail("user91@a.com");
    Member m2 = repositroy.findByEmailAndFromSocial("user91@a.com", false);
    log.info(m);
    log.info(m2);
  }


}
