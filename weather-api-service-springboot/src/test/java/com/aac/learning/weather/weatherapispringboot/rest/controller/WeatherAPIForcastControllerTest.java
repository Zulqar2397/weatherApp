package com.aac.learning.weather.weatherapispringboot.rest.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.aac.learning.weather.weatherapispringboot.rest.dto.ForecastDto;
import com.aac.learning.weather.weatherapispringboot.rest.model.ForecastResponse;
import com.aac.learning.weather.weatherapispringboot.rest.services.WeatherAPIService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@SpringBootTest
class WeatherAPIForcastControllerTest {

  @Autowired private WebApplicationContext webApplicationContext;
  private ObjectMapper objectMapper;
  @MockBean private WeatherAPIService weatherAPIService;
  private MockMvc mockMvc;

  @BeforeEach
  void init() {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    setupForecast();
  }

  @Test
  void getWeatherForecastWithValidEndpointTest() throws Exception {
    String result =
        mockMvc
            .perform(
                MockMvcRequestBuilders.get("/api/weather-forecast/Pune")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse()
            .getContentAsString();
    System.out.println("result:  " + result);
  }

  private void setupForecast() {
    when(weatherAPIService.getWeatherForecast(any()))
        .thenReturn(new List<ForecastDto>() {
          @Override
          public int size() {
            return 0;
          }

          @Override
          public boolean isEmpty() {
            return false;
          }

          @Override
          public boolean contains(Object o) {
            return false;
          }

          @Override
          public Iterator<ForecastDto> iterator() {
            return null;
          }

          @Override
          public Object[] toArray() {
            return new Object[0];
          }

          @Override
          public <T> T[] toArray(T[] a) {
            return null;
          }

          @Override
          public boolean add(ForecastDto forecastDto) {
            return false;
          }

          @Override
          public boolean remove(Object o) {
            return false;
          }

          @Override
          public boolean containsAll(Collection<?> c) {
            return false;
          }

          @Override
          public boolean addAll(Collection<? extends ForecastDto> c) {
            return false;
          }

          @Override
          public boolean addAll(int index, Collection<? extends ForecastDto> c) {
            return false;
          }

          @Override
          public boolean removeAll(Collection<?> c) {
            return false;
          }

          @Override
          public boolean retainAll(Collection<?> c) {
            return false;
          }

          @Override
          public void clear() {

          }

          @Override
          public ForecastDto get(int index) {
            return null;
          }

          @Override
          public ForecastDto set(int index, ForecastDto element) {
            return null;
          }

          @Override
          public void add(int index, ForecastDto element) {

          }

          @Override
          public ForecastDto remove(int index) {
            return null;
          }

          @Override
          public int indexOf(Object o) {
            return 0;
          }

          @Override
          public int lastIndexOf(Object o) {
            return 0;
          }

          @Override
          public ListIterator<ForecastDto> listIterator() {
            return null;
          }

          @Override
          public ListIterator<ForecastDto> listIterator(int index) {
            return null;
          }

          @Override
          public List<ForecastDto> subList(int fromIndex, int toIndex) {
            return null;
          }
        });
  }
}
