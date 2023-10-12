package com.quiz.lesson05.weather_history.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson05.weather_history.domain.Weather;
import com.quiz.lesson05.weather_history.mapper.WeatherHistoryMapper;

@Service
public class WeatherHistoryBO {
	
	@Autowired
	private WeatherHistoryMapper weatherHistoryMapper;
	
	public List<Weather> getWeatherList() {
		return weatherHistoryMapper.selectWeatherList();
	}
	
	public void addWeather(Weather weather) {
		weatherHistoryMapper.insertWeather(weather);
	}
	
}
