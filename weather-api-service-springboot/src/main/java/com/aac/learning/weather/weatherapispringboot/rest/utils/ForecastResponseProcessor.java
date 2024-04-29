package com.aac.learning.weather.weatherapispringboot.rest.utils;

import com.aac.learning.weather.weatherapispringboot.rest.model.Forecast;
import com.aac.learning.weather.weatherapispringboot.rest.model.ForecastResponse;
import com.aac.learning.weather.weatherapispringboot.rest.model.Weather;

import java.util.Arrays;
import java.util.List;

public class ForecastResponseProcessor {
  private ForecastResponseProcessor() {
    throw new IllegalStateException("ForecastResponseProcessor is Utility class");
  }
  /**
   * This api is use to add Forecast Summary to each day forecast based on wind, temperature and
   * rain condition 1. If rain is predicted in next 3 days -then mention 'Carry umbrella' 2. In case
   * of high winds (i.e.,) Wind > 10mph, mention “It’s too windy, watch out!” 3. In case of
   * Thunderstorms, mention “Don’t step out! A Storm is brewing!” 4. If temperature goes above 40
   * degree Celsius in next 3 days then mention 'Use sunscreen lotion' We can use constants for
   * messages if it grows
   *
   * @param forecastResponse
   * @return ForecastResponse
   */
  public static ForecastResponse processForecastResponse(ForecastResponse forecastResponse) {

    List<Forecast> forecasts = forecastResponse.getForecasts();
    if (!forecasts.isEmpty()) {
      for (Forecast forecast : forecasts) {
        StringBuilder summaryBuilder = new StringBuilder();

      if (forecast.getWind().getSpeed() > 10.00)
          summaryBuilder.append("Wind Warning: It’s too windy, watch out! ");
        if (TemperatureConverter.kelvinToCelsius(forecast.getMain().getMaximumTemperature())
            > 40.00) summaryBuilder.append("Temperature Warning: Use sunscreen lotion.");
        summaryBuilder.append(getRainAndThunderstormSummary(forecast.getWeather().get(0)));
        forecast.setForecastSummary(summaryBuilder.toString());
      }
    }
    return forecastResponse;
  }

  private static String getRainAndThunderstormSummary(Weather weather) {
    StringBuilder summaryBuilder = new StringBuilder();
    if (weather.getId() >= 200 && weather.getId() < 233)
      summaryBuilder.append("Thunderstorm Warning: Don’t step out! A Storm is brewing! ");
    if (weather.getId() >= 500 && weather.getId() < 532)
      summaryBuilder.append("Rain Warning: 'Carry umbrella' ");
    return summaryBuilder.toString();
  }
}
