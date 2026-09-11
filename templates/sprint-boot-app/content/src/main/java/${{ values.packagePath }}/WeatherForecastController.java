package ${{ values.javaPackage }};

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/weatherforecast")
public class WeatherForecastController {

    private static final String[] SUMMARIES = {
        "Freezing", "Bracing", "Chilly", "Cool", "Mild",
        "Warm", "Balmy", "Hot", "Sweltering", "Scorching"
    };

    @GetMapping
    public List<WeatherForecast> get() {
        return IntStream.rangeClosed(1, 5)
            .mapToObj(index -> {
                int temperatureC = ThreadLocalRandom.current().nextInt(-20, 55);
                String summary = SUMMARIES[ThreadLocalRandom.current().nextInt(SUMMARIES.length)];
                return new WeatherForecast(LocalDate.now().plusDays(index), temperatureC, summary);
            })
            .toList();
    }

    public record WeatherForecast(LocalDate date, int temperatureC, String summary) {
        public int temperatureF() {
            return 32 + (int) (temperatureC / 0.5556);
        }
    }
}
