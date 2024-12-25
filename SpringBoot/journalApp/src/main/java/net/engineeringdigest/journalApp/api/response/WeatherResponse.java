package net.engineeringdigest.journalApp.api.response;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherResponse {
    public String temperature;
    public String wind;
    public String description;
    public ArrayList<Forecast> forecast;
}

@Getter
@Setter
 class Forecast {
    public String day;
    public String temperature;
    public String wind;
}


