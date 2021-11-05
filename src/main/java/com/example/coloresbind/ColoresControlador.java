package com.example.coloresbind;

import javafx.beans.binding.NumberBinding;
import javafx.scene.layout.Pane;

public class ColoresControlador {

    public void cambiarColores(NumberBinding r,NumberBinding g,NumberBinding b, Pane panel){
        int red = Integer.parseInt(r.getValue().toString());
        int green = Integer.parseInt(g.getValue().toString());
        int blue = Integer.parseInt(b.getValue().toString());

        String color = red+","+green+","+blue;
        panel.setStyle("-fx-background-color: rgb("+color+")");
    }

}