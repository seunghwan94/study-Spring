package site.mplace.jdbc.ex01;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.Data;

@Configuration
@Data
public class Config {
  @Autowired
  public HikariConfig hikariConfig;
  
  @Autowired
  public HikariDataSource hikariDataSource;

  @Autowired
  private JdbcTemplate jdbcTemplate;
}
