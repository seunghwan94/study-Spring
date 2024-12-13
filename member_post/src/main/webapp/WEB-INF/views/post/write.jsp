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
      
	      <form method="post" action="write?page=1&${cri.qs}">
	        <label for="title" class="form-label text-white mt-3">
	          <i class="fa-solid fa-heading" style="color: #48587f;"></i>
	          <b>Title</b>
	        </label>
	        <input type="text" class="form-control" id="title" placeholder="title" name="title" >
	
	        <label for="content" class="form-label text-white mt-3">
	          <i class="fa-solid fa-pen-fancy"  style="color: #48587f;"></i>
	          <b>Content</b>
	        </label>
	        <textarea class="form-control" rows="20" id="content" name="content" placeholder="content"></textarea>
	        
	        <label for="writer" class="form-label text-white mt-3">
	          <i class="fa-solid fa-user-pen"  style="color: #48587f;"></i>
	          <b>Writer</b>
	        </label>
	        <input type="text" class="form-control" id="writer" placeholder="writer" name="writer" value="${member.id}" readonly>
	        
	        <label for="attach" class="form-label text-white mt-3">
	          <i class="fa-solid fa-paperclip" style="color: #48587f;"></i>
	          <b>Attach</b><br/>
	          <span type="button" class="btn btn-secondary my-2">파일첨부</span>
	        </label>
	        <input type="file" id="attach" name="file" class="d-none" multiple>
	        <span class="text-white small attach-count-txt"></span>
	        <ul class="list-group attach-result"></ul>
	        
	        <div class="text-center my-4">
	          <a href="list" class="btn btn-outline-light">목록</a>
	          <button class="btn btn-secondary">게시</button>
	        </div>
	        <div class="uploaded-input">
	        
	        </div>
	        
		</form>
		
      </div>
    </main>
    <jsp:include page="../common/footer.jsp"/>
  </div>
  <script>
	$("#attach").change(function(){
		const url = "${cp}" + "upload";
		const formData = new FormData();
		const files = this.files;

		if(!files){
			$(".attach-count-txt").text("");
			$(".attach-result").empty();
			return;
		}
		for(let i = 0 ; i < files.length; i++){
			formData.append("file",files[i]);
		}
		
		$.post({
			url,
			contentType:false,
			processData:false,
			data:formData
		}).done(function(data){
			$(".attach-count-txt").text(data.length+" 개의 파일");
			let str = '';
			let strHidden = '';
			for(let i in data){
				str += `<li class="list-group-item">\${data[i].origin}</li>`;
				strHidden += `<input type="hidden" name="uuid" value="\${data[i].uuid}">`;
				strHidden += `<input type="hidden" name="origin" value="\${data[i].origin}">`;
				strHidden += `<input type="hidden" name="image" value="\${data[i].image}">`;
				strHidden += `<input type="hidden" name="path" value="\${data[i].path}">`;
			}
			$(".attach-result").html(str);
			$(".uploaded-input").html(strHidden);
			console.log(data);
		});
	});
</script>

</body>
</html>