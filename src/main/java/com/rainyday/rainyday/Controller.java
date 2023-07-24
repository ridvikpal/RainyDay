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
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import org.rainyday.Alert;
import org.rainyday.Connection;
import org.rainyday.Weather;

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
        // get the current weather
        Weather weather = connection.getCurrentWeather(city);

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
        windText.setText(String.valueOf(weather.getCurrent().getWind_kph()) + " km/h "
                + String.valueOf(weather.getCurrent().getWind_dir()));
        humidityText.setText(String.valueOf(weather.getCurrent().getHumidity() + " %"));
        uvText.setText(String.valueOf(weather.getCurrent().getUv()));
        pressureText.setText(String.valueOf(weather.getCurrent().getPressure_mb()) + " mb");
        visibilityText.setText(String.valueOf(weather.getCurrent().getVis_km()) + " km");
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
        else if (epaIndex == 3) airQualityText.setText("Allergic");
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

        // set the correct image
        setImage(weather);
    }

    // helper function to set the image
    void setImage(Weather _weather){
        try{
            // check it is daytime
            if (_weather.getCurrent().getIs_day() == 1){
                switch (_weather.getCurrent().getCondition().getCode()){
                    case 1000:
                        weatherBackground.setImage(new Image(getClass()
                                .getResource("backgrounds/sunny_day_scaled.jpg")
                                .toURI().toString()));
                        break;
                    case 1003:
                        weatherBackground.setImage(new Image(getClass()
                                .getResource("backgrounds/partly_cloudy_day_scaled.jpg")
                                .toURI().toString()));
                        break;
                    case 1006:
                        weatherBackground.setImage(new Image(getClass()
                                .getResource("backgrounds/cloudy_day_scaled.jpg")
                                .toURI().toString()));
                        break;
                    case 1009:
                        weatherBackground.setImage(new Image(getClass()
                                .getResource("backgrounds/overcast_day_scaled.jpg")
                                .toURI().toString()));
                        break;
                    case 1030: case 1135: case 1147:
                        weatherBackground.setImage(new Image(getClass()
                                .getResource("backgrounds/misty_day_scaled.jpg")
                                .toURI().toString()));
                        break;
                    case 1063: case 1150: case 1153: case 1180: case 1183: case 1186: case 1189: case 1240: case 1243:
                        weatherBackground.setImage(new Image(getClass()
                                .getResource("backgrounds/light_rain_day_scaled.jpg")
                                .toURI().toString()));
                        break;
                    case 1066: case 1210: case 1213: case 1216: case 1219: case 1255:
                        weatherBackground.setImage(new Image(getClass()
                                .getResource("backgrounds/light_snow_day_scaled.jpeg")
                                .toURI().toString()));
                        break;
                    case 1069: case 1204: case 1207: case 1249: case 1252:
                        weatherBackground.setImage(new Image(getClass()
                                .getResource("backgrounds/sleet_day_scaled.jpg")
                                .toURI().toString()));
                        break;
                    case 1072: case 1168: case 1171: case 1198: case 1201:
                        weatherBackground.setImage(new Image(getClass()
                                .getResource("backgrounds/freezing_rain_scaled.jpg")
                                .toURI().toString()));
                        break;
                    case 1087: case 1273: case 1276:
                        weatherBackground.setImage(new Image(getClass()
                                .getResource("backgrounds/lightning_thunder_scaled.jpeg")
                                .toURI().toString()));
                        break;
                    case 1114: case 1117: case 1222: case 1225: case 1258:
                        weatherBackground.setImage(new Image(getClass()
                                .getResource("backgrounds/heavy_snow_day_scaled.jpg")
                                .toURI().toString()));
                        break;
                    case 1192: case 1195: case 1246:
                        weatherBackground.setImage(new Image(getClass()
                                .getResource("backgrounds/heavy_rain_day_scaled.jpg")
                                .toURI().toString()));
                        break;
                    case 1237: case 1261: case 1264:
                        weatherBackground.setImage(new Image(getClass()
                                .getResource("backgrounds/hail_scaled.jpg")
                                .toURI().toString()));
                        break;
                    case 1279: case 1282:
                        weatherBackground.setImage(new Image(getClass()
                                .getResource("backgrounds/thunderstorm_snow_scaled.jpg")
                                .toURI().toString()));
                        break;
                    default:
                        weatherBackground.setImage(null);
                        break;
                }
            }else{ // else it is nighttime
                switch (_weather.getCurrent().getCondition().getCode()){
                    case 1000:
                        weatherBackground.setImage(new Image(getClass()
                                .getResource("backgrounds/clear_night_scaled.jpg")
                                .toURI().toString()));
                        break;
                    case 1003:
                        weatherBackground.setImage(new Image(getClass()
                                .getResource("backgrounds/partly_cloudy_night_scaled.jpg")
                                .toURI().toString()));
                        break;
                    case 1006:
                        weatherBackground.setImage(new Image(getClass()
                                .getResource("backgrounds/cloudy_night_scaled.jpg")
                                .toURI().toString()));
                        break;
                    case 1009:
                        weatherBackground.setImage(new Image(getClass()
                                .getResource("backgrounds/overcast_night_scaled.jpg")
                                .toURI().toString()));
                        break;
                    case 1030: case 1135: case 1147:
                        weatherBackground.setImage(new Image(getClass()
                                .getResource("backgrounds/misty_night_scaled.jpg")
                                .toURI().toString()));
                        break;
                    case 1063: case 1150: case 1153: case 1180: case 1183: case 1186: case 1189: case 1240: case 1243:
                        weatherBackground.setImage(new Image(getClass()
                                .getResource("backgrounds/light_rain_night_scaled.jpg")
                                .toURI().toString()));
                        break;
                    case 1066: case 1210: case 1213: case 1216: case 1219: case 1255:
                        weatherBackground.setImage(new Image(getClass()
                                .getResource("backgrounds/light_snow_night_scaled.jpg")
                                .toURI().toString()));
                        break;
                    case 1069: case 1204: case 1207: case 1249: case 1252:
                        weatherBackground.setImage(new Image(getClass()
                                .getResource("backgrounds/sleet_night_scaled.jpg")
                                .toURI().toString()));
                        break;
                    case 1072: case 1168: case 1171: case 1198: case 1201:
                        weatherBackground.setImage(new Image(getClass()
                                .getResource("backgrounds/freezing_rain_scaled.jpg")
                                .toURI().toString()));
                        break;
                    case 1087: case 1273: case 1276:
                        weatherBackground.setImage(new Image(getClass()
                                .getResource("backgrounds/lightning_thunder_scaled.jpeg")
                                .toURI().toString()));
                        break;
                    case 1114: case 1117: case 1222: case 1225: case 1258:
                        weatherBackground.setImage(new Image(getClass()
                                .getResource("backgrounds/heavy_snow_night_scaled.jpg")
                                .toURI().toString()));
                        break;
                    case 1192: case 1195: case 1246:
                        weatherBackground.setImage(new Image(getClass()
                                .getResource("backgrounds/heavy_rain_night_scaled.jpg")
                                .toURI().toString()));
                        break;
                    case 1237: case 1261: case 1264:
                        weatherBackground.setImage(new Image(getClass()
                                .getResource("backgrounds/hail_scaled.jpg")
                                .toURI().toString()));
                        break;
                    case 1279: case 1282:
                        weatherBackground.setImage(new Image(getClass()
                                .getResource("backgrounds/thunderstorm_snow_scaled.jpg")
                                .toURI().toString()));
                        break;
                    default:
                        weatherBackground.setImage(null);
                        break;
                }
            }
        }catch (Exception e){

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