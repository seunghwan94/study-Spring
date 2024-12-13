<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>    
<!DOCTYPE html>
<html lang="en">
<head>
  <jsp:include page="../common/head.jsp"/>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js" integrity="sha512-3j3VU6WC5rPQB4Ld1jnLV7Kd5xr+cq9avvhwqzbH/taCRNURoeEpoPBK9pDyeukwSxwRPJ8fDgvYXd6SkaZ2TA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  <style>
    .logo-img {width: 240px; height: 80px;}
    .hide {display: none;}
  </style>
</head>
<body class="bg-dark">
  <div class="wrap">
    <jsp:include page="../common/header.jsp"/>
    <main class="container mb-5">
      <div class= "my-4 clearfix">
		<h2 class="text-white float-start">글쓰기</h2>
	  </div>
      <div class="my-3 col-md-9">
      
	      <form method="post" action="modify?"+${cri.qs2}>
	        <label for="title" class="form-label text-white mt-3">
	          <i class="fa-solid fa-heading" style="color: #48587f; "></i>
	          <b>Title</b>
	        </label>
	        <input type="text" class="form-control" id="title" placeholder="title" name="title" value="${post.title}">
	
	        <label for="content" class="form-label text-white mt-3">
	          <i class="fa-solid fa-pen-fancy"  style="color: #48587f;"></i>
	          <b>Content</b>
	        </label>
	        <textarea class="form-control" rows="20" id="content" name="content" placeholder="content">${post.content}</textarea>
	        
	        <label for="writer" class="form-label text-white mt-3">
	          <i class="fa-solid fa-user-pen"  style="color: #48587f;"></i>
	          <b>Writer</b>
	        </label>
	        <input type="text" class="form-control" id="writer" placeholder="writer" name="writer" value="${member.id}" readonly>
	        
	        <div class="text-center my-4">
	          <a href="list" class="btn btn-outline-light">목록</a>
	          <button class="btn btn-secondary">게시</button>
	        </div>
	        <input type="hidden" name="pno" value="${post.pno}">
		</form>
		
      </div>
    </main>
    <jsp:include page="../common/footer.jsp"/>
  </div>
</body>
</html>