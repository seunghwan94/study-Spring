<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>cookie : ${cookie.layer.name }</h2>
	<h2>cookie : ${cookie.layer.value }</h2>
	<h2>remember-id : ${cookie['remember-id'].value }</h2>
</body>
</html>