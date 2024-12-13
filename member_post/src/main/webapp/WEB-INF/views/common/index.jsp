<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <jsp:include page="head.jsp"/>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js" integrity="sha512-3j3VU6WC5rPQB4Ld1jnLV7Kd5xr+cq9avvhwqzbH/taCRNURoeEpoPBK9pDyeukwSxwRPJ8fDgvYXd6SkaZ2TA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  <style>
    .popup { position: absolute; top: 200px; left: calc(50% - 210px); display: none}
    popup > img {display: block;}
    .backgrounddiv {background-color: skyblue; padding:5px;}
    .left { margin:0; float: left; }
    .backgrounddiv > a {float: right; text-decoration: none; color: #eee;}  
  </style>
</head>
<body class="bg-dark">
  <div class="wrap">
    <jsp:include page="header.jsp"/>
    <main class="container">
      <div class="row">
        <div class="col-md-9">
          <div class="p-3">
            <h1>index</h1>
          </div>
        </div>
        <div class="col-md-3">
          <div class="p-3 d-grid gap-2">
          	<c:if test="${ not empty member }">    
	            <p><a href="mypage.html" class="text-decoration-none text-white"><strong>${member.name}</strong>님 환영합니다.</a></p>
	            <div class="small clearfix">
	              <a href="${cp}member/logout" class="small float-start text-decoration-none text-white">로그아웃</a>
	              <a href="mypage.html" class="small float-end text-decoration-none text-white">마이페이지</a>
	            </div>
	  		</c:if>      
	        <c:if test="${ empty member }">
				<a href="${cp}member/signin" class="btn btn-secondary btn-block">로그인</a>
	            <div class="small clearfix">
	              <a href="${cp}member/signup" class="small float-start text-decoration-none text-white">회원가입</a>
	              <a href="${cp}member/signup" class="small float-end text-decoration-none text-white">아이디/비밀번호 찾기</a>
	            </div>
	        </c:if>
          </div>
        </div>
      </div>

		<div class="popup">
		    <img src="https://image.yes24.com/momo/scmfiles/AdvertFiles/202410/2578206_241014101146.jpg">
		    <div class="backgrounddiv clearfix">
		      <p class="left">오늘 하루 그만 보기 <input type="checkbox"></p>
		      <a href="#">닫기</a>
		    </div>
		</div>
		
		
		
    </main>
	<jsp:include page="footer.jsp"/>
	<script>
		
		/* 쿠키가 없을때 할일 */
		if(!$.cookie("layer"))
			$(".popup").show();
	
		/* 레이어 팝업 내의 닫기 버튼 클릭시 이벤트 */
		$(".popup a").click(function(){
			const checked = $(this).prev().find("input:checkbox").prop("checked");
			console.log(checked);
			if(checked)
				$.cookie('layer','yes', {expires: 1});
			$(".popup").hide();
		})
	</script>
  </div>
</body>
</html>