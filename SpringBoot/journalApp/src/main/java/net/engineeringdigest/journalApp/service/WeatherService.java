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

    @Autowired
    private RedisService redisService;
    

    public WeatherResponse getWeather(String city) {
        WeatherResponse weatherResponseResponse = redisService.get(city, WeatherResponse.class);
        if (weatherResponseResponse != null) {
            return weatherResponseResponse;
        }
        else {
            String finalAPI = appCache.API_CACHE.get("weather_api").replace("CITY", city);
            ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null,
                    WeatherResponse.class);
            WeatherResponse body = response.getBody().weather.get(0);
            System.out.println(body);
            if (body != null) {
        redisService.set(city, body, 300l);
       }

            return body;  
        }
        
    

    }


}
