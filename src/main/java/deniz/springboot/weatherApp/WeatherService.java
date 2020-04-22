package deniz.springboot.weatherApp;

import deniz.springboot.weatherApp.models.CurrentWeather;
import deniz.springboot.weatherApp.models.Forecast;
import org.springframework.stereotype.Service;

import java.util.List;

public interface WeatherService {

    public CurrentWeather getWeatherDetails(String city, int days);

}
