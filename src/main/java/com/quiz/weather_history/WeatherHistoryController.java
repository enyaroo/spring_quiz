package com.quiz.weather_history;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather_history.bo.WeatherHistoryBO;
import com.quiz.weather_history.domain.WeatherHistory;

@RequestMapping("/weather")
@Controller
public class WeatherHistoryController {

	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	@GetMapping("/history-view")
	public String historyView(Model model) {
		List<WeatherHistory> weatherHistoryList = weatherHistoryBO.getWeatherHistoryList();
		model.addAttribute("weatherHistoryList", weatherHistoryList);
		
		return "weather_history/history";
	}
		
	@GetMapping("/add-weather-view")
	public String addWeatherView() {
		return "weather_history/add";
	}
	
	// 날씨 추가 로직 -> redirect이므로 String
	@PostMapping("/add-weather")
	public String addWeather(
			// @RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date
			@RequestParam("date") String date
			, @RequestParam("weather") String weather
			, @RequestParam("microDust") String microDust
			, @RequestParam("temperatures") double temperatures
			, @RequestParam("precipitation") double precipitation
			, @RequestParam("windSpeed") double windSpeed
			) {
		
		// DB insert
		weatherHistoryBO.addWeatherHistory(
				date, weather, microDust, temperatures, precipitation, windSpeed);
		
		// response
		// redirect => 히스토리 페이지
		return "redirect:/weather/history-view";
	}
}
