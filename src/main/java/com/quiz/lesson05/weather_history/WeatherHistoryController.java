package com.quiz.lesson05.weather_history;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson05.weather_history.bo.WeatherHistoryBO;
import com.quiz.lesson05.weather_history.domain.Weather;

@RequestMapping("/lesson05/weather-history")
@Controller
public class WeatherHistoryController {
	
	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	@GetMapping("/main")
	public String main(Model model) {
		List<Weather> weatherList = weatherHistoryBO.getWeatherList();
		model.addAttribute("weatherList", weatherList);
		
		return "weather_history/main";
	}
	
	@GetMapping("/add-weather")
	public String addWeather() {
		return "weather_history/add";
	}
	
	
	@PostMapping("/add")
	public String add(@ModelAttribute Weather weather) {
		weatherHistoryBO.addWeather(weather);
		
		return "weather_history/main";
	}
	
}
