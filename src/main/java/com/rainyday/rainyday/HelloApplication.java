package com.rainyday.rainyday;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// In JavaFX the main class must extend the Application interface
public class HelloApplication extends Application {
    // the start method initializes the program
    @Override
    public void start(Stage stage) throws IOException {
        // load the application setup via the fxml file
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        // create a scene (window content)
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        // set the window (stage) title
        stage.setTitle("RainyDay");

        // set the scene (contents) for the stage (window)
        stage.setScene(scene);

        // show the actual window
        stage.show();
    }

    // launch the program
    public static void main(String[] args) {
        launch(args);
    }
}