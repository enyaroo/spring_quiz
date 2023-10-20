<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<!-- Bootstrap 4.6 -->
			<link rel="stylesheet"
				href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
				integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
				crossorigin="anonymous">
				
			<!-- jquery 원본 -->
			<script src="https://code.jquery.com/jquery-3.7.1.js" 
				integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" 
				crossorigin="anonymous"></script>
			<script
				src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
				integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
				crossorigin="anonymous"></script>
			
			<!-- stylesheet -->
			<link rel="stylesheet" type="text/css" href="/css/booking/style.css">
			
			<title>통나무 펜션</title>
		</head>
		<body>
			<div id="wrap" class="container">
				<header class="d-flex justify-content-center align-items-center">
					<div class="title display-4">
						<a href="/lesson06/logpension/main">통나무 펜션</a>
					</div>
				</header>
				<nav>
					<ul class="nav nav-fill">
						<li class="nav-item"><a href="#" class="nav-link text-white font-weight-bold">펜션소개</a></li>
						<li class="nav-item"><a href="#" class="nav-link text-white font-weight-bold">객실보기</a></li>
						<li class="nav-item"><a href="/lesson06/logpension/add-booking-view" class="nav-link text-white font-weight-bold">예약하기</a></li>
						<li class="nav-item"><a href="/lesson06/logpension/booking-view" class="nav-link text-white font-weight-bold">예약목록</a></li>
					</ul>
				</nav>
				<section class="contents">
					<h2 class="text-center font-weight-bold m-4">예약 목록 보기</h2>
					<table class="table text-center">
						<thead>
							<tr>
								<th>이름</th>
								<th>예약날짜</th>
								<th>숙박일수</th>
								<th>숙박인원</th>
								<th>전화번호</th>
								<th>예약상태</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${bookingList}" var="book">
							<tr>
								<td>${book.name}</td>
								<td><fmt:formatDate value="${book.date}" pattern="yyyy년 M월 d일" /></td>
								<td>${book.day}</td>
								<td>${book.headcount}</td>
								<td>${book.phoneNumber}</td>
								<td>
									<c:choose>
										<c:when test="${book.state == \"확정\"}">
											<span class="text-success">${book.state}</span>
										</c:when>
										<c:when test="${book.state eq '대기중'}">
											<span class="text-info">${book.state}</span>
										</c:when>
										<c:when test="${book.state eq '취소'}">
											<span class="text-danger">${book.state}</span>
										</c:when>
									</c:choose>
								</td>
								<td><button type="button" class="del-btn btn btn-danger" data-booking-id="${book.id}">삭제</button></td>
							</tr>
						</c:forEach>
						</tbody>
					</table>					
				</section>
				<footer>
					<small class="text-secondary">
						제주특별자치도 제주시 애월읍<br>
		        		사업자등록번호: 111-22-255222 / 농어촌민박사업자지정 / 대표:김통목<br>
		        		Copyright 2025 tongnamu. All right reserved.
					</small>
				</footer>
			</div>
		<script>
			$(document).ready(function() {
				$('.del-btn').on('click', function() {
					let id = $(this).data('booking-id');
					console.log(id);
					$.ajax({
						type:"DELETE"
						, url:"/lesson06/logpension/booking-delete"
						, data:{"id":id}
						, success:function(data) {
							if (data.result == "success") {
								alert("삭제 성공");
								location.reload();
							} else {
								// 로직 에러
								alert("삭제 실패");
							}
						}
						, error:function(request, status, error) {
							alert("삭제 에러, 관리자에게 문의해 주세요.");
						}
					});
				});
			});
		</script>
		</body>
	</html>