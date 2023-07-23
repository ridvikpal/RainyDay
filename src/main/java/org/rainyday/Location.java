package org.rainyday;

public class Location{
    private String name, region, country, tz_id, localtime;

    private double lat, lon;

    private int localtime_epoch;

    // GETTERS
    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    public String getTz_id() {
        return tz_id;
    }

    public String getLocaltime() {
        return localtime;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public int getLocaltime_epoch() {
        return localtime_epoch;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", tz_id='" + tz_id + '\'' +
                ", localtime='" + localtime + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                ", localtime_epoch=" + localtime_epoch +
                '}';
    }
}