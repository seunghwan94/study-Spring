<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Cookie cookie = new Cookie("newjeans","hypeboy");
		cookie.setMaxAge(60 * 60 * 24); // 하루짜리 쿠키
		response.addCookie(cookie);
	%>
</body>
</html>