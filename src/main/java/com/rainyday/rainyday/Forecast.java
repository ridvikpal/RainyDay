package com.rainyday.rainyday;

import java.util.ArrayList;

public class Forecast {
    ArrayList<ForecastDay> forecastday;

    @Override
    public String toString() {
        return "Forecast{" +
                "forecastday=" + forecastday +
                '}';
    }
}