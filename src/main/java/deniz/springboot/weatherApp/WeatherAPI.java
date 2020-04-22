package deniz.springboot.weatherApp;

import deniz.springboot.weatherApp.models.CurrentWeather;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherAPI {

    @GET("forecast.json?key=7d4c6b96f48444bba34124516202004")
    public Call<CurrentWeather> getWeather(@Query("q") String city, @Query("days") int days );

}
