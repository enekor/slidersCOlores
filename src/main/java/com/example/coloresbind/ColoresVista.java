package com.example.coloresbind;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
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
    private Label r,g,b,valorR,valorG,valorB;
    private ColoresControlador controlador = new ColoresControlador();
    private IntegerProperty intR,intG,intB;

    private final int LABEL_WIDTH = 20;
    private final int CONTROLES_HEIGHT = 40;

    public ColoresVista(){
        init();
    }

    public void init(){
        initObjects();

        intR.bind(red.valueProperty());
        intG.bind(green.valueProperty());
        intB.bind(blue.valueProperty());

        valorR.textProperty().bind(intR.asString());
        valorB.textProperty().bind(intB.asString());
        valorG.textProperty().bind(intG.asString());

        blue.setOnMouseDragged(v->cambiarColor());
        red.setOnMouseDragged(v->cambiarColor());
        green.setOnMouseDragged(v->cambiarColor());
    }

    private void initObjects() {
        panel = new Pane();
        valorR = new Label("0");
        valorG = new Label("0");
        valorB = new Label("0");
        red = new Slider(0,255,0);
        green = new Slider(0,255,0);
        blue = new Slider(0,255,0);
        r = new Label("R");
        g = new Label("G");
        b = new Label("B");
        panelRed = new HBox(r,red,valorR);
        panelGreen = new HBox(g, green, valorG);
        panelBlue = new HBox(b,blue, valorB);
        controles = new VBox(panelRed,panelGreen,panelBlue);
        intR = new SimpleIntegerProperty();
        intG = new SimpleIntegerProperty();
        intB = new SimpleIntegerProperty();
        this.getChildren().addAll(controles,panel);

        bindSize();
    }

    private void cambiarColor(){
        int redBind = intR.intValue();
        int greenBind = intG.intValue();
        int blueBind = intB.intValue();

        controlador.cambiarColores(redBind,greenBind,blueBind,panel);
    }

    private void bindSize(){
        r.setPrefWidth(LABEL_WIDTH);
        g.setPrefWidth(LABEL_WIDTH);
        b.setPrefWidth(LABEL_WIDTH);
        valorR.setPrefWidth(LABEL_WIDTH);
        valorG.setPrefWidth(LABEL_WIDTH);
        valorB.setPrefWidth(LABEL_WIDTH);
        panel.setPrefHeight(50);
        this.widthProperty().addListener(e -> {
            panel.setPrefHeight(this.getHeight());
            red.setPrefWidth(this.getWidth()-(LABEL_WIDTH*2));
            green.setPrefWidth(this.getWidth()-(LABEL_WIDTH*2));
            blue.setPrefWidth(this.getWidth()-(LABEL_WIDTH*2));
        });
        this.heightProperty().addListener(e -> {
            panel.setPrefHeight(this.getHeight());
            red.setPrefWidth(this.getWidth()-(LABEL_WIDTH*2));
            green.setPrefWidth(this.getWidth()-(LABEL_WIDTH*2));
            blue.setPrefWidth(this.getWidth()-(LABEL_WIDTH*2));
        });
        controles.setStyle("-fx-background-color: rgba(16,6,9,0.15)");
    }
}

