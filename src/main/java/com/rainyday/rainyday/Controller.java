package com.rainyday.rainyday;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.rainyday.AlertSubClass;
import org.rainyday.Connection;
import org.rainyday.Hour;
import org.rainyday.Weather;
import javafx.scene.control.Alert;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Objects;

public class Controller {

    private static final Connection connection = new Connection();
    private static Weather weather;

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
    private AreaChart<String, Double> precipGraph;

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
    private AreaChart<String, Double> windGraph;

    @FXML
    private RadioButton tempGraphDate1Selector;

    @FXML
    private RadioButton tempGraphDate2Selector;

    @FXML
    private RadioButton tempGraphDate3Selector;

    @FXML
    private ToggleGroup tempDateSelectorGroup;

    XYChart.Series temperatureData1 = new XYChart.Series();
    XYChart.Series temperatureData2 = new XYChart.Series();
    XYChart.Series temperatureData3 = new XYChart.Series();

    Label favouritesPlaceholder = new Label("No saved favourites.");
    HashSet<String> favourites = new HashSet<>();

    @FXML
    private RadioButton precipGraphDate1Selector;

    @FXML
    private RadioButton precipGraphDate2Selector;

    @FXML
    private RadioButton precipGraphDate3Selector;

    @FXML
    private ToggleGroup precipDateSelectorGroup;

    XYChart.Series precipitationData1 = new XYChart.Series();
    XYChart.Series precipitationData2 = new XYChart.Series();
    XYChart.Series precipitationData3 = new XYChart.Series();


    @FXML
    private RadioButton windGraphDate1Selector;

    @FXML
    private RadioButton windGraphDate2Selector;

    @FXML
    private RadioButton windGraphDate3Selector;

    @FXML
    private ToggleGroup windDateSelectorGroup;

    XYChart.Series windData1 = new XYChart.Series();
    XYChart.Series windData2 = new XYChart.Series();
    XYChart.Series windData3 = new XYChart.Series();

    // create a standard fade transition
    private FadeTransition fadeIn = new FadeTransition(Duration.millis(2000));

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

