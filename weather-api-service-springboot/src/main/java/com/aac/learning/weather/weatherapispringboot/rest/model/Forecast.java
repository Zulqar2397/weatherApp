package com.aac.learning.weather.weatherapispringboot.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Forecast {
  @JsonProperty("dt")
  private long date;

  @JsonProperty("main")
  private Main main;

  @JsonProperty("weather")
  private List<Weather> weather;

  @JsonProperty("clouds")
  private Clouds clouds;

  @JsonProperty("wind")
  private Wind wind;

  @JsonProperty("visibility")
  private long visibility;

  @JsonProperty("pop")
  private long pop;

  @JsonProperty("sys")
  private SystemDetail systemDetail;

  @JsonProperty("dt_txt")
  private String dateTxt;

  @JsonProperty("forecast_summary")
  private String forecastSummary;

  public Forecast(
      long date,
      Main main,
      List<Weather> weather,
      Clouds clouds,
      Wind wind,
      long visibility,
      long pop,
      SystemDetail systemDetail,
      String dateTxt,
      String forecastSummary) {
    this.date = date;
    this.main = main;
    this.weather = weather;
    this.clouds = clouds;
    this.wind = wind;
    this.visibility = visibility;
    this.pop = pop;
    this.systemDetail = systemDetail;
    this.dateTxt = dateTxt;
    this.forecastSummary = forecastSummary;
  }

  public Forecast() {}

  public long getDate() {
    return date;
  }

  public Main getMain() {
    return main;
  }

  public List<Weather> getWeather() {
    return weather;
  }

  public Clouds getClouds() {
    return clouds;
  }

  public Wind getWind() {
    return wind;
  }

  public long getVisibility() {
    return visibility;
  }

  public long getPop() {
    return pop;
  }

  public SystemDetail getSystemDetail() {
    return systemDetail;
  }

  public String getDateTxt() {
    return dateTxt;
  }

  public String getForecastSummary() {
    return this.forecastSummary;
  }

  public void setForecastSummary(String forecastSummary) {
    this.forecastSummary = forecastSummary;
  }
}
