package com.aac.learning.weather.weatherapispringboot.rest.services;

import com.aac.learning.weather.weatherapispringboot.rest.dto.ForecastDto;
import com.aac.learning.weather.weatherapispringboot.rest.logging.LoggingEvent;
import com.aac.learning.weather.weatherapispringboot.rest.model.Forecast;
import com.aac.learning.weather.weatherapispringboot.rest.model.ForecastResponse;
import com.aac.learning.weather.weatherapispringboot.rest.utils.ForecastResponseProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;



import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherAPIService {

  @Value("${weather-api.api.forecast.url}")
  private String weatherApiUrl;

  @Value("${weather-api.api.key}")
  private String apiKey;

  @Value("${weather-api.api.forecast.numberofdays}")
  private String numberOfDays;

  private RestTemplate weatherAPIRestTemplate;

  private static final Logger logger =
      LoggerFactory.getLogger(WeatherAPIService.class);

  public WeatherAPIService(RestTemplateBuilder restTemplateBuilder) {
    weatherAPIRestTemplate = restTemplateBuilder.build();
  }

  public List<ForecastDto> getWeatherForecast(String city) {
    URI url = new UriTemplate(weatherApiUrl).expand(city, apiKey, numberOfDays);
    // System.out.println(weatherAPIRestTemplate.getForEntity(url, String.class));
    ResponseEntity<ForecastResponse> response =
        weatherAPIRestTemplate.getForEntity(url, ForecastResponse.class);
    ForecastResponseProcessor.processForecastResponse(response.getBody());
    System.out.println("++++++ " + response);
    logger.info(
        LoggingEvent.EVENT_FORECAST, LoggingEvent.STEP_FORECAST_RESPONSE_RECEIVED
            ,LoggingEvent.MESSAGE_FORECAST_RESPONSE_RECEIVED);
    logger.info(
       LoggingEvent.EVENT_FORECAST, LoggingEvent.STEP_FORECAST_RESPONSE_RECEIVED,
            response.getBody().getForecasts().toString());
    System.out.println("++++++----- " + response.getBody().toString());
  List<ForecastDto> result = new ArrayList<>();
   response.getBody().getForecasts().forEach((forecast -> {
     ForecastDto forecastDto = new ForecastDto();
     BeanUtils.copyProperties(forecast, forecastDto);
     result.add(forecastDto);
   }));
    return result;
  }
}
