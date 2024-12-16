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
        <h1 class="text-center mt-4 fw-bold text-white">Sign in</h1>
        <c:if test="${not empty msg}">
          <p class="my-2 text-danger text-center">로그인 실패 - 아이디와 비밀번호를 확인하세요.</p>
        </c:if>
        <form name="form" method="post" class="mx-auto col-8 col-sm-8 col-md-6 col-lg-5 col-xl-4 col-xxl-3 card p-3 mt-4">
          <input type="text" class="form-control my-3" id="id" placeholder="아이디" name="id" value="${cookie['remember-id'].value}">
          <input type="password" class="form-control my-3" id="pw" placeholder="비밀번호" name="pw">

          <div class="form-check form-switch mb-4">
            <label class="form-check-label" for="mySwitch">아이디 기억</label>
            <input class="form-check-input" type="checkbox" id="mySwitch" name="remember-id" value="yes" ${ empty cookie['remember-id'] ? "" : "checked"}>
          </div>

          <button class="btn btn-secondary mt-1">로그인</button>
        </form>
        
    </main>

    <jsp:include page="../common/footer.jsp"/>
    
<!--     <script>
		if($.cookie("remember-id")){
			$("#id").val($.cookie("remember-id"));
			$("#mySwitch").prop("checked",true);	
		}
    </script> -->
  </div>
</body>
</html>