        // set the fade transition
        fadeIn.setNode(rootAnchorPane);
        fadeIn.setFromValue(0.25);
        fadeIn.setToValue(1.0);
        fadeIn.setCycleCount(1);
        fadeIn.setAutoReverse(true);
    }

    @FXML
    void handleSearchRequest() {
        String city = citySearchBar.getText();
        city = city.replace(" ", "-");
        city = city.replace(",", "-");
        city = city.replace("- ", "-");
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

    @FXML
    void chooseTempDate1(){
        tempGraph.getData().removeAll(tempGraph.getData());
        tempGraph.getData().add(temperatureData1);
    }

    @FXML
    void chooseTempDate2(){
        tempGraph.getData().removeAll(tempGraph.getData());
        tempGraph.getData().add(temperatureData2);
    }

    @FXML
    void chooseTempDate3(){
        tempGraph.getData().removeAll(tempGraph.getData());
        tempGraph.getData().add(temperatureData3);
    }

    @FXML
    void choosePrecipDate1(){
        precipGraph.getData().removeAll(precipGraph.getData());
        precipGraph.getData().add(precipitationData1);
    }

    @FXML
    void choosePrecipDate2(){
        precipGraph.getData().removeAll(precipGraph.getData());
        precipGraph.getData().add(precipitationData2);
    }

    @FXML
    void choosePrecipDate3(){
        precipGraph.getData().removeAll(precipGraph.getData());
        precipGraph.getData().add(precipitationData3);
    }

    @FXML
    void chooseWindDate1(){
        windGraph.getData().removeAll(windGraph.getData());
        windGraph.getData().add(windData1);
    }

    @FXML
    void chooseWindDate2(){
        windGraph.getData().removeAll(windGraph.getData());
        windGraph.getData().add(windData2);
    }

    @FXML
    void chooseWindDate3(){
        windGraph.getData().removeAll(windGraph.getData());
        windGraph.getData().add(windData3);
    }

    @FXML
    void handleAlert(){
        Alert weatherAlert = new Alert(Alert.AlertType.WARNING);
//        AlertSubClass newAlert = new AlertSubClass();
//        weather.getAlerts().getAlert().add(newAlert);
//        weather.getAlerts().getAlert().get(0).setHeadline("Flood Warning issued January 05 at 9:47PM EST until January 07 at 6:15AM EST by NWS");
//        weather.getAlerts().getAlert().get(0).setInstruction("A Flood Warning means that flooding is imminent or occurring. All\ninterested parties should take necessary precautions immediately.\nMotorists should not attempt to drive around barricades or drive\ncars through flooded areas.\nCaution is urged when walking near riverbanks.\nAdditional information is available at www.weather.gov.\nThe next statement will be issued Wednesday morning at 1000 AM EST.");
        weatherAlert.setHeaderText(weather.getAlerts().getAlert().get(0).getHeadline());
        weatherAlert.setContentText(weather.getAlerts().getAlert().get(0).getInstruction());
        weatherAlert.getDialogPane().getStyleClass().add("warning-dialog");
        Stage stage = (Stage) weatherAlert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(getClass().getResourceAsStream("RainyDay_Icon.png")));
        weatherAlert.showAndWait();
    }

    void updateData(String _city){
        try {
            // get the current weather
            weather = connection.getForecast(_city, 3);

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
            locationText.setText(
                    weather.getLocation().getName() + ", "
                            + weather.getLocation().getRegion() + ", "
                            + weather.getLocation().getCountry()
            );
            lastUpdatedTimeText.setText("Updated at "  + weather.getCurrent().getLast_updated());

            // set the air quality
            int epaIndex = weather.getCurrent().getAir_quality().getUs_epa_index();
            if (epaIndex == 1) airQualityText.setText("Good");
            else if (epaIndex == 2) airQualityText.setText("Moderate");
            else if (epaIndex == 3) airQualityText.setText("Allergen Warning");
            else if (epaIndex == 4) airQualityText.setText("Unhealthy");
            else if (epaIndex == 5) airQualityText.setText("Very Unhealthy");
            else airQualityText.setText("Hazardous");

            // disable the greeting text
            programTitleText.setVisible(false);
            greeterText.setVisible(false);

            // view the labels
            precipitationLabel.setVisible(true);
            windLabel.setVisible(true);
            humidityLabel.setVisible(true);
            uvLabel.setVisible(true);
            pressureLabel.setVisible(true);
            visibilityLabel.setVisible(true);
            airQualityLabel.setVisible(true);
            refreshButton.setVisible(true);

            // set the charts
            graphTabPane.setVisible(true);

            setTempGraph();
            tempGraphDate1Selector.setSelected(true);
            chooseTempDate1();

            setPrecipGraph();
            precipGraphDate1Selector.setSelected(true);
            choosePrecipDate1();

            setWindGraph();
            windGraphDate1Selector.setSelected(true);
            chooseWindDate1();

            // setup the favourites table buttons
            addButton.setVisible(true);

            // set the correct color theme based on the condition
            if (weather.getCurrent().getIs_day() == 1){
                setLightTheme(weather.getCurrent().getCondition().getCode());
            }else{
                setDarkTheme(weather.getCurrent().getCondition().getCode());
            }

            // setup the alerts button
            if (weather.getAlerts().getAlert().isEmpty()){
                alertButton.setVisible(false);
            }else{
                alertButton.setVisible(true);
            }

            fadeIn.playFromStart();
        }catch (NullPointerException e){
            Alert unknownCityAlert = new Alert(Alert.AlertType.ERROR);
            unknownCityAlert.setHeaderText("Error Occurred Utilizing WeatherAPI");
            unknownCityAlert.setContentText("Unknown city name was entered.");
            unknownCityAlert.getDialogPane().getStyleClass().add("error-dialog");
            Stage stage = (Stage) unknownCityAlert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(getClass().getResourceAsStream("RainyDay_Icon.png")));
            unknownCityAlert.showAndWait();
        } catch (Exception e) {
            Alert apiConnectionError = new Alert(Alert.AlertType.ERROR);
            apiConnectionError.setHeaderText("Error Occurred Connecting to WeatherAPI");
            apiConnectionError.setContentText("Connection timeout occurred");
            apiConnectionError.getDialogPane().getStyleClass().add("error-dialog");
            Stage stage = (Stage) apiConnectionError.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(getClass().getResourceAsStream("RainyDay_Icon.png")));
            apiConnectionError.showAndWait();
        }
    }

    void setTempGraph() {
        temperatureData1.getData().removeAll(temperatureData1.getData());
        temperatureData2.getData().removeAll(temperatureData2.getData());
        temperatureData3.getData().removeAll(temperatureData3.getData());

        tempGraphDate1Selector.setText(weather.getForecast().getForecastday().get(0).getDate());
        tempGraphDate2Selector.setText(weather.getForecast().getForecastday().get(1).getDate());
        tempGraphDate3Selector.setText(weather.getForecast().getForecastday().get(2).getDate());

        // add new data
        for (Hour x : weather.getForecast().getForecastday().get(0).getHour()) {
            String time = x.getTime().substring(x.getTime().lastIndexOf(" ") + 1);
            temperatureData1.getData().add(new XYChart.Data<>(time, x.getTemp_c()));
        }
        for (Hour x : weather.getForecast().getForecastday().get(1).getHour()) {
            String time = x.getTime().substring(x.getTime().lastIndexOf(" ") + 1);
            temperatureData2.getData().add(new XYChart.Data<>(time, x.getTemp_c()));
        }
        for (Hour x : weather.getForecast().getForecastday().get(2).getHour()) {
            String time = x.getTime().substring(x.getTime().lastIndexOf(" ") + 1);
            temperatureData3.getData().add(new XYChart.Data<>(time, x.getTemp_c()));
        }
//        tempGraph.getData().addAll(temperatureData1, temperatureData2, temperatureData3);

        // formatting
        tempGraph.setLegendVisible(false);
        tempGraphCategoryAxis.setLabel("Hour");
        tempGraphNumberAxis.setLabel("Degrees Celsius");
    }

    void setPrecipGraph(){
        precipitationData1.getData().removeAll(precipitationData1.getData());
        precipitationData2.getData().removeAll(precipitationData2.getData());
        precipitationData3.getData().removeAll(precipitationData3.getData());

        precipGraphDate1Selector.setText(weather.getForecast().getForecastday().get(0).getDate());
        precipGraphDate2Selector.setText(weather.getForecast().getForecastday().get(1).getDate());
        precipGraphDate3Selector.setText(weather.getForecast().getForecastday().get(2).getDate());

        // add new data
        for (Hour x : weather.getForecast().getForecastday().get(0).getHour()) {
            String time = x.getTime().substring(x.getTime().lastIndexOf(" ") + 1);
            precipitationData1.getData().add(new XYChart.Data<>(time, x.getPrecip_mm()));
        }
        for (Hour x : weather.getForecast().getForecastday().get(1).getHour()) {
            String time = x.getTime().substring(x.getTime().lastIndexOf(" ") + 1);
            precipitationData2.getData().add(new XYChart.Data<>(time, x.getPrecip_mm()));
        }
        for (Hour x : weather.getForecast().getForecastday().get(2).getHour()) {
            String time = x.getTime().substring(x.getTime().lastIndexOf(" ") + 1);
            precipitationData3.getData().add(new XYChart.Data<>(time, x.getPrecip_mm()));
        }

        // formatting
        precipGraph.setLegendVisible(false);
        precipGraphCategoryAxis.setLabel("Hour");
        precipGraphNumberAxis.setLabel("Millimeters");
    }

    void setWindGraph(){
        windData1.getData().removeAll(windData1.getData());
        windData2.getData().removeAll(windData2.getData());
        windData3.getData().removeAll(windData3.getData());

        windGraphDate1Selector.setText(weather.getForecast().getForecastday().get(0).getDate());
        windGraphDate2Selector.setText(weather.getForecast().getForecastday().get(1).getDate());
        windGraphDate3Selector.setText(weather.getForecast().getForecastday().get(2).getDate());

        for (Hour x : weather.getForecast().getForecastday().get(0).getHour()) {
            String time = x.getTime().substring(x.getTime().lastIndexOf(" ") + 1);
            windData1.getData().add(new XYChart.Data<>(time, x.getWind_kph()));
        }
        for (Hour x : weather.getForecast().getForecastday().get(1).getHour()) {
            String time = x.getTime().substring(x.getTime().lastIndexOf(" ") + 1);
            windData2.getData().add(new XYChart.Data<>(time, x.getWind_kph()));
        }
        for (Hour x : weather.getForecast().getForecastday().get(2).getHour()) {
            String time = x.getTime().substring(x.getTime().lastIndexOf(" ") + 1);
            windData3.getData().add(new XYChart.Data<>(time, x.getWind_kph()));
        }

        // formatting
        windGraph.setLegendVisible(false);
        windGraphCategoryAxis.setLabel("Hour");
        windGraphNumberAxis.setLabel("Kilometers Per Hour");
    }

    void importFavourites(){
        try (Reader reader = new FileReader("src/main/resources/com/rainyday/rainyday/favourites.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Type stringType = new TypeToken<HashSet<String>>(){}.getType();
            favourites = gson.fromJson(reader, stringType);
            favouritesList.setItems(FXCollections.observableArrayList(favourites));
        } catch (IOException e) {
            Alert favouritesImportError = new Alert(Alert.AlertType.INFORMATION);
            favouritesImportError.setHeaderText("Saved Favourites Not Found");
            favouritesImportError.setContentText("A new favourites.json file will be created");
            favouritesImportError.getDialogPane().getStyleClass().add("info-dialog");
            Stage stage = (Stage) favouritesImportError.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(getClass().getResourceAsStream("RainyDay_Icon.png")));
            favouritesImportError.showAndWait();
        }
    }

    void exportFavourites(){
        try (Writer writer = new FileWriter("src/main/resources/com/rainyday/rainyday/favourites.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(favourites, writer);
        } catch (IOException e) {
            Alert favouritesExportError = new Alert(Alert.AlertType.ERROR);
            favouritesExportError.setHeaderText("Error Occurred During Favourites Setup");
            favouritesExportError.setContentText("There was an error exporting the saved favourites.");
            favouritesExportError.getDialogPane().getStyleClass().add("error-dialog");
            Stage stage = (Stage) favouritesExportError.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(getClass().getResourceAsStream("RainyDay_Icon.png")));
            favouritesExportError.showAndWait();
        }
    }

    void setLightTheme(int weatherCode){
        try {
            switch (weatherCode){
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
            Alert lightThemeError = new Alert(Alert.AlertType.ERROR);
            lightThemeError.setHeaderText("Error Occurred During UI Setup");
            lightThemeError.setContentText("There was an error setting the correct day theme.");
            lightThemeError.getDialogPane().getStyleClass().add("error-dialog");
            Stage stage = (Stage) lightThemeError.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(getClass().getResourceAsStream("RainyDay_Icon.png")));
            lightThemeError.showAndWait();
        }
    }

    void setDarkTheme(int weatherCode){
        try {
            switch (weatherCode){
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
            Alert darkThemeError = new Alert(Alert.AlertType.ERROR);
            darkThemeError.setHeaderText("Error Occurred During UI Setup");
            darkThemeError.setContentText("There was an error setting the correct night theme.");
            darkThemeError.getDialogPane().getStyleClass().add("error-dialog");
            Stage stage = (Stage) darkThemeError.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(getClass().getResourceAsStream("RainyDay_Icon.png")));
            darkThemeError.showAndWait();
        }
    }
}