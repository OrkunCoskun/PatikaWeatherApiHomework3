package com.orkuncoskun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orkuncoskun.response.DailyWeatherResponse;
import com.orkuncoskun.response.WeatherResponse;
import com.orkuncoskun.response.WeeklyWeatherResponse;
import com.orkuncoskun.service.WeatherService;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    //Get current weather
    //http://localhost:8080/weather/Turkey/İstanbul
    @GetMapping("/{country}/{city}")
    public WeatherResponse getWeather(@PathVariable String country, @PathVariable String city) {
        return weatherService.getCurrentWeather(country, city);
    }

    //Get daily weather
    //http://localhost:8080/weather/daily/Turkey/İstanbul
    @GetMapping("/daily/{country}/{city}")
    public DailyWeatherResponse getDailyWeather(@PathVariable String country, @PathVariable String city) {
        return weatherService.getDailyWeather(country, city);
    }

    //Get weekly weather
    //http://localhost:8080/weather/weekly/Turkey/İstanbul
    @GetMapping("/weekly/{country}/{city}")
    public WeeklyWeatherResponse getWeeklyWeather(@PathVariable String country, @PathVariable String city) {
        return weatherService.getWeeklyWeather(country, city);
    }
    
    //couldn't implement monthly because OpenWeatherMap API does not provide a monthly forecast.

}

