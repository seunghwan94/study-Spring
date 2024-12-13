<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- method enctype 필수 -->
<form method="post" enctype="multipart/form-data" action="${cp}upload">
	<input type="file" name="files" multiple>
	<button>파일 전송</button>
</form>
</body>
</html>