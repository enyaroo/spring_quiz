<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<!-- Bootstrap 4.6 -->
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	  		
			<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		
			<title>북마크 목록</title>
		</head>
		<body>
			<div class="container">
				<table class="table">
					<thead>
						<tr>
							<th>번호</th>
							<th>이름</th>
							<th>주소</th>
							<th>삭제</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${bookmarkList}" var="bookmark" varStatus="status">
						<tr>
							<td>${status.count}</td>
							<td>${bookmark.name}</td>
							<td><a href="${bookmark.url}" target="_blank">${bookmark.url}</a></td>
							<td>
								<%-- value 속성을 이용해서 값 세팅 --%>
								<%-- <button type="button" class="del-btn btn btn-danger" value="${bookmark.id}">삭제</button> --%>
								
								<%-- data를 이용해서 태그에 값 세팅 (대문자 안됨!) --%>
								<button type="button" class="del-btn btn btn-danger" data-bookmark-id="${bookmark.id}">삭제</button>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		<script>
		$(document).ready(function() {
			$('.del-btn').on('click', function () {
				// --- value ---
				// 1)
				// del-btn에서 지금 클릭된 것 = this
				// let id = $(this).val();
				
				// 2)
				// let id = e.target.value;
				
				// --- data ---
				// data-bookmark-id => data("bookmark-id") 함수 사용
				let id = $(this).data('bookmark-id');
				
				console.log(id);
				$.ajax({
					type:"DELETE"
					, url:"/lesson06/quiz01/delete-bookmark"
					, data:{"id":id}
					, success:function(data) {
						if (data.result == "성공") {
							alert("삭제 성공");
							location.reload(); // 새로고침
						}
					}
					, error:function(request, status, error) {
						alert("삭제 실패");
					}
				});
			});
		});
		</script>
		</body>
	</html>