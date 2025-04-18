

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class WeatherService {
    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather";
    private final OkHttpClient client;
    private final ObjectMapper mapper;
    private final String apiKey;

    public WeatherService(OkHttpClient client, ObjectMapper mapper, String apiKey) {
        this.client = client;
        this.mapper = mapper;
        this.apiKey = apiKey;
    }


    public WeatherResponse getWeatherByCity(String city) throws IOException {
        HttpUrl url = HttpUrl.parse(API_URL).newBuilder()
                .addQueryParameter("q", city)
                .addQueryParameter("appid", apiKey)
                .addQueryParameter("units", "metric")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response resp = client.newCall(request).execute()) {
            if (!resp.isSuccessful()) {
                throw new IOException("Erreur météo: " + resp.code() + " " + resp.message());
            }
            return mapper.readValue(resp.body().string(), WeatherResponse.class);
        }
    }
}
