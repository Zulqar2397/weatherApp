package com.aac.learning.weather.weatherapispringboot.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Clouds {
  @JsonProperty("all")
  private long all;

  public Clouds(long all) {
    this.all = all;
  }

  public Clouds() {}

  public long getAll() {
    return all;
  }
}
