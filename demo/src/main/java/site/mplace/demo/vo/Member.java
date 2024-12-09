package site.mplace.demo.vo;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@Data
@Builder
// @Slf4j
// @Log4j2
@Component
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private String id;
    private String pw;
    private String name;

    private static final Logger logger = Logger.getLogger("com.hjham.demo.vo.Member");
    private static final java.lang.System.Logger logger2 = System.getLogger("com.hjham.demo.vo.Member");

    private static final org.apache.logging.log4j.Logger log = LogManager.getLogger(Member.class);
    public static void main(String[] args) {
        Member member = Member.builder().id("abcd").pw("1234").name("john").build();
        System.out.println(member);

        logger.info(member.toString());
        // logger2.log(Level.INFO, member);

        log.info(member);


    }
}