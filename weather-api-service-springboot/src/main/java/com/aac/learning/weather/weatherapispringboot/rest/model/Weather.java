package com.aac.learning.weather.weatherapispringboot.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Weather {
  @JsonProperty("id")
  private long id;

  @JsonProperty("main")
  private String main;

  @JsonProperty("description")
  private String description;

  @JsonProperty("icon")
  private String icon;

  public Weather(long id, String main, String description, String icon) {
    this.id = id;
    this.main = main;
    this.description = description;
    this.icon = icon;
  }

  public Weather() {}

  public long getId() {
    return id;
  }

  public String getMain() {
    return main;
  }

  public String getDescription() {
    return description;
  }

  public String getIcon() {
    return icon;
  }
}
