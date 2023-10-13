<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<!-- jquery 원본 : bootstrap, datepicker -->
		<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
		
		<!-- Bootstrap 4.6 -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
		
		<!-- datepicker -->
		<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
		<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
		
		<!-- CSS -->
		<link rel="stylesheet" href="/css/weather_history/weather.css">
		
		<title>날씨 입력</title>
	</head>
	<body>
		<div class="main container">
			<div class="upper d-flex">
				<nav class="col-2"></nav>
				<div class="col-10">
					<h1>날씨 입력</h1>
					<form method="post" action="/weather/add-weather">
						<div class="form-group d-flex">
							<label for="date">날짜</label>
							<input type="text" id="date" name="date" class="form-control col-3">
						</div>
						<div class="form-group d-flex">
							<label for="weather">날씨</label>
							<select id="weather" name="weather" class="form-control col-3">
								<option value="맑음">맑음</option>
								<option value="구름조금">구름조금</option>
								<option value="흐림">흐림</option>
								<option value="비">비</option>
							</select>
						</div>
						<div class="form-group d-flex">
							<label for="microDust">미세먼지</label>
							<select id="microDust" name="microDust" class="form-control col-3">
								<option value="좋음">좋음</option>
								<option value="보통">보통</option>
								<option value="나쁨">나쁨</option>
								<option value="최악">최악</option>
							</select>
						</div>
						<div class="form-group d-flex">
							<label for="temperatures">기온</label>
							<input type="text" id="temperatures" name="temperatures" class="form-control col-3">
						</div>
						<div class="form-group d-flex">
							<label for="precipitation">강수량</label>
							<input type="text" id="precipitation" name="precipitation" class="form-control col-3">
						</div>
						<div class="form-group d-flex">
							<label for="windSpeed">풍속</label>
							<input type="text" id="windSpeed" name="windSpeed" class="form-control col-3">
						</div>
						<input type="submit" class="btn btn-success" value="저장">
					</form>
				</div>
			</div>
			<footer></footer>
		</div>
		
		<script>
			// ready : DOM tree 가 완성된 후 불려지는 함수
			$(document).ready(function() {
				$("#date").datepicker({
					dateFormat:"yy-mm-dd" // 날짜 포맷
				});
			});
		</script>
	</body>
</html>