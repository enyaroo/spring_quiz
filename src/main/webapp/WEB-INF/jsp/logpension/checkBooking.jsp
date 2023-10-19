<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					<div class="display-4">통나무 펜션</div>
				</header>
				<nav>
					<ul class="nav nav-fill">
						<li class="nav-item"><a href="#" class="nav-link text-white font-weight-bold">펜션소개</a></li>
						<li class="nav-item"><a href="#" class="nav-link text-white font-weight-bold">객실보기</a></li>
						<li class="nav-item"><a href="/lesson06/logpension/add-booking-view" class="nav-link text-white font-weight-bold">예약하기</a></li>
						<li class="nav-item"><a href="/lesson06/logpension/booking-view" class="nav-link text-white font-weight-bold">예약목록</a></li>
					</ul>
				</nav>
				<section class="banner bg-info">
					<img id="bannerImage" src="/img/test06_banner1.jpg" alt="banner" width="1110" height="500">
				</section>
				<section class="reserve d-flex">
					<section class="real-time-reserved col-4 d-flex justify-content-center align-items-center">
						<div class="display-4 text-white">실시간<br>예약하기</div>
					</section>
					<section class="confirm col-4">
						<div class="m-3">
							<span class="reserve-confirm mr-3">예약 확인</span>
						</div>
						<div id="memberInputBox" class="m-2">
							<div class="d-flex justify-content-end mr-3">
								<span class="text-white">이름:</span>
								<input type="text" id="name" class="form-control input-form">
							</div>
							<div class="d-flex mt-2 justify-content-end mr-3">
								<span class="text-white">전화번호:</span>
								<input type="text" id="phoneNumber" class="form-control input-form">
							</div>
							<div class="text-right mt-3 mr-3">
								<button type="button" class="submit-btn btn btn-success">조회하기</button>
							</div>
						</div>
					</section>
					<section class="inquiry col-4 d-flex justify-content-center align-items-center">
						<div class="text-white">
							<h4 class="font-weight-bold">예약문의:</h4>
							<h1>010-<br>0000-1111</h1>
						</div>
					</section>
				</section>
				<footer>
					<small class="text-secondary">
						제주특별자치도 제주시 애월읍<br>
		        		사업자등록번호: 111-22-255222 / 농어촌민박사업자지정 / 대표:김통목<br>
		        		Copyright 2025 tongnamu. All right reserved.
					</small>
				</footer>
			<script>
				$(document).ready(function() {
					$('.submit-btn').on('click', function() {
						let name = $('#name').val().trim();
						let phoneNumber = $('#phoneNumber').val().trim();
					
						// validation check
						if (!name) {
							alert("이름을 입력하세요");
							return;
						}
						if (!phoneNumber) {
							alert("전화번호를 입력하세요");
							return;
						}
						
						console.log(name);
						console.log(phoneNumber);
						
						$.ajax({
							type:"POST"
							, url:"/lesson06/logpension/check-booking"
							, data:{"name":name
								, "phoneNumber":phoneNumber}
							, success:function(data) {
								if (data.result == "success") {
									let text = "이름 : " + data.bookingExist.name + "\n"
												+ "날짜 : " + data.bookingExist.date + "\n"
												+ "일수 : " + data.bookingExist.day + "\n"
												+ "인원 : " + data.bookingExist.headcount + "\n"
												+ "상태 : " + data.bookingExist.state
									alert(text);
									location.reload();
								} else {
									alert("예약 조회 실패");
								}
							}
							, error:function(request, status, error) {
								alert("예약 조회 실패, 관리자에게 문의해 주세요");
							}
						});
					});
				});
			</script>
			</div>
		</body>
	</html>