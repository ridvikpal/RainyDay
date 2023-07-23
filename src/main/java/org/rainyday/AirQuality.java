package org.rainyday;

import com.google.gson.annotations.SerializedName;

public class AirQuality{
    private double co, no2, o3, so2, pm2_5, pm10;
    @SerializedName("us-epa-index")
    private int us_epa_index;

    @SerializedName("gb-defra-index")
    private int gb_defra_index;

    // GETTERS
    public double getCo() {
        return co;
    }

    public double getNo2() {
        return no2;
    }

    public double getO3() {
        return o3;
    }

    public double getSo2() {
        return so2;
    }

    public double getPm2_5() {
        return pm2_5;
    }

    public double getPm10() {
        return pm10;
    }

    public int getUs_epa_index() {
        return us_epa_index;
    }

    public int getGb_defra_index() {
        return gb_defra_index;
    }

    @Override
    public String toString() {
        return "AirQuality{" +
                "co=" + co +
                ", no2=" + no2 +
                ", o3=" + o3 +
                ", so2=" + so2 +
                ", pm2_5=" + pm2_5 +
                ", pm10=" + pm10 +
                ", us_epa_index=" + us_epa_index +
                ", gb_defra_index=" + gb_defra_index +
                '}';
    }
}