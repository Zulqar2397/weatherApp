import React from "react";

const WeatherDisplay = ({ data }) => {
  console.log(data);
  if (!data) {
    return null;
  }

  return (
    <div>
      <h2>Weather Forecast</h2>
      {data.map((item, index) => (
        <div key={index}>
          <p>
            Date: {item.dateTxt}
          </p>
          <p>High: {Math.round(item.main.temp_max - 273)} (C)</p>
          <p>Low: {Math.round(item.main.temp_min - 273)} (C)</p>
          {item.forecastSummary && item.forecastSummary != "" && (
            <p>Warnings: {item.forecastSummary}</p>
          )}{" "}
        </div>
      ))}
    </div>
  );
};

export default WeatherDisplay;
