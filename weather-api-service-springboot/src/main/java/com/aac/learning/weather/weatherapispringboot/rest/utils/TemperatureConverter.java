package com.aac.learning.weather.weatherapispringboot.rest.utils;

public class TemperatureConverter {

  public static double kelvinToCelsius(double kelvinTemp) {
    double celsiusTemp = 0.0;
    celsiusTemp = kelvinTemp - 273.15;
    return celsiusTemp;
  }
}
