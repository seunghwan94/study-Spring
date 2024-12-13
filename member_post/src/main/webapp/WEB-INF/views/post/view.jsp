<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>    
<!DOCTYPE html>
<html lang="en">
<head>
  <jsp:include page="../common/head.jsp"/>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js" integrity="sha512-3j3VU6WC5rPQB4Ld1jnLV7Kd5xr+cq9avvhwqzbH/taCRNURoeEpoPBK9pDyeukwSxwRPJ8fDgvYXd6SkaZ2TA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.30.1/moment-with-locales.min.js" integrity="sha512-4F1cxYdMiAW98oomSLaygEwmCnIP38pb4Kx70yQYqRwLVCs3DbRumfBq82T08g/4LJ/smbFGFpmeFlQgoDccgg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
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
		<h2 class="text-white float-start">상세보기</h2>
	  </div>
      <div class="my-3 col-md-9">
        <label for="title" class="form-label text-white mt-3">
          <i class="fa-solid fa-heading" style="color: #48587f;"></i>
          <b>Title</b>
        </label>
        <input type="text" class="form-control" id="title" placeholder="title" name="title" value="${post.title}" disabled>

        <label for="content" class="form-label text-white mt-3">
          <i class="fa-solid fa-pen-fancy"  style="color: #48587f;"></i>
          <b>Content</b>
        </label>
        <textarea class="form-control" rows="20" id="content" name="content" disabled>${post.content}</textarea>

        
        <label for="create-date" class="form-label text-white mt-3 me-4">
          <i class="fa-regular fa-calendar-days"  style="color: #48587f;"></i>
          <b class="text-white">Create Date ${post.createDate}</b>
        </label>
        <label for="create-date" class="form-label text-white mt-3 me-4">
          <i class="fa-regular fa-calendar-days"  style="color: #48587f;"></i>
          <b class="text-white">Update Date ${post.updateDate}</b>
        </label>

        <span class="text-white fw-bold">
          <i class="fa-solid fa-eye" style="color: #48587f;"></i>
          ${post.viewCount}
        </span>

        <label for="writer" class="form-label text-white mt-3">
          <i class="fa-solid fa-user-pen"  style="color: #48587f;"></i>
          <b>Writer</b>
        </label>        
        <input type="text" class="form-control" id="writer" placeholder="writer" name="writer" value="${post.writer}" disabled>


        <label for="attach" class="form-label text-white mt-3">
          <i class="fa-solid fa-paperclip" style="color: #48587f;"></i>
          <b>Attach</b><br/>
        </label>
        <span class="text-white small attach-count-txt"></span>
        <ul class="list-group attach-result">
        	<c:if test="${empty post.attachs}">
       			<li class="list-group-item">첨부파일 없음</li>
        	</c:if>
        	<c:forEach items="${post.attachs}" var="a">
        		<li class="list-group-item"><a href="${cp}download?uuid=${a.uuid}&origin=${a.origin}&path=${a.path}">${a.origin}</a></li>
        	</c:forEach>
        </ul>

		<div class="clearfix mb-3">
	        <label class="form-label text-white mt-3 float-start">
	          <i class="fa-regular fa-comment-dots "style="color: #48587f;"></i>
	          <b>My Replys</b>
	        </label>
	        <button type="button" id="btnWriteReply" class="btn mt-3  btn-secondary btn-sm float-end">write reply</button>
        </div>

		<ul class="list-group small my-replies my-2" >
