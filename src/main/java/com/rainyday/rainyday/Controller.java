package com.rainyday.rainyday;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import org.rainyday.Connection;
import org.rainyday.ForecastDay;
import org.rainyday.Hour;
import org.rainyday.Weather;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Objects;

public class Controller {

    private static final Connection connection = new Connection();

    @FXML
    private Tab windTab;

    @FXML
    private AnchorPane rootAnchorPane;

    @FXML
    private Text locationText;

    @FXML
    private AnchorPane windTabAnchorPane;

    @FXML
    private Button loadButton;

    @FXML
    private Text precipitationLabel;

    @FXML
    private CategoryAxis tempGraphCategoryAxis;

    @FXML
    private Text programTitleText;

    @FXML
    private NumberAxis windGraphNumberAxis;

    @FXML
    private CategoryAxis precipGraphCategoryAxis;

    @FXML
    private Text uvLabel;

    @FXML
    private Text uvText;

    @FXML
    private Text pressureLabel;

    @FXML
    private Text conditionText;

    @FXML
    private Button addButton;

    @FXML
    private Text humidityLabel;

    @FXML
    private Text windText;

    @FXML
    private Text visibilityText;

    @FXML
    private Button alertButton;

    @FXML
    private Text humidityText;

    @FXML
    private GridPane additionalInfoGridPane;

    @FXML
    private NumberAxis tempGraphNumberAxis;

    @FXML
    private Text lastUpdatedTimeText;

    @FXML
    private ListView<String> favouritesList;

    @FXML
    private Tab precipTab;

    @FXML
    private Text currentTempText;

    @FXML
    private Tab tempTab;

    @FXML
    private Button searchButton;

    @FXML
    private TabPane graphTabPane;

    @FXML
    private Text feelsLikeText;

    @FXML
    private AreaChart<String, Double> tempGraph;

    @FXML
    private AreaChart<?, ?> precipGraph;

    @FXML
    private CategoryAxis windGraphCategoryAxis;

    @FXML
    private Text airQualityText;

    @FXML
    private VBox mainInfoVBox;

    @FXML
    private Text windLabel;

    @FXML
    private Button refreshButton;

    @FXML
    private HBox favouritesHBox;

    @FXML
    private NumberAxis precipGraphNumberAxis;

    @FXML
    private Text visibilityLabel;

    @FXML
    private AnchorPane precipTabAnchorPane;

    @FXML
    private Text greeterText;

    @FXML
    private AnchorPane tempTabAnchorPane;

    @FXML
    private TextField citySearchBar;

    @FXML
    private Text pressureText;

    @FXML
    private Button removeButton;

    @FXML
    private Text airQualityLabel;

    @FXML
    private Text precipitationText;

    @FXML
    private AreaChart<?, ?> windGraph;

    Label favouritesPlaceholder = new Label("No saved favourites.");
    HashSet<String> favourites = new HashSet<>();

    @FXML
    private void initialize(){
        importFavourites();

        // allow text to be formatted via css
        favouritesPlaceholder.getStyleClass().add("text");
        lastUpdatedTimeText.getStyleClass().add("text");
        currentTempText.getStyleClass().add("text");
        feelsLikeText.getStyleClass().add("text");
        conditionText.getStyleClass().add("text");
        precipitationLabel.getStyleClass().add("text");
        precipitationText.getStyleClass().add("text");
        windLabel.getStyleClass().add("text");
        windText.getStyleClass().add("text");
        humidityLabel.getStyleClass().add("text");
        humidityText.getStyleClass().add("text");
        airQualityLabel.getStyleClass().add("text");
        airQualityText.getStyleClass().add("text");
        precipitationLabel.getStyleClass().add("text");
        precipitationText.getStyleClass().add("text");
        uvLabel.getStyleClass().add("text");
        uvText.getStyleClass().add("text");
        pressureLabel.getStyleClass().add("text");
        pressureText.getStyleClass().add("text");
        visibilityLabel.getStyleClass().add("text");
        visibilityText.getStyleClass().add("text");
        locationText.getStyleClass().add("text");
        lastUpdatedTimeText.getStyleClass().add("text");
    }

    @FXML
    void handleSearchRequest() {
        String city = citySearchBar.getText();
        city = city.replace(" ", "-");
        updateData(city);
    }

    @FXML
    void handleAddFavourites() {
        favourites.add(locationText.getText());
        favouritesList.setItems(FXCollections.observableArrayList(favourites));
    }

