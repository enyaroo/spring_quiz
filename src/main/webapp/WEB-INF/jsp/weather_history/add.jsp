<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<!-- Bootstrap 4.6 -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
		<!-- CSS -->
		<link rel="stylesheet" href="/css/weather_history/weather.css">
		
		<title>날씨 입력</title>
	</head>
	<body>
		<div class="main container bg-secondary">
			<div class="upper bg-warning d-flex">
				<nav class="bg-primary col-2"></nav>
				<div class="bg-danger col-10">
					<h1>날씨 입력</h1>
					<form method="post" action="/lesson05/weather-history/add">
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
			<footer class="bg-success"></footer>
		</div>
	</body>
</html>