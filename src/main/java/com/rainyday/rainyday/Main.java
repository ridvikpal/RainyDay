package com.rainyday.rainyday;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("ui_config.fxml"));
        stage.setTitle("RainyDay");
        stage.setScene(new Scene(fxmlLoader));
        stage.show();
    }

    public static void main(String args[]){
        launch(args);
    }
}
