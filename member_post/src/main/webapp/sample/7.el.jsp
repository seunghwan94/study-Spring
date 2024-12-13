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
	 /* null은 공백으로 나온다. */
		System.out.println(page == this);

		Member member = Member.builder().id("javaman").name("test").build();	
		pageContext.setAttribute("member", member);
		
		pageContext.setAttribute("number", 10);
		request.setAttribute("number", 20);
		session.setAttribute("number", 30);
		application.setAttribute("number", 40);
	%>
	<h2>${member }</h2>
	<h2>${member.id }</h2>
	<h2>${member.getId() }</h2>
	<h2>${member.getNum() }</h2>
	<h2>${member.email }</h2>
	<h2>${member.name }</h2>
	
	<!-- 1. page 찾고 없으면 request 없으면 session 식으로 순서대로 진행한다. -->
	<jsp:forward page="7.el2.jsp"/>
	<%
	/* 2. page 찾고 없으면 request 없으면 session 식으로 순서대로 진행한다. */
		/* response.sendRedirect("7.el2.jsp"); */
	%>
	
	
	
	
	
</body>
</html>