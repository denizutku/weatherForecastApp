package deniz.springboot.weatherApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherAppApplication
{
	public static void main(String[] args) {
		SpringApplication.run(WeatherAppApplication.class, args);
	}
}
