package com.rainyday.rainyday;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class Main extends Application {

    private static Main applicationInstance;

    public static Main getApplicationInstance() {
        return applicationInstance;
    }
    @Override
    public void init(){
        applicationInstance = this;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("ui_config.fxml"));
        stage.setTitle("RainyDay");
        Scene scene = new Scene(fxmlLoader);
        scene.getStylesheets().setAll(getClass()
                .getResource("styles/startup_theme.css")
                .toURI().toString());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String args[]){
        launch(args);
    }
}
