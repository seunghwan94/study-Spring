package com.example.member_post.servlet.post;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.example.member_post.dto.Criteria;
import com.example.member_post.dto.PageDto;
import com.example.member_post.service.PostService;
import com.example.member_post.service.PostServiceImpl;



@WebServlet("/post/list")
public class PostList extends HttpServlet{
	private PostService service = new PostServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 전체목록 보기
		Criteria cri = new Criteria(req);
		System.out.println(cri);
		
		req.setAttribute("posts", service.list(cri));
		req.setAttribute("pageDto", new PageDto(cri, service.count(cri)));
		req.getRequestDispatcher("/WEB-INF/jsp/post/list.jsp").forward(req, resp);
	}

}
