package com.aac.learning.weather.weatherapispringboot.rest.logging;

public class LoggingEvent {

  public static final String EVENT_FORECAST = "forecast";

  public static final String STEP_FORECAST_RESPONSE_RECEIVED = "forecast_response_received";
  public static final String STEP_FORECAST_INVALID_RESPONSE_RECEIVED =
      "forecast_invalid_response_received";
  public static final String STEP_FORECAST_CLIENT_ERROR = "forecast_client_error";

  public static final String MESSAGE_FORECAST_RESPONSE_RECEIVED = "Received Forecast rest response";
}
