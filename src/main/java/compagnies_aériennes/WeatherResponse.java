

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {

    @JsonProperty("weather")
    private List<Weather> weather;

    @JsonProperty("main")
    private MainInfo main;

    // Getters & setters
    public List<Weather> getWeather() { return weather; }
    public MainInfo getMain()      { return main;    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Weather {
        @JsonProperty("description")
        private String description;
        public String getDescription() { return description; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MainInfo {
        @JsonProperty("temp")
        private double temp;
        public double getTemp() { return temp; }
    }
}
