package com.example.nocturnal.WeatherApi;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Nocturnal on 19-Apr-17.
 */

public interface WeatherApi {
    @GET("v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22dhaka%2C%20ak%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys")
    Call<WeatherData> getWeatherData();
}
