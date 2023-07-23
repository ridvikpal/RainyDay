package org.rainyday;

public class Day {
    private double maxtemp_c, maxtemp_f, mintemp_c, mintemp_f, avgtemp_c, avgtemp_f, maxwind_mph
            , maxwind_kph, totalprecip_mm, totalprecip_in, totalsnow_cm, avgvis_km, avgvis_miles
            , avghumidity, uv;
    private Condition condition;
    private AirQuality air_quality;

    public double getMaxtemp_c() {
        return maxtemp_c;
    }

    public double getMaxtemp_f() {
        return maxtemp_f;
    }

    public double getMintemp_c() {
        return mintemp_c;
    }

    public double getMintemp_f() {
        return mintemp_f;
    }

    public double getAvgtemp_c() {
        return avgtemp_c;
    }

    public double getAvgtemp_f() {
        return avgtemp_f;
    }

    public double getMaxwind_mph() {
        return maxwind_mph;
    }

    public double getMaxwind_kph() {
        return maxwind_kph;
    }

    public double getTotalprecip_mm() {
        return totalprecip_mm;
    }

    public double getTotalprecip_in() {
        return totalprecip_in;
    }

    public double getTotalsnow_cm() {
        return totalsnow_cm;
    }

    public double getAvgvis_km() {
        return avgvis_km;
    }

    public double getAvgvis_miles() {
        return avgvis_miles;
    }

    public double getAvghumidity() {
        return avghumidity;
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
        return "Day{" +
                "maxtemp_c=" + maxtemp_c +
                ", maxtemp_f=" + maxtemp_f +
                ", mintemp_c=" + mintemp_c +
                ", mintemp_f=" + mintemp_f +
                ", avgtemp_c=" + avgtemp_c +
                ", avgtemp_f=" + avgtemp_f +
                ", maxwind_mph=" + maxwind_mph +
                ", maxwind_kph=" + maxwind_kph +
                ", totalprecip_mm=" + totalprecip_mm +
                ", totalprecip_in=" + totalprecip_in +
                ", totalsnow_cm=" + totalsnow_cm +
                ", avgvis_km=" + avgvis_km +
                ", avgvis_miles=" + avgvis_miles +
                ", avghumidity=" + avghumidity +
                ", uv=" + uv +
                ", condition=" + condition +
                ", air_quality=" + air_quality +
                '}';
    }
}
