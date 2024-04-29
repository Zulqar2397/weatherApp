import React, { useState } from 'react';
import axios from 'axios';
import WeatherDisplay from './WeatherDisplay';

const CityInput = () => {
  const [city, setCity] = useState('');
  const [weatherData, setWeatherData] = useState(null);
  const [error, setError] = useState(null);

  const handleInputChange = (event) => {
    setCity(event.target.value);
  };

  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      const response = await axios.get(`http://localhost:8080/api/weather-forecast/${city}`);
      const data = response.data;
      console.log(response);
      setWeatherData(data);
      setError(null);
    } catch (error) {
      setError(error.message);
    }
  };

  return (
    <div>
      <h2>Enter City:</h2>
      <form onSubmit={handleSubmit}>
        <input type="text" value={city} onChange={handleInputChange} />
        <button type="submit">Get Weather</button>
      </form>
      {error && <p style={{ color: 'red' }}>{error}</p>}
      {weatherData && <WeatherDisplay data={weatherData} />}
    </div>
  );
};

export default CityInput;
