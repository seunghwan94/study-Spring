package com.example.member_post.utils;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Mybatisinit {
	private static Mybatisinit init = new Mybatisinit();
	
	public static Mybatisinit getInstance() {
		return init;
	}
	
	public SqlSessionFactory sqlSessionFactory() {
		String resource = "mybatis-config.xml";
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}
	
	public static void main(String[] args) {
		System.out.println(new Mybatisinit().sqlSessionFactory());
	}
	
}
