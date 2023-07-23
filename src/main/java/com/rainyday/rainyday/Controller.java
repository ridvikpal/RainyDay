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
import org.rainyday.Connection;
import org.rainyday.Weather;

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
    private Text locationAndTimeText;

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

        // set the current text
        currentTempText.setText(String.valueOf(weather.getCurrent().getTemp_c()));
        feelsLikeText.setText("Feels like " + String.valueOf(weather.getCurrent().getFeelslike_c()));
        conditionText.setText(weather.getCurrent().getCondition().getText());

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