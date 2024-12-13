<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
 <jsp:include page="../common/head.jsp"/>
 <style>
    .logo-img {width: 240px; height: 80px;}
    .hide {display: none;}
  </style>
</head>
<body class="bg-dark">
  <div class="wrap">
    <jsp:include page="../common/header.jsp"/>

    <main class="container mb-5">
        <h1 class="text-center mt-4 fw-bold text-white">Sign up</h1>
        <form name="form" method="post" class="mx-auto col-8 col-sm-8 col-md-6 col-lg-5 col-xl-4 col-xxl-3 card p-3 mt-4">
          <input type="text" class="form-control my-3" id="id" placeholder="아이디" name="id">
          <input type="password" class="form-control my-3" id="pw" placeholder="비밀번호" name="pw">
          <input type="text" class="form-control my-3" id="name" placeholder="이름" name="name">
          <input type="email" class="form-control my-3" id="email" placeholder="이메일" name="email">
          
          <input type="text" class="form-control my-3" id="roadAddr" placeholder="도로명" name="roadAddr" readonly>
          <input type="text" class="form-control my-3" id="detailAddr" placeholder="상세주소" name="detailAddr">
          
          <div class="input-group my-3">
            <input type="text" class="form-control" placeholder="도로명검색">
            <button class="btn btn-secondary" type="button" id="search">Search</button>
          </div>
          <ul class="list-group search-result-list hide"></ul>
          <button class="btn btn-secondary mt-1">가입하기</button>
        </form>
    </main>

    <jsp:include page="../common/footer.jsp"/>
    <script>
      $(function(){
  
  
  
  
  
        $("#search").click(function(){
          
          const keyword = $(this).prev().val();
          if(!keyword) return;
          const data = {
            keyword,
            confmKey : "devU01TX0FVVEgyMDI0MTAyOTE2MTY1MDExNTIwMTA=",
            currentPage : 1,
            countPerPage : 10,
            resultType : "json"
          }
          console.log(data);
  
          $.ajax({
            url :"https://business.juso.go.kr/addrlink/addrLinkApiJsonp.do",
            type : "post",
            data,
            dataType:"jsonp",
            crossDomain: true,
            success:function(data){
              console.log(data);
              let str = "";
              for(let i=0; i < data['results']['juso'].length; i++){
                str += `<li class="list-group-item"><a href="#" class="small">\${data['results']['juso'][i]['roadAddr']}</a></li>`;
  
              }
              
              $(".search-result-list").removeClass("hide").append(str);
              
            },
            error: function(err, msg){
              console.log(msg);
            }
          })
          $(".search-result-list").on("click","a",function(){
            $("#roadAddr").val($(this).text());
            $(this).closest("ul").empty().addClass("hide");
          })
        })
  
      })
    </script>
  </div>
</body>
</html>