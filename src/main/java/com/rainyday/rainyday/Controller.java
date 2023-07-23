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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.rainyday.AirQuality;
import org.rainyday.Alert;
import org.rainyday.Connection;
import org.rainyday.Weather;

import java.beans.Visibility;
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
    private Text alertText;

    @FXML
    private TableColumn<?, ?> favouritesColumn;

    // This method searches WeatherAPI for city information and creates autocomplete
    @FXML
    void handleSearchRequest(){
        String city = citySearchBar.getText();

        // load the actual weather data
        loadWeatherData(city);
    }

    // This method loads the weather data to all the text fields in the ui
    void loadWeatherData(String _city){
        // get the current weather
        Weather weather = connection.getCurrentWeather(_city);

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
        currentTempText.setText(String.valueOf(weather.getCurrent().getTemp_c()) + " °C");
        feelsLikeText.setText("Feels like " + String.valueOf(weather.getCurrent().getFeelslike_c()) + " °C");
        conditionText.setText(weather.getCurrent().getCondition().getText());
        precipitationText.setText(String.valueOf(weather.getCurrent().getPrecip_mm()) + " mm");
        windText.setText(String.valueOf(weather.getCurrent().getWind_kph()) + " "
                + String.valueOf(weather.getCurrent().getWind_dir()));
        humidityText.setText(String.valueOf(weather.getCurrent().getHumidity() + " %"));
        uvText.setText(String.valueOf(weather.getCurrent().getUv()));
        pressureText.setText(String.valueOf(weather.getCurrent().getPressure_mb()) + " mb");
        visibilityText.setText(String.valueOf(weather.getCurrent().getVis_km()) + " km");
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
        else if (epaIndex == 3) airQualityText.setText("Unhealthy for sensitive groups");
        else if (epaIndex == 4) airQualityText.setText("Unhealthy");
        else if (epaIndex == 5) airQualityText.setText("Very Unhealthy");
        else airQualityText.setText("Hazardous");

        Alert alertObject = weather.getAlerts();

        // check if there are any weather alerts
        // only set the alert text if there is an alert
        if (!(Objects.isNull(alertObject))){
            alertText.setText("! " + alertObject.getAlert().get(0).getHeadline());
        }else{
            alertText.setText("");
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