package com.aac.learning.weather.weatherapispringboot.rest.controller;

import com.aac.learning.weather.weatherapispringboot.rest.dto.ForecastDto;
import com.aac.learning.weather.weatherapispringboot.rest.model.ForecastResponse;
import com.aac.learning.weather.weatherapispringboot.rest.services.WeatherAPIService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@Validated
@CrossOrigin("*")
public class WeatherAPIForcastController {
  private WeatherAPIService weatherAPIService;

  public WeatherAPIForcastController(WeatherAPIService weatherAPIService) {
    this.weatherAPIService = weatherAPIService;
  }

  @GetMapping(
      value = {"/api/weather-forecast/{city}"},
      produces = {"application/json"})
  public ResponseEntity<List<ForecastDto>> getWeatherForecast(
      @PathVariable("city") @NonNull String city) {
    List<ForecastDto> forecastResponse = weatherAPIService.getWeatherForecast(city);
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(forecastResponse);
  }
}
