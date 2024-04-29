package com.aac.learning.weather.weatherapispringboot.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Main {
  @JsonProperty("temp")
  private double temperature;

  @JsonProperty("feels_like")
  private double feelsLikeTemperature;

  @JsonProperty("temp_min")
  private double minimumTemperature;

  @JsonProperty("temp_max")
  private double maximumTemperature;

  @JsonProperty("pressure")
  private int pressure;

  @JsonProperty("sea_level")
  private int seaLevel;

  @JsonProperty("grnd_level")
  private int groundLevel;

  @JsonProperty("humidity")
  private int humidity;

  @JsonProperty("temp_kf")
  private int temperatureKF;

  public Main(
      double temperature,
      double feelsLikeTemperature,
      double minimumTemperature,
      double maximumTemperature,
      int pressure,
      int seaLevel,
      int groundLevel,
      int humidity,
      int temperatureKF) {
    this.temperature = temperature;
    this.feelsLikeTemperature = feelsLikeTemperature;
    this.minimumTemperature = minimumTemperature;
    this.maximumTemperature = maximumTemperature;
    this.pressure = pressure;
    this.seaLevel = seaLevel;
    this.groundLevel = groundLevel;
    this.humidity = humidity;
    this.temperatureKF = temperatureKF;
  }

  public Main() {}

  public double getTemperature() {
    return temperature;
  }

  public double getFeelsLikeTemperature() {
    return feelsLikeTemperature;
  }

  public double getMinimumTemperature() {
    return minimumTemperature;
  }

  public double getMaximumTemperature() {
    return maximumTemperature;
  }

  public int getPressure() {
    return pressure;
  }

  public int getSeaLevel() {
    return seaLevel;
  }

  public int getGroundLevel() {
    return groundLevel;
  }

  public int getHumidity() {
    return humidity;
  }

  public int getTemperatureKF() {
    return temperatureKF;
  }
}
