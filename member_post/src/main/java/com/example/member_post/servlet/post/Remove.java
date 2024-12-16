// package com.example.member_post.servlet.post;

// import java.io.IOException;

// import jakarta.servlet.ServletException;
// import jakarta.servlet.annotation.WebServlet;
// import jakarta.servlet.http.HttpServlet;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// import com.example.member_post.dto.Criteria;
// import com.example.member_post.service.PostService;
// import com.example.member_post.service.PostServiceImpl;
// import com.example.member_post.utils.Commons;
// import com.example.member_post.vo.Member;

// @WebServlet("/post/remove")
// public class Remove extends HttpServlet{
// 	private PostService postService = new PostServiceImpl();
// 	@Override
// 	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// 		String pnoStr = req.getParameter("pno");
// 		Object memberObj = req.getSession().getAttribute("member");
// 		Criteria cri = new Criteria(req); 
// 		String redirectUrl = "list" + "?" + cri.getQs2();
			
// 		if (pnoStr == null || memberObj == null) {
// 			Commons.printMsg("비정상적인 접근입니다.", redirectUrl, resp);
// 			return;
// 		}
		
// 		Long pno = Long.valueOf(pnoStr);
// 		Member m = (Member) memberObj;
		
// 		if(!m.getId().equals(postService.findBy(pno).getWriter())) {
// 			Commons.printMsg("본인이 작성한 글만 삭제할 수 있습니다.", redirectUrl, resp);
// 			return;
// 		}
		
// 		postService.remove(pno);
// 		Commons.printMsg("삭제가 완료되었습니다.", redirectUrl, resp);

// 	}
	

// }
