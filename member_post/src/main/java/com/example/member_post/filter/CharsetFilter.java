package com.example.member_post.filter;

import java.io.IOException;

import org.apache.logging.log4j.core.config.Order;
import org.springframework.stereotype.Component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.log4j.Log4j2;
import jakarta.servlet.Filter;


@WebFilter("/*")
@Component
@Order(1)
@Log4j2
public class CharsetFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		// 실제 처리
		chain.doFilter(request, response);
	}
}
