import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;

public class MainV2 {
    public static void main(String[] args) {
        String weatherApiKey = "07b22b67c1ee4eb99b125a5f48fbdfd6";
        WeatherService weatherSvc = new WeatherService(
                new OkHttpClient(), new ObjectMapper(), weatherApiKey);

        try {
            WeatherResponse w = weatherSvc.getWeatherByCity("Paris");
            System.out.printf("Il fait %.1f °C à Paris, %s%n",
                    w.getMain().getTemp(),
                    w.getWeather().get(0).getDescription());
        } catch (Exception e) {
            System.err.println("Impossible de récupérer la météo : " + e.getMessage());
        }
    }
}

