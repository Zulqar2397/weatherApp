package com.aac.learning.weather.weatherapispringboot.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class City {
  @JsonProperty("id")
  private long id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("coord")
  private Coordinate cord;

  @JsonProperty("country")
  private String country;

  @JsonProperty("population")
  private long population;

  @JsonProperty("timezone")
  private long timezone;

  @JsonProperty("sunrise")
  private long sunrise;

  @JsonProperty("sunset")
  private long sunset;

  public City(
      long id,
      String name,
      Coordinate cord,
      String country,
      long population,
      long timezone,
      long sunrise,
      long sunset) {
    this.id = id;
    this.name = name;
    this.cord = cord;
    this.country = country;
    this.population = population;
    this.timezone = timezone;
    this.sunrise = sunrise;
    this.sunset = sunset;
  }

  public City() {}

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Coordinate getCord() {
    return cord;
  }

  public String getCountry() {
    return country;
  }

  public long getPopulation() {
    return population;
  }

  public long getTimezone() {
    return timezone;
  }

  public long getSunrise() {
    return sunrise;
  }

  public long getSunset() {
    return sunset;
  }
}
