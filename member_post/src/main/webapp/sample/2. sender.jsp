<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="receiver.jsp">
		<input type="text" name="value1">
		<input type="text" name="value2" value= "1234">
		<label>테니스<input type="checkbox" name="hobby" value="tennis"></label>
		<label>캠핑<input type="checkbox" name="hobby" value="camping"></label>
		<label>코딩<input type="checkbox" name="hobby" value="coding"></label>
		<label>게임<input type="checkbox" name="hobby" value="game"></label>
		<button>전송</button>
	</form>
</body>
</html>