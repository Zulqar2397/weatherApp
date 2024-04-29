package com.aac.learning.weather.weatherapispringboot.rest.model;

import com.aac.learning.weather.weatherapispringboot.rest.utils.EmptyListFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY, valueFilter = EmptyListFilter.class)
public class ForecastResponse {

  @JsonProperty("list")
  private List<Forecast> forecasts;

  public ForecastResponse(
          List<Forecast> forecasts) {
    this.forecasts = forecasts;
  }

  public ForecastResponse() {}


  @JsonIgnore
  public List<Forecast> getForecasts() {
    return forecasts;
  }

}