    @FXML
    void handleLoadFavourites() {
        String selectedCity = favouritesList.getSelectionModel().getSelectedItem();
        selectedCity = selectedCity.replace(" ", "-");
        updateData(selectedCity);
        favouritesList.getSelectionModel().clearSelection();
    }

    @FXML
    void handleRemoveFavourites() {
        String selectedCity = favouritesList.getSelectionModel().getSelectedItem();
        favourites.remove(selectedCity);
        favouritesList.setItems(FXCollections.observableArrayList(favourites));
    }

    @FXML
    void handleRefreshRequest() {
        String city = locationText.getText();
        city = city.replace(" ", "-");
        updateData(city);
    }

    void updateData(String _city){
        // disable the greeting text
        programTitleText.setVisible(false);
        greeterText.setVisible(false);

        // get the current weather
        Weather weather = connection.getForecast(_city, 3);

        // view the labels
        precipitationLabel.setVisible(true);
        windLabel.setVisible(true);
        humidityLabel.setVisible(true);
        uvLabel.setVisible(true);
        pressureLabel.setVisible(true);
        visibilityLabel.setVisible(true);
        airQualityLabel.setVisible(true);
        refreshButton.setVisible(true);


        // set the current weather information text
        currentTempText.setText(weather.getCurrent().getTemp_c() + " °C");
        feelsLikeText.setText("Feels like " + weather.getCurrent().getFeelslike_c() + " °C");
        conditionText.setText(weather.getCurrent().getCondition().getText());
        precipitationText.setText(weather.getCurrent().getPrecip_mm() + " mm");
        windText.setText(weather.getCurrent().getWind_kph() + " km/h "
                + weather.getCurrent().getWind_dir());
        humidityText.setText(weather.getCurrent().getHumidity() + " %");
        uvText.setText(String.valueOf(weather.getCurrent().getUv()));
        pressureText.setText(weather.getCurrent().getPressure_mb() + " mb");
        visibilityText.setText(weather.getCurrent().getVis_km() + " km");
        locationText.setFill(Color.BLACK);
        locationText.setVisible(true);
        locationText.setTextAlignment(TextAlignment.LEFT);
        locationText.setText(
                weather.getLocation().getName() + ", "
                        + weather.getLocation().getRegion() + ", "
                        + weather.getLocation().getCountry()
        );
        lastUpdatedTimeText.setText("Updated at "  + formatDateTime(weather.getCurrent().getLast_updated()));

        // set the air quality
        int epaIndex = weather.getCurrent().getAir_quality().getUs_epa_index();
        if (epaIndex == 1) airQualityText.setText("Good");
        else if (epaIndex == 2) airQualityText.setText("Moderate");
        else if (epaIndex == 3) airQualityText.setText("Allergen Warning");
        else if (epaIndex == 4) airQualityText.setText("Unhealthy");
        else if (epaIndex == 5) airQualityText.setText("Very Unhealthy");
        else airQualityText.setText("Hazardous");

        // set the correct color theme based on the condition
        if (weather.getCurrent().getIs_day() == 1){
            setLightTheme(weather.getCurrent().getCondition().getCode());
        }else{
            setDarkTheme(weather.getCurrent().getCondition().getCode());
        }

        // set the charts
        graphTabPane.setVisible(true);
        setTempGraph(weather);
        setPrecipGraph(weather);
        setWindGraph(weather);

        // setup the favourites table buttons
        addButton.setVisible(true);
    }

    void setTempGraph(Weather _weather) {
        tempGraph.getData().removeAll(tempGraph.getData());

        XYChart.Series temperatureData1 = new XYChart.Series();
        XYChart.Series temperatureData2 = new XYChart.Series();
        XYChart.Series temperatureData3 = new XYChart.Series();

        temperatureData1.setName(_weather.getForecast().getForecastday().get(0).getDate());
        temperatureData2.setName(_weather.getForecast().getForecastday().get(1).getDate());
        temperatureData3.setName(_weather.getForecast().getForecastday().get(2).getDate());

        for (Hour x : _weather.getForecast().getForecastday().get(0).getHour()) {
            String time = x.getTime().substring(x.getTime().lastIndexOf(" ") + 1);
            temperatureData1.getData().add(new XYChart.Data<>(time, x.getTemp_c()));
        }
        for (Hour x : _weather.getForecast().getForecastday().get(1).getHour()) {
            String time = x.getTime().substring(x.getTime().lastIndexOf(" ") + 1);
            temperatureData2.getData().add(new XYChart.Data<>(time, x.getTemp_c()));
        }
        for (Hour x : _weather.getForecast().getForecastday().get(2).getHour()) {
            String time = x.getTime().substring(x.getTime().lastIndexOf(" ") + 1);
            temperatureData3.getData().add(new XYChart.Data<>(time, x.getTemp_c()));
        }

        tempGraph.getData().addAll(temperatureData1, temperatureData2, temperatureData3);
    }

