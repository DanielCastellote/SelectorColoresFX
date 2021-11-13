package com.example.selectorcoloresfx;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Vista extends VBox {

    Label pantalla = new Label();
    HBox boxRojo = new HBox();
    HBox boxVerde = new HBox();
    HBox boxAzul = new HBox();
    Label labRojo = new Label();
    Label labVerde = new Label();
    Label labAzul = new Label();
    Label valorRojo = new Label();
    Label valorVerde = new Label();
    Label valorAzul = new Label();
    Slider rojo = new Slider(0, 255, 0);
    Slider verde = new Slider(0, 255, 0);
    Slider azul = new Slider(0, 255, 0);

    SimpleIntegerProperty valorR;
    SimpleIntegerProperty valorV;
    SimpleIntegerProperty valorA;


    //ObservableList<NumberBinding> valores = FXCollections.observableArrayList();
    // ListProperty<NumberBinding> valores;

    public Vista() {
        inciarElementos();
    }

    public void inciarElementos() {
        pantalla.setPrefSize(400, 100);

        rojo.setShowTickMarks(true);
        verde.setShowTickMarks(true);
        azul.setShowTickMarks(true);

        valorR = new SimpleIntegerProperty();
        valorV = new SimpleIntegerProperty();
        valorA = new SimpleIntegerProperty();

        valorR.bind(rojo.valueProperty());
        valorV.bind(verde.valueProperty());
        valorA.bind(azul.valueProperty());

        valorRojo.textProperty().bind(valorR.asString());
        valorVerde.textProperty().bind(valorV.asString());
        valorAzul.textProperty().bind(valorA.asString());

        valorRojo.setMinWidth(30);
        valorVerde.setMinWidth(30);
        valorAzul.setMinWidth(30);

        boxRojo.getChildren().add(labRojo);
        boxRojo.getChildren().add(rojo);
        boxRojo.getChildren().add(valorRojo);

        boxVerde.getChildren().add(labVerde);
        boxVerde.getChildren().add(verde);
        boxVerde.getChildren().add(valorVerde);

        boxAzul.getChildren().add(labAzul);
        boxAzul.getChildren().add(azul);
        boxAzul.getChildren().add(valorAzul);

        this.getChildren().add(pantalla);
        this.getChildren().add(boxRojo);
        this.getChildren().add(boxVerde);
        this.getChildren().add(boxAzul);

        labRojo.setText("Rojo-> ");
        labVerde.setText("Verde-> ");
        labAzul.setText("Azul-> ");

        labRojo.setMinWidth(40);
        labVerde.setMinWidth(40);
        labAzul.setMinWidth(40);

        rojo.prefWidthProperty().bind(this.widthProperty().subtract(labRojo.getWidth()).subtract(valorRojo.getWidth()));
        verde.prefWidthProperty().bind(this.widthProperty().subtract(labVerde.getWidth()).subtract(valorVerde.getWidth()));
        azul.prefWidthProperty().bind(this.widthProperty().subtract(labAzul.getWidth()).subtract(valorAzul.getWidth()));

        pantalla.prefWidthProperty().bind(this.widthProperty());
        pantalla.prefHeightProperty().bind(this.heightProperty().subtract(boxRojo.getHeight()).multiply(3));

        valorR.addListener(r -> {
            BackgroundFill fill = new BackgroundFill(
                    Color.rgb(valorR.intValue(), valorV.intValue(), valorA.intValue()),
                    null,
                    null);
            pantalla.setBackground(new Background(fill));});

        valorV.addListener(v -> {
            BackgroundFill fill = new BackgroundFill(
                    Color.rgb(valorR.intValue(), valorV.intValue(), valorA.intValue()),
                    null,
                    null);
            pantalla.setBackground(new Background(fill));});

        valorA.addListener(a -> {
            BackgroundFill fill = new BackgroundFill(
                    Color.rgb(valorR.intValue(), valorV.intValue(), valorA.intValue()),
                    null,
                    null);
            pantalla.setBackground(new Background(fill));});
    }

}


