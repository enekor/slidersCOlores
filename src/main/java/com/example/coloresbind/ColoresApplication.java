package com.example.coloresbind;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ColoresApplication extends Application {
    @Override
    public void start(Stage stage){
        Scene scene = new Scene(new ColoresVista());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}