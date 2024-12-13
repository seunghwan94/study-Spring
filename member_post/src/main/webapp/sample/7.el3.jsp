<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>${10 + 4 }</h3>
	<h3>${'10' + 4 }</h3>
	<h3>${"10" + 4 }</h3>
	<hr>
	<h3>${10 - 4 }</h3>
	<h3>${10 * 4 }</h3>
	<h3>${10 / 4 }</h3>
	<h3>${10 % 4 }</h3>
	<hr>
	<h3>${10 mod 4 }</h3>
	<h3>${3.14 + 1 }</h3>
	<hr>
	
	<h3>${10 > 4 }</h3>
	<h3>${10 gt 4 }</h3>
	<hr>
	<h3>${10 >= 4 }</h3>
	<h3>${10 ge 4 }</h3>
	<hr>
	<h3>${10 != 4 }</h3>
	<h3>${10 eq 4 }</h3>
	<h3>${10 == 4 }</h3>
	
	<hr>
	<%
		List<String> list = new ArrayList<>();
		/* list.add("abcd"); */
		String[] arr = {};
		pageContext.setAttribute("list",list);
		pageContext.setAttribute("arr",arr);
		pageContext.setAttribute("str1","");
		pageContext.setAttribute("str2","asdf");
		pageContext.setAttribute("str3",null);
		
	%>
	<h2>${empty list}</h2>
	<h2>${empty arr}</h2>
	<h2>${empty str1}</h2>
	<h2>${empty str2}</h2>
	<h2>${empty str3}</h2>
		
	
	

	
</body>
</html>