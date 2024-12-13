<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>for1.jsp</h1>
	<%
		response.sendRedirect("5.for2.jsp?num="+request.getParameter("num"));
		/* 위랑 아래랑 같다. => 데이터를 어플리케이션 까지 보관하기 위해 이방법 사용 */
		/* request.getRequestDispatcher("5.for2.jsp").forward(request, response); */
	%>
</body>
</html>