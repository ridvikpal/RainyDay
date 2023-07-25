package com.rainyday.rainyday;

import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import org.rainyday.Connection;
import org.rainyday.Weather;

import java.net.URISyntaxException;
import java.util.Objects;

public class Controller {

    // create the universal connector object for connection to WeatherAPI
    Connection connection = new Connection();

    @FXML
    private Tab tempTab;

    @FXML
    private AnchorPane rightPaneAnchorPane;

    @FXML
    private Tab windTab;

    @FXML
    private Button searchButton;

    @FXML
    private Button refreshButton;

    @FXML
    private TabPane graphTabPane;

    @FXML
    private Text feelsLikeText;

    @FXML
    private AreaChart<?, ?> tempGraph;

    @FXML
    private AreaChart<?, ?> precipGraph;

    @FXML
    private Button loadButton;

    @FXML
    private Text precipitationLabel;

    @FXML
    private Text airQualityText;

    @FXML
    private TableView<?> favouritesTable;

    @FXML
    private VBox mainInfoVBox;

    @FXML
    private Text windLabel;

    @FXML
    private Text locationText;

    @FXML
    private Text lastUpdatedTimeText;

    @FXML
    private HBox favouritesHBox;

    @FXML
    private Text visibilityLabel;

    @FXML
    private Text uvLabel;

    @FXML
    private Text uvText;

    @FXML
    private AnchorPane precipTabAnchorPane;

    @FXML
    private AnchorPane windGraphAnchorPane;

    @FXML
    private Text pressureLabel;

    @FXML
    private Text conditionText;

    @FXML
    private Text humidityLabel;

    @FXML
    private Button addButton;

    @FXML
    private AnchorPane tempTabAnchorPane;

    @FXML
    private Text windText;

    @FXML
    private Text visibilityText;

    @FXML
    private Text humidityText;

    @FXML
    private TextField citySearchBar;

    @FXML
    private GridPane additionalInfoGridPane;

    @FXML
    private AnchorPane leftPaneAnchorPane;

    @FXML
    private Text pressureText;

    @FXML
    private Button removeButton;

    @FXML
    private Tab precipTab;

    @FXML
    private Text airQualityLabel;

    @FXML
    private ImageView weatherBackground;

    @FXML
    private Text precipitationText;

    @FXML
    private Text currentTempText;

    @FXML
    private SplitPane splitPaneScene;

    @FXML
    private AreaChart<?, ?> windGraph;

    @FXML
    private Button alertButton;

    @FXML
    private TableColumn<?, ?> favouritesColumn;

    // This method searches WeatherAPI for city information and creates autocomplete
    @FXML
    void handleSearchRequest(){
        String city = citySearchBar.getText();
        // get the current weather
        Weather weather = connection.getForecast(city, 3);

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
        locationText.setTextAlignment(TextAlignment.LEFT);
        locationText.setText(
                weather.getLocation().getName() + ", "
                + weather.getLocation().getRegion() + ", "
                + weather.getLocation().getCountry()
        );
        lastUpdatedTimeText.setText(weather.getCurrent().getLast_updated());

        // set the air quality
        int epaIndex = weather.getCurrent().getAir_quality().getUs_epa_index();
        if (epaIndex == 1) airQualityText.setText("Good");
        else if (epaIndex == 2) airQualityText.setText("Moderate");
        else if (epaIndex == 3) airQualityText.setText("Allergen Warning");
        else if (epaIndex == 4) airQualityText.setText("Unhealthy");
        else if (epaIndex == 5) airQualityText.setText("Very Unhealthy");
        else airQualityText.setText("Hazardous");

        // set the correct alert
        setAlert(weather);

        // set the correct color theme and color theme
        if (weather.getCurrent().getIs_day() == 1){
//            setDayImage(weather.getCurrent().getCondition().getCode());
            setLightTheme();
        }else{
//            setNightImage(weather.getCurrent().getCondition().getCode());
            setDarkTheme();
        }

        // set the charts
        graphTabPane.setVisible(true);
    }

    void setTemperatureChart(Weather _weather){

    }

    void setPrecipitationChart(Weather _weather){

    }

    void setWindChart(Weather _weather){

    }

    void setAlert(Weather _weather){

    }

    void setLightTheme(){
        // set the right text colours
        lastUpdatedTimeText.setFill(Color.BLACK);
        currentTempText.setFill(Color.BLACK);
        feelsLikeText.setFill(Color.BLACK);
        conditionText.setFill(Color.BLACK);
        precipitationLabel.setFill(Color.BLACK);
        precipitationText.setFill(Color.BLACK);
        windLabel.setFill(Color.BLACK);
        windText.setFill(Color.BLACK);
        humidityLabel.setFill(Color.BLACK);
        humidityText.setFill(Color.BLACK);
        airQualityLabel.setFill(Color.BLACK);
        airQualityText.setFill(Color.BLACK);
        precipitationLabel.setFill(Color.BLACK);
        precipitationText.setFill(Color.BLACK);
        uvLabel.setFill(Color.BLACK);
        uvText.setFill(Color.BLACK);
        pressureLabel.setFill(Color.BLACK);
        pressureText.setFill(Color.BLACK);
        visibilityLabel.setFill(Color.BLACK);
        visibilityText.setFill(Color.BLACK);
        locationText.setFill(Color.BLACK);
        lastUpdatedTimeText.setFill(Color.BLACK);

        try {
            splitPaneScene.getStylesheets().setAll(Objects.requireNonNull(getClass()
                    .getResource("styles/hail_day_theme.css"))
                    .toURI().toString());
        } catch (Exception e) {
            System.out.println("Error setting light theme");
        }
    }

    void setDarkTheme(){
        // set the right text colours
        lastUpdatedTimeText.setFill(Color.WHITE);
        currentTempText.setFill(Color.WHITE);
        feelsLikeText.setFill(Color.WHITE);
        conditionText.setFill(Color.WHITE);
        precipitationLabel.setFill(Color.WHITE);
        precipitationText.setFill(Color.WHITE);
        windLabel.setFill(Color.WHITE);
        windText.setFill(Color.WHITE);
        humidityLabel.setFill(Color.WHITE);
        humidityText.setFill(Color.WHITE);
        airQualityLabel.setFill(Color.WHITE);
        airQualityText.setFill(Color.WHITE);
        precipitationLabel.setFill(Color.WHITE);
        precipitationText.setFill(Color.WHITE);
        uvLabel.setFill(Color.WHITE);
        uvText.setFill(Color.WHITE);
        pressureLabel.setFill(Color.WHITE);
        pressureText.setFill(Color.WHITE);
        visibilityLabel.setFill(Color.WHITE);
        visibilityText.setFill(Color.WHITE);
        locationText.setFill(Color.WHITE);
        lastUpdatedTimeText.setFill(Color.WHITE);


        try {
            splitPaneScene.getStylesheets().setAll(getClass()
                    .getResource("styles/hail_night_theme.css")
                    .toURI().toString());
        } catch (Exception e) {
            System.out.println("Error setting dark theme");
        }
    }

    // This method adds the current city to the favourites table
    @FXML
    void handleAddFavourites(){

    }

    // This method removes a selected city from the favourites table
    @FXML
    void handleRemoveFavourites(){

    }

    // This method loads a selected favourite to the favourites table.
    @FXML
    void handleLoadFavourites(){

    }

}