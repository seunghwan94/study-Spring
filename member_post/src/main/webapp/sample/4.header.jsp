<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<h1>header.jsp</h1>
	<%
		String num = request.getParameter("num");
	%>
	<h3>header <%=num %></h3>