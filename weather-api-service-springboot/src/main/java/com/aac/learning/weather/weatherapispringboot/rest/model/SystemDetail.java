package com.aac.learning.weather.weatherapispringboot.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SystemDetail {
  @JsonProperty("pod")
  private String pod;

  public SystemDetail(String pod) {
    this.pod = pod;
  }

  public SystemDetail() {}

  public String getPod() {
    return this.pod;
  }
}
