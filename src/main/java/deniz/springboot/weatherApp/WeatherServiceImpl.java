package deniz.springboot.weatherApp;

import deniz.springboot.weatherApp.models.Current;
import deniz.springboot.weatherApp.models.CurrentWeather;
import deniz.springboot.weatherApp.models.Forecast;
import okhttp3.OkHttpClient;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {


    CurrentWeather weather = new CurrentWeather();
    CurrentWeather returnWeather = new CurrentWeather();

    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://api.weatherapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build();

    WeatherAPI weatherAPI = retrofit.create(WeatherAPI.class);

    @Override
    public CurrentWeather getWeatherDetails(String city, int days) {

        Call<CurrentWeather> callSync = weatherAPI.getWeather(city,days);

        try {
            Response<CurrentWeather> response = callSync.execute();
            weather = response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        returnWeather.setCurrent(weather.getCurrent());
        returnWeather.setForecast(weather.getForecast());
        returnWeather.setLocation(weather.getLocation());
        returnWeather.setAlert(weather.getAlert());



        return returnWeather;
    }

}
