package com.rainyday.rainyday;

public class Current{
    private double temp_c, temp_f, wind_mph, wind_kph, pressure_mb, pressure_in, feelslike_c, feelslike_f
            , vis_km, vis_miles, uv, precip_mm, precip_in, gust_mph, gust_kph;

    private int is_day, last_updated_epoch, wind_degree, humidity, cloud;

    private String wind_dir, last_updated;

    private Condition condition;

    private AirQuality air_quality;

    // GETTERS
    public double getTemp_c() {
        return temp_c;
    }

    public double getTemp_f() {
        return temp_f;
    }

    public double getWind_mph() {
        return wind_mph;
    }

    public double getWind_kph() {
        return wind_kph;
    }

    public double getPressure_mb() {
        return pressure_mb;
    }

    public double getPressure_in() {
        return pressure_in;
    }

    public double getFeelslike_c() {
        return feelslike_c;
    }

    public double getFeelslike_f() {
        return feelslike_f;
    }

    public double getVis_km() {
        return vis_km;
    }

    public double getVis_miles() {
        return vis_miles;
    }

    public double getUv() {
        return uv;
    }

    public double getPrecip_mm() {
        return precip_mm;
    }

    public double getPrecip_in() {
        return precip_in;
    }

    public double getGust_mph() {
        return gust_mph;
    }

    public double getGust_kph() {
        return gust_kph;
    }

    public int getIs_day() {
        return is_day;
    }

    public int getLast_updated_epoch() {
        return last_updated_epoch;
    }

    public int getWind_degree() {
        return wind_degree;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getCloud() {
        return cloud;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public Condition getCondition() {
        return condition;
    }

    public AirQuality getAir_quality() {
        return air_quality;
    }

    @Override
    public String toString() {
        return "Current{" +
                "temp_c=" + temp_c +
                ", temp_f=" + temp_f +
                ", wind_mph=" + wind_mph +
                ", wind_kph=" + wind_kph +
                ", pressure_mb=" + pressure_mb +
                ", pressure_in=" + pressure_in +
                ", feelslike_c=" + feelslike_c +
                ", feelslike_f=" + feelslike_f +
                ", vis_km=" + vis_km +
                ", vis_miles=" + vis_miles +
                ", uv=" + uv +
                ", precip_mm=" + precip_mm +
                ", precip_in=" + precip_in +
                ", gust_mph=" + gust_mph +
                ", gust_kph=" + gust_kph +
                ", is_day=" + is_day +
                ", last_updated_epoch=" + last_updated_epoch +
                ", wind_degree=" + wind_degree +
                ", humidity=" + humidity +
                ", cloud=" + cloud +
                ", wind_dir='" + wind_dir + '\'' +
                ", last_updated='" + last_updated + '\'' +
                ", condition=" + condition +
                ", air_quality=" + air_quality +
                '}';
    }
}