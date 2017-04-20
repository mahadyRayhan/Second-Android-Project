package com.example.nocturnal.swapingtab;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.nocturnal.WeatherApi.Forecast;
import com.example.nocturnal.WeatherApi.WeatherApi;
import com.example.nocturnal.WeatherApi.WeatherData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class seconfFragment extends Fragment {

    String fullUrl = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22dhaka%2C%20ak%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";

    String baseUrl = "https://query.yahooapis.com/";

    WeatherApi weatherApi;

    private ArrayList<Forecast> forecastArrayList;
    private ListView myListView;
    private Forecast forecast;
    private ForecastAdapter forecastAdapter;


    public seconfFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_seconf, container, false);
        myListView = (ListView) v.findViewById(R.id.myListview);
        forecast = new Forecast();
        forecastArrayList = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        weatherApi = retrofit.create(WeatherApi.class);

        getWeatherData();

        //forecastAdapter = new ForecastAdapter(this,);

        return v;
    }

    private void getWeatherData() {

        Call<WeatherData> weatherDataCall = weatherApi.getWeatherData();
        weatherDataCall.enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                WeatherData weatherData = response.body();
                forecastArrayList = (ArrayList<Forecast>) weatherData.getQuery().getResults().getChannel().getItem().getForecast();
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {

            }
        });
    }

}
