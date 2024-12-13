<%@page import="java.util.Enumeration"%>
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
		request.setCharacterEncoding("utf-8");
		String val1 = request.getParameter("value1");
		String val2 = request.getParameter("value2");
		String[] hobbies = request.getParameterValues("hobby");
		
		
		/* 요청자가 어떤 이름을 보낼지 모를때 가져오는 방법 */
		Enumeration<String> names = request.getParameterNames();
		
		System.out.println(names);
		while(names.hasMoreElements()){
			String name = names.nextElement();
			System.out.println(name+", "+request.getParameter(name));		
		}
		
		
		
		System.out.println(val1);
		System.out.println(val2);
		System.out.println(hobbies);
	%>
	<h2><%=val1 %></h2>
	<h2><%=val2 %></h2>
	<%-- <h2><%=hobby %></h2> --%>
	<h2>
	<%
		if (hobbies != null)
		for (String hobby : hobbies){
			out.print(hobby+", ");
		} 
	%>
	</h2>
	<h2><%=request.getMethod() %></h2>
	<h2><%=request %></h2>
</body>
</html>