package com.example.coloresbind;

import javafx.beans.binding.NumberBinding;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ColoresVista extends VBox {
    private HBox panelRed,panelGreen,panelBlue;;
    private VBox controles;
    private Pane panel;
    private Slider red,green,blue;
    private Label r,g,b;
    private ColoresControlador controlador = new ColoresControlador();

    public void init(){
        panelRed = new HBox();
        panelGreen = new HBox();
        panelBlue = new HBox();
        controles = new VBox();
        red = new Slider(0,255,0);

        green = new Slider(0,255,0);

        blue = new Slider(0,255,0);

        r = new Label("R");
        g = new Label("G");
        b = new Label("B");
        panel = new Pane();

        asignar();
    }

    private void asignar() {
        panelRed.getChildren().addAll(r,red);
        panelGreen.getChildren().addAll(g,green);
        panelBlue.getChildren().addAll(b,blue);

        controles.getChildren().addAll(panelRed,panelGreen,panelBlue);
        this.getChildren().addAll(panel,controles);
    }

    private void cambiarColor(){
        NumberBinding redBind = (NumberBinding) red.valueProperty();
        NumberBinding greenBind = (NumberBinding) green.valueProperty();
        NumberBinding blueBind = (NumberBinding) blue.valueProperty();

        controlador.cambiarColores(redBind,greenBind,blueBind,panel);
    }
}
