package net.engineeringdigest.journalApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.Value;
import net.engineeringdigest.journalApp.api.response.WeatherResponse;

@Service
public class WeatherService {
    @Autowired
    private RestTemplate restTemplate;


    private static final String API= "https://goweather.herokuapp.com/weather/CITY";
    

public WeatherResponse getWeather(String city) {
    String finalAPI = API.replace("CITY", city);
       

    ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null,
            WeatherResponse.class);

    WeatherResponse body = response.getBody();
    return body;

    }


}
