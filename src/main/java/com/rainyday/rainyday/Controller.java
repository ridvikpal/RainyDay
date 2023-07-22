package com.rainyday.rainyday;

/**
 * Sample Skeleton for 'ui_config.fxml' Controller Class
 */

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
import javafx.scene.text.Text;
import javafx.event.ActionEvent;

public class Controller {

    @FXML // fx:id="tempTab"
    private Tab tempTab; // Value injected by FXMLLoader

    @FXML // fx:id="rightPaneAnchorPane"
    private AnchorPane rightPaneAnchorPane; // Value injected by FXMLLoader

    @FXML // fx:id="windTab"
    private Tab windTab; // Value injected by FXMLLoader

    @FXML // fx:id="searchButton"
    private Button searchButton; // Value injected by FXMLLoader

    @FXML // fx:id="graphTabPane"
    private TabPane graphTabPane; // Value injected by FXMLLoader

    @FXML // fx:id="feelsLikeText"
    private Text feelsLikeText; // Value injected by FXMLLoader

    @FXML // fx:id="tempGraph"
    private AreaChart<?, ?> tempGraph; // Value injected by FXMLLoader

    @FXML // fx:id="precipGraph"
    private AreaChart<?, ?> precipGraph; // Value injected by FXMLLoader

    @FXML // fx:id="loadButton"
    private Button loadButton; // Value injected by FXMLLoader

    @FXML // fx:id="precipitationLabel"
    private Text precipitationLabel; // Value injected by FXMLLoader

    @FXML // fx:id="airQualityText"
    private Text airQualityText; // Value injected by FXMLLoader

    @FXML // fx:id="favouritesTable"
    private TableView<?> favouritesTable; // Value injected by FXMLLoader

    @FXML // fx:id="windLabel"
    private Text windLabel; // Value injected by FXMLLoader

    @FXML // fx:id="locationAndTimeText"
    private Text locationAndTimeText; // Value injected by FXMLLoader

    @FXML // fx:id="visibilityLabel"
    private Text visibilityLabel; // Value injected by FXMLLoader

    @FXML // fx:id="uvLabel"
    private Text uvLabel; // Value injected by FXMLLoader

    @FXML // fx:id="uvText"
    private Text uvText; // Value injected by FXMLLoader

    @FXML // fx:id="precipTabAnchorPane"
    private AnchorPane precipTabAnchorPane; // Value injected by FXMLLoader

    @FXML // fx:id="windGraphAnchorPane"
    private AnchorPane windGraphAnchorPane; // Value injected by FXMLLoader

    @FXML // fx:id="pressureLabel"
    private Text pressureLabel; // Value injected by FXMLLoader

    @FXML // fx:id="conditionText"
    private Text conditionText; // Value injected by FXMLLoader

    @FXML // fx:id="humidityLabel"
    private Text humidityLabel; // Value injected by FXMLLoader

    @FXML // fx:id="addButton"
    private Button addButton; // Value injected by FXMLLoader

    @FXML // fx:id="tempTabAnchorPane"
    private AnchorPane tempTabAnchorPane; // Value injected by FXMLLoader

    @FXML // fx:id="visibilityText"
    private Text visibilityText; // Value injected by FXMLLoader

    @FXML // fx:id="windText"
    private Text windText; // Value injected by FXMLLoader

    @FXML // fx:id="humidityText"
    private Text humidityText; // Value injected by FXMLLoader

    @FXML // fx:id="citySearchBar"
    private TextField citySearchBar; // Value injected by FXMLLoader

    @FXML // fx:id="leftPaneAnchorPane"
    private AnchorPane leftPaneAnchorPane; // Value injected by FXMLLoader

    @FXML // fx:id="pressureText"
    private Text pressureText; // Value injected by FXMLLoader

    @FXML // fx:id="removeButton"
    private Button removeButton; // Value injected by FXMLLoader

    @FXML // fx:id="precipTab"
    private Tab precipTab; // Value injected by FXMLLoader

    @FXML // fx:id="airQualityLabel"
    private Text airQualityLabel; // Value injected by FXMLLoader

    @FXML // fx:id="weatherBackground"
    private ImageView weatherBackground; // Value injected by FXMLLoader

    @FXML // fx:id="precipitationText"
    private Text precipitationText; // Value injected by FXMLLoader

    @FXML // fx:id="currentTempText"
    private Text currentTempText; // Value injected by FXMLLoader

    @FXML // fx:id="splitPaneScene"
    private SplitPane splitPaneScene; // Value injected by FXMLLoader

    @FXML // fx:id="windGraph"
    private AreaChart<?, ?> windGraph; // Value injected by FXMLLoader

    @FXML // fx:id="alertText"
    private Text alertText; // Value injected by FXMLLoader

    @FXML // fx:id="favouritesColumn"
    private TableColumn<?, ?> favouritesColumn; // Value injected by FXMLLoader

    @FXML
    void dd0000(ActionEvent event) {

    }
}