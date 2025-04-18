import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.IOException;
import java.util.Map;

public class FlightSearch {
    private static final String API_KEY =
            "JfKtg0og713nCgqd5snIH6lSVuAY";
    private static final String API_URL =
            "https://test.api.amadeus.com/v2/shopping/flight-offers?originLocationCode=JFK&destinationLocationCode=LAX&departureDate=2025-05-05&adults=1&nonStop=false&max=250";
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse(API_URL).newBuilder();
        urlBuilder.addQueryParameter("originLocationCode", "JFK");
        urlBuilder.addQueryParameter("destinationLocationCode", "LAX");
        urlBuilder.addQueryParameter("departureDate", "2025-05-05");
        urlBuilder.addQueryParameter("adults", "1");
        Request request = new Request.Builder()
                .url(urlBuilder.build().toString())
                .addHeader("Authorization", "Bearer " + API_KEY)
                .build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            String jsonResponse = response.body().string();
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> flightData =
                    mapper.readValue(jsonResponse, Map.class);
            System.out.println(flightData);
        } else {
            System.err.println("Error: " + response.code() + " - " +
                    response.message());
        }
    }
}

