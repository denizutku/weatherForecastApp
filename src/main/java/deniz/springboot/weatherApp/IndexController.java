package deniz.springboot.weatherApp;

import deniz.springboot.weatherApp.models.Current;
import deniz.springboot.weatherApp.models.CurrentWeather;
import deniz.springboot.weatherApp.models.Forecast;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {

    private final WeatherService weatherService;

    public IndexController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    CurrentWeather currentWeather = new CurrentWeather();

    @GetMapping("/")
    public String index() {

        return "index";
    }

    @GetMapping("/postData")
    public String postData(@RequestParam(value = "city") String city, @RequestParam(value = "days") int days, Model model) {
        currentWeather = weatherService.getWeatherDetails(city,days);
        model.addAttribute("weather",currentWeather);
        model.addAttribute("forecasts",currentWeather.getForecast().getForecastday());
        return "data";

    }


}