    void setPrecipGraph(Weather _weather){
        precipGraph.getData().removeAll(precipGraph.getData());

        XYChart.Series precipitationData1 = new XYChart.Series();
        XYChart.Series precipitationData2 = new XYChart.Series();
        XYChart.Series precipitationData3 = new XYChart.Series();

        precipitationData1.setName(_weather.getForecast().getForecastday().get(0).getDate());
        precipitationData2.setName(_weather.getForecast().getForecastday().get(1).getDate());
        precipitationData3.setName(_weather.getForecast().getForecastday().get(2).getDate());

        for (Hour x : _weather.getForecast().getForecastday().get(0).getHour()) {
            String time = x.getTime().substring(x.getTime().lastIndexOf(" ") + 1);
            precipitationData1.getData().add(new XYChart.Data<>(time, x.getPrecip_mm()));
        }
        for (Hour x : _weather.getForecast().getForecastday().get(1).getHour()) {
            String time = x.getTime().substring(x.getTime().lastIndexOf(" ") + 1);
            precipitationData2.getData().add(new XYChart.Data<>(time, x.getPrecip_mm()));
        }
        for (Hour x : _weather.getForecast().getForecastday().get(2).getHour()) {
            String time = x.getTime().substring(x.getTime().lastIndexOf(" ") + 1);
            precipitationData3.getData().add(new XYChart.Data<>(time, x.getPrecip_mm()));
        }

        precipGraph.getData().addAll(precipitationData1, precipitationData2, precipitationData3);
    }

    void setWindGraph(Weather _weather){
        windGraph.getData().removeAll(windGraph.getData());

        XYChart.Series windData1 = new XYChart.Series();
        XYChart.Series windData2 = new XYChart.Series();
        XYChart.Series windData3 = new XYChart.Series();

        windData1.setName(_weather.getForecast().getForecastday().get(0).getDate());
        windData2.setName(_weather.getForecast().getForecastday().get(1).getDate());
        windData3.setName(_weather.getForecast().getForecastday().get(2).getDate());

        for (Hour x : _weather.getForecast().getForecastday().get(0).getHour()) {
            String time = x.getTime().substring(x.getTime().lastIndexOf(" ") + 1);
            windData1.getData().add(new XYChart.Data<>(time, x.getWind_kph()));
        }
        for (Hour x : _weather.getForecast().getForecastday().get(1).getHour()) {
            String time = x.getTime().substring(x.getTime().lastIndexOf(" ") + 1);
            windData2.getData().add(new XYChart.Data<>(time, x.getWind_kph()));
        }
        for (Hour x : _weather.getForecast().getForecastday().get(2).getHour()) {
            String time = x.getTime().substring(x.getTime().lastIndexOf(" ") + 1);
            windData3.getData().add(new XYChart.Data<>(time, x.getWind_kph()));
        }

        windGraph.getData().addAll(windData1, windData2, windData3);
    }

    String formatDateTime(String _dateTime){
        DateTimeFormatter inputDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        DateTimeFormatter outputDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd (h:mm a)");
        LocalDateTime dateTime = LocalDateTime.parse(_dateTime, inputDateTimeFormatter);
        String formattedString = dateTime.format(outputDateTimeFormatter);
        return formattedString.toUpperCase();
    }



