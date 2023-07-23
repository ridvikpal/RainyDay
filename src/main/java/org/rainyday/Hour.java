package org.rainyday;

public class Hour {
    private int time_epoch, is_day, wind_degree, humidity, cloud, will_it_rain, chance_of_rain
            , will_it_snow, chance_of_snow;
    private String time, wind_dir;
    private double temp_c, temp_f, wind_mph, wind_kph, pressure_mb, pressure_in, precip_mm, precip_in
            , feelslike_c, feelslike_f, windchill_c, windchill_f, heatindex_c, heatindex_f, dewpoint_c
            , dewpoint_f, vis_km, vis_miles, gust_mph, gust_kph, uv;
    private Condition condition;
    private AirQuality air_quality;

    public int getTime_epoch() {
        return time_epoch;
    }

    public int getIs_day() {
        return is_day;
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

    public int getWill_it_rain() {
        return will_it_rain;
    }

    public int getChance_of_rain() {
        return chance_of_rain;
    }

    public int getWill_it_snow() {
        return will_it_snow;
    }

    public int getChance_of_snow() {
        return chance_of_snow;
    }

    public String getTime() {
        return time;
    }

    public String getWind_dir() {
        return wind_dir;
    }

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

    public double getPrecip_mm() {
        return precip_mm;
    }

    public double getPrecip_in() {
        return precip_in;
    }

    public double getFeelslike_c() {
        return feelslike_c;
    }

    public double getFeelslike_f() {
        return feelslike_f;
    }

    public double getWindchill_c() {
        return windchill_c;
    }

    public double getWindchill_f() {
        return windchill_f;
    }

    public double getHeatindex_c() {
        return heatindex_c;
    }

    public double getHeatindex_f() {
        return heatindex_f;
    }

    public double getDewpoint_c() {
        return dewpoint_c;
    }

    public double getDewpoint_f() {
        return dewpoint_f;
    }

    public double getVis_km() {
        return vis_km;
    }

    public double getVis_miles() {
        return vis_miles;
    }

    public double getGust_mph() {
        return gust_mph;
    }

    public double getGust_kph() {
        return gust_kph;
    }

    public double getUv() {
        return uv;
    }

    public Condition getCondition() {
        return condition;
    }

    public AirQuality getAir_quality() {
        return air_quality;
    }

    @Override
    public String toString() {
        return "Hour{" +
                "time_epoch=" + time_epoch +
                ", is_day=" + is_day +
                ", wind_degree=" + wind_degree +
                ", humidity=" + humidity +
                ", cloud=" + cloud +
                ", will_it_rain=" + will_it_rain +
                ", chance_of_rain=" + chance_of_rain +
                ", will_it_snow=" + will_it_snow +
                ", chance_of_snow=" + chance_of_snow +
                ", time='" + time + '\'' +
                ", wind_dir='" + wind_dir + '\'' +
                ", temp_c=" + temp_c +
                ", temp_f=" + temp_f +
                ", wind_mph=" + wind_mph +
                ", wind_kph=" + wind_kph +
                ", pressure_mb=" + pressure_mb +
                ", pressure_in=" + pressure_in +
                ", precip_mm=" + precip_mm +
                ", precip_in=" + precip_in +
                ", feelslike_c=" + feelslike_c +
                ", feelslike_f=" + feelslike_f +
                ", windchill_c=" + windchill_c +
                ", windchill_f=" + windchill_f +
                ", heatindex_c=" + heatindex_c +
                ", heatindex_f=" + heatindex_f +
                ", dewpoint_c=" + dewpoint_c +
                ", dewpoint_f=" + dewpoint_f +
                ", vis_km=" + vis_km +
                ", vis_miles=" + vis_miles +
                ", gust_mph=" + gust_mph +
                ", gust_kph=" + gust_kph +
                ", uv=" + uv +
                ", condition=" + condition +
                ", air_quality=" + air_quality +
                '}';
    }
}
