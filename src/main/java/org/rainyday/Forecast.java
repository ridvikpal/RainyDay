package org.rainyday;

import java.util.ArrayList;

public class Forecast {
    ArrayList<ForecastDay> forecastday;

    public ArrayList<ForecastDay> getForecastday() {
        return forecastday;
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "forecastday=" + forecastday +
                '}';
    }
}