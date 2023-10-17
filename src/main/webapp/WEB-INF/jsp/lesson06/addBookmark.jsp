<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<!-- Bootstrap 4.6 -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  		
		<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		
		<title>북마크 추가</title>
	</head>
	<body>
		<div class="container">
			<h1>즐겨찾기 추가하기</h1>
			<div class="form-group">
				<label for="name">제목</label>
				<input type="text" id="name" class="form-control">
			</div>
			<div class="form-group">
				<label for="url">주소</label>
				<div class="d-flex">
					<input type="text" id="url" class="form-control">
					<button type="button" class="btn btn-info" id="urlCheckBtn">중복 확인</button>
				</div>
				<small id="urlStatusArea"></small>
			</div>
			<input id="addBtn" type="button" class="btn btn-success btn-block" value="추가">
		</div>
	<script>
		$(document).ready(function() {
			$('#urlCheckBtn').on('click', function () {
				$('#urlStatusArea').empty();
				let url = $('#url').val().trim();
				
				$.ajax({
					type:"GET"
					, url:"/lesson06/quiz01/is-duplication"
					, data:{"url":url}
					, success:function(data) {
						if (data.) {
							$('#urlStatusArea').append('<span class="text-danger">중복된 주소입니다.</span>')
						}
					}
				});
			});
			
			$('#addBtn').on('click', function() {
				let name = $('#name').val().trim();
				let url = $('#url').val().trim();
				
				console.log(name);
				console.log(url);
				
				if (!name) {
					alert("제목을 입력하세요.");
					return;
				}
				if (!url) {
					alert("주소를 입력하세요.");
					return;
				}
				if (url.startsWith("http://") == false &&
						url.startsWith("https://") == false) {
					alert("유효한 주소가 아닙니다.");
					return;
				}
				
				$.ajax({
					type:"POST"
					, url:"/lesson06/quiz01/add-bookmark"
					, data:{"name":name, "url":url}
					, success:function(data) { // responsebody 응답값(JSON String) => dictionary object
						// data는 JSON String => Object 변환된 형태로 사용할 수 있다
						// jquery의 ajax 함수의 기능
						
						if (data.result == "success") {
							location.href = "/lesson06/quiz01/get-bookmark-list"
						}
					}
					, error:function(request, status, error) {
						alert("추가에 실패했습니다. 관리자에게 문의해 주세요."); // 사용자에게 보이는 화면
						/* alert(request);
						alert(status);
						alert(error); */
					}
					
				})
			});
		});	
	</script>
	</body>
</html>