    void importFavourites(){
        try (Reader reader = new FileReader("src/main/resources/com/rainyday/rainyday/favourites.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Type stringType = new TypeToken<HashSet<String>>(){}.getType();
            favourites = gson.fromJson(reader, stringType);
            favouritesList.setItems(FXCollections.observableArrayList(favourites));
        } catch (IOException e) {
            System.out.println("Error importing favourites from Json!");
        }
    }

    void exportFavourites(){
        try (Writer writer = new FileWriter("src/main/resources/com/rainyday/rainyday/favourites.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(favourites, writer);
        } catch (IOException e) {
            System.out.println("Error exporting favourites to Json!");
        }
    }

    void setLightTheme(int _weatherCode){
        try {
            switch (_weatherCode){
                // set sunny day theme
                case 1000, 1003 -> rootAnchorPane.getStylesheets().setAll(Objects.requireNonNull(getClass()
                                .getResource("styles/sunny_day_theme.css"))
                        .toURI().toString());
                // set cloudy day theme
                case 1006, 1009 -> rootAnchorPane.getStylesheets().setAll(Objects.requireNonNull(getClass()
                                .getResource("styles/cloudy_day_theme.css"))
                        .toURI().toString());
                // set foggy day theme
                case 1030, 1135, 1147 -> rootAnchorPane.getStylesheets().setAll(Objects.requireNonNull(getClass()
                                .getResource("styles/foggy_day_theme.css"))
                        .toURI().toString());
                // set rainy day theme
                case 1063, 1069, 1072, 1150, 1153, 1168, 1171, 1180, 1183, 1186, 1189, 1192, 1195, 1198, 1201, 1204,
                        1207, 1240, 1243, 1246, 1249, 1252 -> rootAnchorPane.getStylesheets()
                        .setAll(Objects.requireNonNull(getClass()
                                        .getResource("styles/rain_day_theme.css"))
                                .toURI().toString());
                // set snowy day theme
                case 1066, 1114, 1117, 1210, 1213, 1216, 1219, 1222, 1225, 1255, 1258 -> rootAnchorPane.getStylesheets()
                        .setAll(Objects.requireNonNull(getClass()
                                        .getResource("styles/snowy_day_theme.css"))
                                .toURI().toString());
                // set thunderstorm theme
                case 1087, 1273, 1276, 1279, 1282 -> rootAnchorPane.getStylesheets().setAll(Objects
                        .requireNonNull(getClass()
                                .getResource("styles/thunderstorm_day_theme.css"))
                        .toURI().toString());
                // set hail theme
                case 1237, 1261, 1264 -> rootAnchorPane.getStylesheets().setAll(Objects.requireNonNull(getClass()
                                .getResource("styles/hail_day_theme.css"))
                        .toURI().toString());
            }
        } catch (Exception e) {
            System.out.println("Error setting light theme");
        }
    }

    void setDarkTheme(int _weatherCode){
        try {
            switch (_weatherCode){
                // set clear night theme
                case 1000, 1003 -> rootAnchorPane.getStylesheets().setAll(Objects.requireNonNull(getClass()
                                .getResource("styles/clear_night_theme.css"))
                        .toURI().toString());
                // set cloudy night theme
                case 1006, 1009 -> rootAnchorPane.getStylesheets().setAll(Objects.requireNonNull(getClass()
                                .getResource("styles/cloudy_night_theme.css"))
                        .toURI().toString());
                // set foggy night theme
                case 1030, 1135, 1147 -> rootAnchorPane.getStylesheets().setAll(Objects.requireNonNull(getClass()
                                .getResource("styles/foggy_night_theme.css"))
                        .toURI().toString());
                // set rainy night theme
                case 1063, 1069, 1072, 1150, 1153, 1168, 1171, 1180, 1183, 1186, 1189, 1192, 1195, 1198, 1201, 1204,
                        1207, 1240, 1243, 1246, 1249, 1252 -> rootAnchorPane.getStylesheets()
                        .setAll(Objects.requireNonNull(getClass()
                                        .getResource("styles/rain_night_theme.css"))
                                .toURI().toString());
                // set snowy night theme
                case 1066, 1114, 1117, 1210, 1213, 1216, 1219, 1222, 1225, 1255, 1258 -> rootAnchorPane.getStylesheets()
                        .setAll(Objects.requireNonNull(getClass()
                                        .getResource("styles/snowy_night_theme.css"))
                                .toURI().toString());
                // set thunderstorm theme
                case 1087, 1273, 1276, 1279, 1282 -> rootAnchorPane.getStylesheets().setAll(Objects
                        .requireNonNull(getClass()
                                .getResource("styles/thunderstorm_night_theme.css"))
                        .toURI().toString());
                // set hail theme
                case 1237, 1261, 1264 -> rootAnchorPane.getStylesheets().setAll(Objects.requireNonNull(getClass()
                                .getResource("styles/hail_night_theme.css"))
                        .toURI().toString());
            }
        } catch (Exception e) {
            System.out.println("Error setting dark theme");
        }
    }
}