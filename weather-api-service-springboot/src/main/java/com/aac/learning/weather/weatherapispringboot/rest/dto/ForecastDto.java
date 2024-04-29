package com.aac.learning.weather.weatherapispringboot.rest.dto;

import com.aac.learning.weather.weatherapispringboot.rest.model.Main;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"main","dateTxt","forecastSummary"})
@ToString
public class ForecastDto {

        private Main main;

        private String dateTxt;

        private String forecastSummary;

}