<!-- 			<li class="list-group-item " data-rno="6" style="background-color: #e1d896">
              <p class="fw-bold mt-3 text-truncate">test</p>
              <div class="clearfix text-secondary">
                <span class="float-start ">여기</span>
                <span class="float-end small">Invalid date</span>
                <a class="float-end me-1 small text-danger btn-reply-remove" href="#">삭제</a>
              </div>
          </li> -->
		</ul>
		
		
	    <div class="clearfix mb-3">
	        <label class="form-label text-white mt-3 float-start">
	          <i class="fa-regular fa-comment-dots "style="color: #48587f;"></i>
	          <b>Replys</b>
	        </label>
	        <button type="button" id="btnWriteReply" class="btn mt-3  btn-secondary btn-sm float-end">write reply</button>
        </div>


        <ul class="list-group small replies"></ul>
		<div class="d-grid my-3">
      	  <button class="btn btn-secondary btn-block btn-more-reply">댓글 더 보기</button>
		</div>


        <div class="text-center my-5">
        	<c:if test="${post.writer == member.id}">
	        	<a href="modify?pno=${post.pno}&${cri.qs2}" class="btn btn-secondary">수정</a>
	        	<a href="remove?pno=${post.pno}&${cri.qs2}" class="btn btn-outline-secondary" onclick="return confirm('삭제하시겠습니까?');">삭제</a>
        	</c:if>
          	<a href="list?${cri.qs2}" class="btn btn-secondary">목록</a>
        </div>
      </div>
      
      
      
		<!-- The Modal -->
		<div class="modal fade" id="replyModal">
		  <div class="modal-dialog">
		    <div class="modal-content">
		
		      <!-- Modal Header -->
		      <div class="modal-header">
		        <h4 class="modal-title">Reply</h4>
		        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
		      </div>
		
		      <!-- Modal body -->
		      <div class="modal-body">
		      	<label for="replyContent" class="mb-2">content</label>
		      	<input type="text" class="form-control" id="replyContent">
		      	<br>
		      	<label for="replyWriter" class="mb-2">writer</label>
		      	<input type="text" class="form-control" id="replyWriter" value="${member.id}">
				
		      </div>
		
		      <!-- Modal footer -->
		      <div class="modal-footer">
		      	<div>
			      	<button type="button" class="btn btn-secondary" id="btnReplyWriteSubmit">작성</button>
			      	<button type="button" class="btn btn-warning" id="btnReplyModifySubmit">수정</button>
			      	<button type="button" class="btn btn-danger" id="btnReplyRemoveSubmit">삭제</button>
		      	</div>
		        <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal">Close</button>
		      </div>
		
		    </div>
		  </div>
		</div>







    </main>
    <script src="${cp}js/reply.js"></script>

    <script>
    	moment.locale('ko');
	    const pno = '${post.pno}';

      list();
      
      // 목록 조회
      function list(cri, myOnly){
        replyService.list(pno, cri, function(data){
          if(!data.list.length){
        	  $(".btn-more-reply")
        	  	.prop("disabled", true)
        	  	.text("댓글이 없습니다.")
        	  	.removeClass("btn-primary")
        	  	.addClass("btn-secondary");
        	  return;
          }
          
          let myStr = "";
          console.log(data);
          for(let i in data.myList){
              myStr += makeLi(data.myList[i]);
            };
          $(".my-replies").append(myStr);
        	
          if(myOnly) return;
          
          let str = "";
          for(let i in data.list){
            str += makeLi(data.list[i]);
          };
          $(".replies").append(str);

          
          
          
        });
      }

      function makeLi(reply){
        return `<li class="list-group-item" data-rno="\${reply.rno}">
              <p class="text-black fw-bold mt-3 text-truncate">\${reply.content}</p>
              <div class="clearfix text-secondary">
                <span class="float-start">\${reply.writer}</span>
                <span class="float-end small">\${moment(reply.createDate,"yyyy/MM/DD-HH:mm:ss").fromNow()}</span>
                <a class="float-end me-1 small text-danger btn-reply-remove" href="#">삭제</a>
              </div>
          </li>`
      }
      // li 클릭시 이벤트
      $(".replies, .my-replies").on("click", "li", function(){
    	 const rno = $(this).data("rno"); 
    	 replyService.view(rno, function(data){
			$("#replyModal").find(".modal-footer div button").hide()
				.filter(":gt(0)").show();
    	 	$("#replyModal").data("rno",rno).modal("show");
    	 	$("#replyContent").val(data.content);
      	  	$("#replyWriter").val(data.writer);
    	 	
    	 })
      });
      
      
   	  // li .btn-reply-rmove 클릭시 이벤트
      $(".replies, .my-replies").on("click", "li .btn-reply-remove", function(){
    	  // event.preventDefault();
    	  // event.stopPropation();
          if(!confirm("삭제 하시겠습니까?")) return false;
          
          const $li = $(this).closest("li");
          const rno = $li.data("rno");
          
    	  replyService.remove(rno, function(data){
             alert("삭제 되었습니다.");
      		 $li.remove();
      		 list(undefined, true);
           });
    	  return false;
    	  
      });
      
      
      // 댓글 쓰기 버튼 클릭시
      $("#btnWriteReply").click(function () {
    	  $("#replyModal").find(".modal-footer div button").hide()
			.filter(":eq(0)").show();
    	  $("#replyModal").modal("show");

        $("#replyContent").val("");
    	  $("#replyWriter").val("${member.id}");
      })
      
      
      // 댓글 더보기 버튼 클릭시
      $(".btn-more-reply").click(function () {
        const lastRno = $(".replies li:last").data("rno");
        list({lastRno});
      })
      
      $(function () {
    	 
    	// 댓글 작성 버튼 클릭시
        $("#btnReplyWriteSubmit").click(function() {
          const writer = $("#replyWriter").val();
          const content = $("#replyContent").val();
          const reply={pno, writer, content};
          
          replyService.write(reply, function(data){
            $("#replyModal").modal("hide");
            list(undefined, true);
          });
        });
    	// 댓글 수정(반영) 버튼 클릭시
        $("#btnReplyModifySubmit").click(function() {
          const rno = $("#replyModal").data("rno");
       	  const content = $("#replyContent").val();
          const reply={rno, content};
          
          replyService.modify(reply, function(data){
            $("#replyModal").modal("hide");
            $(`.replies li[data-rno="\${rno}"] p`).text(content);
            list(undefined, true);
          });
        });
    	
    	// 댓글 삭제(반영) 버튼 클릭시
        $("#btnReplyRemoveSubmit").click(function() {
          const rno = $("#replyModal").data("rno");
          const $li = $(`.replies li[data-rno="\${rno}"]`);
          replyService.remove(rno, function(data){
            $("#replyModal").modal("hide");
            $li.remove();
            list(undefined, true);
          });
        });
    	
    	
      })
    </script>
    <jsp:include page="../common/footer.jsp"/>
  </div>
</body>
</html>