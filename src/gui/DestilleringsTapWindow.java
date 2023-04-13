package gui;

import application.controller.Controller;
import application.model.Destillering;
import application.model.Fad;
import application.model.Tap;
import application.utility.Number;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DestilleringsTapWindow extends Stage {

    private Destillering destillering;
    private Tap tap;
    private Fad fad;

    public DestilleringsTapWindow(String title, Destillering destillering, Fad fad) {
        GridPane pane = new GridPane();
        this.destillering = destillering;
        this.fad = fad;

        initContent(pane);

        this.setTitle(title);

        Scene scene = new Scene(pane);

        this.setScene(scene);
        pane.setPrefWidth(400);

    }

    private final ListView <Fad>lvwFade = new ListView<>();
    private final TextField txfMaengde = new TextField();
    private final Label lblError = new Label();

    private void initContent(GridPane pane) {

        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);


        pane.add(new Label("Mængde"), 0, 0);

        pane.add(txfMaengde, 0, 1);
        txfMaengde.setEditable(true);

        pane.add(lvwFade, 0, 2, 2, 10);
        lvwFade.setPrefWidth(250);
        lvwFade.setPrefHeight(324);
        updateControls();

        Button btnTapFad = new Button("Tap");
        pane.add(btnTapFad, 1, 1);
        btnTapFad.setPrefWidth(100);
        btnTapFad.setOnAction(actionEvent -> this.tapFad());

        pane.add(lblError, 0 , 13);
        lblError.setStyle("-fx-text-fill: red");
    }

    private void tapFad() {
        double liter = Number.checkerDouble(txfMaengde.getText().trim());
        Fad fad = lvwFade.getSelectionModel().getSelectedItem();


        if (liter < 0 || liter > destillering.getKapacitet()) {
            lblError.setText("Indtast en korrekt liter");
        } else if (fad == null) {
            lblError.setText("Vælg et fad at fylde på");
        } else {
            updateControls();
            try {
                Controller.createTap(liter, destillering, fad);
                hide();
            } catch (RuntimeException e) {
                lblError.setText(e.getMessage());
            }
        }
    }

    public void updateControls() {
        lvwFade.getItems().setAll(Controller.getIkkeFyldteFade());
    }
}

