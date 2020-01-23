package com.company.api;


import com.company.model.Weather;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
public class WeatherMapper {
    @RequestMapping(method = RequestMethod.GET)
    public String printWeather(ModelMap model){
        model.addAttribute("weatherData", "Hello Spring");
        return "hello";
    }
}