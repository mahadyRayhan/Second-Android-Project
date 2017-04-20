package com.example.nocturnal.swapingtab;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nocturnal.WeatherApi.Forecast;

import java.util.ArrayList;

/**
 * Created by Nocturnal on 20-Apr-17.
 */

public class ForecastAdapter extends ArrayAdapter<Forecast> {

    private Context context;
    private ArrayList<Forecast> forecastArrayList;

    public ForecastAdapter(Context context, ArrayList<Forecast> forecastArrayList) {
        super(context, R.layout.custom_layout, forecastArrayList);
        this.context = context;
        this.forecastArrayList = forecastArrayList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.custom_layout,parent,false);


        TextView forecast_date_timeTV = (TextView) convertView.findViewById(R.id.forecast_date_time);
        TextView forecast_max_tempTV = (TextView) convertView.findViewById(R.id.forecast_max_temp);
        TextView forecast_min_tempTV = (TextView) convertView.findViewById(R.id.forecast_min_temp);
        TextView forecast_climateTV = (TextView) convertView.findViewById(R.id.forecast_climate);
        ImageView forecast_climate_imageIV = (ImageView) convertView.findViewById(R.id.forecast_climate_image);

        //picture.setImageResource(pictures.get(position).getPicture());
        forecast_date_timeTV.setText(forecastArrayList.get(position).getDay() + ","+ forecastArrayList.get(position).getDate());
        forecast_max_tempTV.setText(forecastArrayList.get(position).getHigh());
        forecast_min_tempTV.setText(forecastArrayList.get(position).getLow());
        forecast_climateTV.setText(forecastArrayList.get(position).getText());
        

        return convertView;
    }
}
