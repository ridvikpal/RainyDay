package com.rainyday.rainyday;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.util.Objects;

public class Main extends Application {

    static Controller controller;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ui_config.fxml"));
        Parent root = fxmlLoader.load();
        stage.setTitle("RainyDay");
        Scene scene = new Scene(root);
        scene.getStylesheets().setAll(Objects.requireNonNull(getClass()
                .getResource("styles/startup_theme.css"))
                .toURI().toString());

        // assign pointer to controller in
        controller = (Controller)fxmlLoader.getController();

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @Override
    public void stop(){
        // export the favourites to a json file to loadup on next startup
        controller.exportFavourites();
    }

    public static void main(String args[]){
        launch(args);
    }
}
