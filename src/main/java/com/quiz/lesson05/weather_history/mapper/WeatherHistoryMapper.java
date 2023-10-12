package com.quiz.lesson05.weather_history.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.lesson05.weather_history.domain.Weather;

@Repository
public interface WeatherHistoryMapper {
	
	public List<Weather> selectWeatherList();
	
	public void insertWeather(Weather weather);
	
}
