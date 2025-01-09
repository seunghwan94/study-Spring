# Todo CURD 및 페이징 연습
Spring Boot ( Test Code 포함 )

JPA, QueryDSL

tymeleaf, Bootstrap

mariaDB

## 실행 방법
### mariaDB 사용자 / 권한 / 데이터 베이스 생성
```
create database thymeleaf character set utf8mb4 collate utf8mb4_unicode_ci
create user 'thymeleaf'@'localhost' identified by '1234'
grant all privileges on thymeleaf.* to 'thymeleaf'@'%'
flush privileges;
```
