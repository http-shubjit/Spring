

package net.engineeringdigest.journalApp.api.response;



import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherResponse {
    public int id;
    public String main;
    public String description;
    public String icon;
    public ArrayList<WeatherResponse> weather;

}









