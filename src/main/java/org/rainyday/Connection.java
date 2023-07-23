package org.rainyday;

/*
* This class manages all the API calls to the Weather API
* Created by: Ridvik Pal
* */

/* IMPORT LIBRARIES */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

/* MAIN CLASS DECLARATION */
public class Connection {
    // The API key for weather api
    private static final String API_KEY = "53e3613c3ddf44c5ba2232504231107";

    private final HttpClient client = HttpClient.newHttpClient();

    public Weather getCurrentWeather(String _q) {
        // the url to get the information from
        String url = "https://api.weatherapi.com/v1/current.json?key=" + API_KEY
                + "&q=" + _q + "&aqi=yes";

        // create a GET http request
        HttpRequest currentWeatherRequest = HttpRequest.newBuilder().uri(URI.create(url)).build();

        // create the result of our http request
        Weather result;

        try {
            // send the request to the server using the client
            HttpResponse<String> currentWeatherResponse = client.send(currentWeatherRequest,
                    HttpResponse.BodyHandlers.ofString());

            // capture the result from GSON
            Gson gsonObject = new GsonBuilder().setPrettyPrinting().create();
            result = gsonObject.fromJson(currentWeatherResponse.body(), Weather.class);

//            System.out.println(gsonObject.toJson(result));
        }catch (Exception e){
            e.printStackTrace();

            result = null;
        }

        return result;
    }

    public Weather getAstronomy(String _q, String _dt){
        String url = "https://api.weatherapi.com/v1/astronomy.json?key=" + API_KEY
                + "&q=" + _q + "&dt=" + _dt;

        HttpRequest astronomyRequest = HttpRequest.newBuilder().uri(URI.create(url)).build();

        Weather result;

        try {
            HttpResponse<String> astronomyResponse = client.send(astronomyRequest,
                    HttpResponse.BodyHandlers.ofString());

            Gson gsonObject = new GsonBuilder().setPrettyPrinting().create();
            result = gsonObject.fromJson(astronomyResponse.body(), Weather.class);

//            System.out.println(gsonObject.toJson(result));
        }catch (Exception e){
            e.printStackTrace();
            result = null;
        }

        return result;
    }

    public Weather getForecast(String _q, int _days){
        String url = "https://api.weatherapi.com/v1/forecast.json?key=" + API_KEY
                + "&q=" + _q + "&days=" + _days + "&aqi=yes" + "&alerts=yes";

        HttpRequest forecastRequest = HttpRequest.newBuilder().uri(URI.create(url)).build();

        Weather result;

        try {
            HttpResponse<String> forecastResponse = client.send(forecastRequest,
                    HttpResponse.BodyHandlers.ofString());

            Gson gsonObject = new GsonBuilder().setPrettyPrinting().create();
            result = gsonObject.fromJson(forecastResponse.body(), Weather.class);

//            System.out.println(gsonObject.toJson(result));
        }catch (Exception e){
            e.printStackTrace();
            result = null;
        }
        return result;
    }

    public ArrayList<AutoCompleteElement> getAutocompleteTerm(String _query){
        String url = "https://api.weatherapi.com/v1/search.json?key=" + API_KEY
                + "&q=" + _query;

        HttpRequest autocompleteRequest = HttpRequest.newBuilder().uri(URI.create(url)).build();

        ArrayList<AutoCompleteElement> result;

        try {
            HttpResponse<String> autocompleteResponse = client.send(autocompleteRequest,
                    HttpResponse.BodyHandlers.ofString());

            Type autocompleteType = new TypeToken<ArrayList<AutoCompleteElement>>(){}.getType();
            Gson gsonObject = new GsonBuilder().setPrettyPrinting().create();
            result = gsonObject.fromJson(autocompleteResponse.body(), autocompleteType);

//            System.out.println(gsonObject.toJson(result));
        }catch (Exception e){
            e.printStackTrace();
            result = null;
        }


        return result;
    }
}