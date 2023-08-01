package org.rainyday;

public class AutoCompleteElement {
    int id;
    String name, region, country, url;
    double lat, lon;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    public String getUrl() {
        return url;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    @Override
    public String toString() {
        return "AutoCompleteElement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", url='" + url + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
