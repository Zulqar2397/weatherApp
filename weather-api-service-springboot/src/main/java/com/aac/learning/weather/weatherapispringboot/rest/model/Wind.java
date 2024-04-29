package com.aac.learning.weather.weatherapispringboot.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Wind {
  @JsonProperty("speed")
  private double speed;

  @JsonProperty("deg")
  private int degree;

  @JsonProperty("gust")
  private double gust;

  public Wind(double speed, int degree, double gust) {
    this.speed = speed;
    this.degree = degree;
    this.gust = gust;
  }

  public Wind() {}

  public double getSpeed() {
    return speed;
  }

  public int getDegree() {
    return degree;
  }

  public double getGust() {
    return gust;
  }
}
