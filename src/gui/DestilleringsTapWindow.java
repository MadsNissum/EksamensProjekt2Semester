package gui;

import application.controller.Controller;
import application.model.Destillering;
import application.model.Fad;
import application.model.Lager;
import application.model.Tap;
import application.utility.Number;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

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

    public DestilleringsTapWindow(String title) {
        this(title, null, null);
    }

    private ListView <Fad>lvwFade;
    private TextField txfMængde;
    private Label lblError;

    private void initContent(GridPane pane) {

        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);


        pane.add(new Label("Mængde"), 0, 0);

        txfMængde = new TextField();
        pane.add(txfMængde, 0, 1);
        txfMængde.setEditable(true);

        lvwFade = new ListView<>();
        pane.add(lvwFade, 0, 2, 1, 10);
        lvwFade.setPrefWidth(250);
        lvwFade.setPrefHeight(324);
        updateControls();
        ChangeListener<Fad> listener = (ov, oldItem, newItem) -> this.selectFade();
        lvwFade.getSelectionModel().selectedItemProperty().addListener(listener);

        Button btnTapFad = new Button("Tap");
        pane.add(btnTapFad, 1, 1);
        btnTapFad.setPrefWidth(100);
        btnTapFad.setOnAction(actionEvent -> this.tapFad());

        lblError = new Label();
        pane.add(lblError, 0 , 13);
        lblError.setStyle("-fx-text-fill: red");


        this.initControls();
    }

    private void tapFad() {
        double mængde = Number.checkerDouble(txfMængde.getText().trim());
        Fad fad = lvwFade.getSelectionModel().getSelectedItem();


        if (mængde < 0 || mængde > destillering.getMændge()) {
            lblError.setText("Indtast en korrekt mængde");
        } else if (fad == null) {
            lblError.setText("Vælg et fad at fylde på");
        } else if (fad.getKapacitet() < mængde) {
            lblError.setText("Der er ikke plads på fadet");
        } else {
            destillering.setMændge(Controller.destillatAftap(destillering, mængde));
            updateControls();
            Controller.createTap(mængde, destillering, fad);

            hide();
        }


    }

    private void selectFade() {
       Fad fad = lvwFade.getSelectionModel().getSelectedItem();

       if (fad != null) {

       }
    }

    private void initControls() {
        lvwFade.getSelectionModel().getSelectedItem();


    }
    public void updateControls() {
        lvwFade.getItems().setAll(Controller.getFade());
    }



}

