<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
<!-- method enctype 필수 -->
<form method="post" enctype="multipart/form-data" action="${cp}upload" id="fileForm">
	<input type="file" name="files" multiple>
	<button>파일 전송</button>
</form>
<script>
	$("#fileForm").submit(function(){
		event.preventDefault();
	});

	$("#fileForm :file").change(function(){
		const formData = new FormData();
		const files = this.files;

		for(let i = 0 ; i < files.length; i++){
			formData.append("file",files[i]);
		}
		
		const url = $("#fileForm").attr("action")
		$.post({
			url,
			contentType:false,
			processData:false,
			data:formData
		}).done(function(data){
			console.log(data);
		});
	});
</script>
</body>
</html>