package net.engineeringdigest.journalApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import net.engineeringdigest.journalApp.api.response.WeatherResponse;
import net.engineeringdigest.journalApp.cache.AppCache;

@Service
public class WeatherService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;
    

    public WeatherResponse getWeather(String city) {
    String finalAPI = appCache.API_CACHE.get("weather_api").replace("CITY", city);
    ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null,WeatherResponse.class);
    WeatherResponse body = response.getBody();
    return body;

    }


}
