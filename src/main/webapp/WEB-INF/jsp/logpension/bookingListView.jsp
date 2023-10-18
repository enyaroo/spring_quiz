<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<!-- Bootstrap 4.6 -->
			<link rel="stylesheet"
				href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
				integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
				crossorigin="anonymous">
			<script
				src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
				integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
				crossorigin="anonymous"></script>
			<script
				src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
				integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
				crossorigin="anonymous"></script>
			
			<title>예약 목록 보기</title>
		</head>
		<body>
			<div class="container">
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
							<td>${book.date}</td>
							<td>${book.day}</td>
							<td>${book.headcount}</td>
							<td>${book.phoneNumber}</td>
							<td>${book.state}</td>
							<td><button type="button" class="del-btn btn btn-danger" data-booking-id="${book.id}"></button></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		<script>
			$(document).ready(function() {
				$('.del-btn').on('click', function () {
					let id = $(this).data('booking-id');
					console.log(id);
					$.ajax({
						type:"DELETE"
						, url:"/lesson06/logpension/booking-delete"
						, data:{"id":id}
						, success:function(data) {
							
						}
					});
				});
			});
		</script>
		</body>
	</html>