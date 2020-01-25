package com.company.api;

import com.company.model.Weather;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@Service("weatherDao")
public class WeatherJsonParser implements WeatherDao {
    @Override
    public Object getData() throws Exception {
        String sURL = "https://api.openweathermap.org/data/2.5/weather?q=Brzesko,PL&APPID=749561a315b14523a8f5f1ef95e45864&units=metric"; //just a string

        HttpURLConnection connection = null;
        BufferedReader reader = null;

            URL url = new URL(sURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();


            InputStream stream = connection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuilder buffer = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                buffer.append(line).append("\n");
            }

//        Gson gson = new Gson();
//        Weather weather = gson.fromJson(buffer.toString(),Weather.class);
        return buffer.toString();

    }
}
