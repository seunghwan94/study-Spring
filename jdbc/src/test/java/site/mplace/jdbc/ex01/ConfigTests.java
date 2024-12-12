package site.mplace.jdbc.ex01;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ConfigTests {
  @Autowired
  private Config config;

  @Test
  public void testConfig() throws SQLException{
    log.info(config);
    log.info(config.getHikariConfig().getDriverClassName());
    log.info(config.getHikariConfig().getDataSource());
    log.info(config.getHikariDataSource());
    log.info(config.getJdbcTemplate().getDataSource().getConnection());
  
    // Connection connection = config.getHikariConfig().getDataSource().getConnection();
  }

}
