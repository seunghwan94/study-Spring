package com.example.clone.security.util;

import java.time.ZonedDateTime;
import java.util.Date;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class JWTUtil {
  private String secretkey = "test1234567890test1234567890test1234567890";
  private SecretKey key = Keys.hmacShaKeyFor(secretkey.getBytes());

  public String generateToken(String content) throws Exception{
    return Jwts.builder()
      .issuedAt(new Date())
      .expiration(Date.from(ZonedDateTime.now().plusMonths(1L).toInstant()))
      .claim("sub",content)
      .signWith(key)
    .compact();
  }

  public String validateExtract(String tokenStr){
    String contentValue = null;
    try{
      // contentValue = Jwts.parser().setSigningKey(secretkey.getBytes("utf-8")).build().parseClaimsJws(tokenStr).getBody().getSubject();
      Jws<Claims> defaultJws = Jwts.parser().verifyWith(key).build().parseSignedClaims(tokenStr);
      Claims claims = defaultJws.getPayload();
      
      log.info(claims.getSubject());
      log.info(claims.getIssuedAt());
      log.info(claims.getExpiration());

      contentValue = claims.getSubject();
    }catch(Exception e){
      e.printStackTrace();
    }
    return contentValue;
  }
}
