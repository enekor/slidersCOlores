package com.example.coloresbind;

import javafx.scene.layout.Pane;

public class ColoresControlador {

    public void cambiarColores(int r,int g,int b, Pane panel) {
        int red = r;
        int green = g;
        int blue = b;

        String color = red + "," + green + "," + blue;
        panel.setStyle("-fx-background-color: rgb(" + color + ")");
    }
}

