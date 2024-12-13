<%@page import="vo.Member" %>
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
		/* 3. session 만료 이렇게 되면 application을 확인하게 된다.*/
		/* session.invalidate(); */
	%>

	<h2>${member }</h2>
	<h2>${member.id }</h2>
	<h2>${member.getId() }</h2>
	<h2>${member.getNum() }</h2>
	<h2>${member.email }</h2>
	<h2>${member.name }</h2>
	<hr>
	<h2>page : ${pageScop.number }</h2>
	<h2>request : ${requestScope.number }</h2>
	<h2>session : ${sessionScope.number }</h2>
	<h2>application : ${applicationScope.number }</h2>
</body>
</html>