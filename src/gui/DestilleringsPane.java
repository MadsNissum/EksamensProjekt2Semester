package gui;

import application.controller.Controller;
import application.model.Destillering;
import application.model.Tap;
import application.utility.Utility;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class DestilleringsPane extends GridPane {
    private ListView<Destillering> destilleringListView;
    private ListView<Tap> tapListView;
    private TextField txfStartDato, txfSlutDato, txfMaltBatch,
            txfKornSort, txfMedarbejder, txfMængde, txfAlkoholProcent, txfRygeMateriale, txfKommentar;

    public DestilleringsPane() {
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(20));
        this.setGridLinesVisible(false);

        this.add(new Label("Destillering"), 0, 0);
        this.add(new Label("Tappe"), 2, 0);

        destilleringListView = new ListView<>();
        this.add(destilleringListView, 0, 1, 1, 10);
        destilleringListView.setPrefWidth(200);
        destilleringListView.setPrefHeight(150);
        updateControls();
        ChangeListener<Destillering> listener = (ov, oldItem, newItem) -> this.selectDestillering();
        destilleringListView.getSelectionModel().selectedItemProperty().addListener(listener);


        tapListView = new ListView<>();
        this.add(tapListView, 2, 1, 1, 10);
        tapListView.setPrefWidth(150);
        tapListView.setPrefHeight(150);

        txfStartDato = new TextField();
        this.add(txfStartDato, 1, 1);
        txfStartDato.setPromptText("Startdato");
        txfStartDato.setEditable(false);

        txfSlutDato = new TextField();
        this.add(txfSlutDato, 1, 2);
        txfSlutDato.setPromptText("Slutdato");
        txfSlutDato.setEditable(false);

        txfMaltBatch = new TextField();
        this.add(txfMaltBatch, 1, 3);
        txfMaltBatch.setPromptText("Maltbatch");
        txfMaltBatch.setEditable(false);

        txfKornSort = new TextField();
        this.add(txfKornSort, 1, 4);
        txfKornSort.setPromptText("Kornsort");
        txfKornSort.setEditable(false);

        txfMedarbejder = new TextField();
        this.add(txfMedarbejder, 1, 5);
        txfMedarbejder.setPromptText("Medarbejder");
        txfMedarbejder.setEditable(false);

        txfMængde = new TextField();
        this.add(txfMængde, 1, 6);
        txfMængde.setPromptText("Mængde");
        txfMængde.setEditable(false);

        txfAlkoholProcent = new TextField();
        this.add(txfAlkoholProcent, 1, 7);
        txfAlkoholProcent.setPromptText("Alkoholprocent");
        txfAlkoholProcent.setEditable(false);

        txfRygeMateriale = new TextField();
        this.add(txfRygeMateriale, 1, 8);
        txfRygeMateriale.setPromptText("Rygemateriale");
        txfRygeMateriale.setEditable(false);

        txfKommentar = new TextField();
        this.add(txfKommentar, 1, 9);
        txfKommentar.setPromptText("Kommentar");
        txfKommentar.setEditable(false);

        Button btnOpret = new Button("Opret");
        this.add(btnOpret, 4, 1);
        btnOpret.setPrefWidth(100);
        btnOpret.setOnAction(actionEvent -> this.opret());

        Button btnOpdater = new Button("Opdater");
        this.add(btnOpdater, 4, 2);
        btnOpdater.setPrefWidth(100);
        //btnUpdate.setOnAction(actionEvent -> this.opdater());

        Button btnDelete = new Button("Slet");
        this.add(btnDelete, 4, 3);
        btnDelete.setPrefWidth(100);
        btnDelete.setOnAction(actionEvent -> this.slet());


    }

    private void opret() {
        DestilleringsWindow destilleringsWindow = new DestilleringsWindow("Opret fad");
        destilleringsWindow.showAndWait();

        updateControls();
    }

    private void slet() {
        Destillering destillering = destilleringListView.getSelectionModel().getSelectedItem();
        if (destillering != null) {
            if (Utility.alert("Slet destillering", "Er du sikker på, at du vil slette destilleringen?")) {
                Controller.removeDestilleringer(destillering);
                updateControls();
            }
        }
    }

    private void selectDestillering() {
        Destillering destillering = destilleringListView.getSelectionModel().getSelectedItem();

        if (destillering != null) {
            txfStartDato.setText("" + destillering.getStartDato());
            txfSlutDato.setText("" + destillering.getSlutDato());
            txfMaltBatch.setText(destillering.getMaltbatch());
            txfKornSort.setText(destillering.getKornsort());
            txfMedarbejder.setText(destillering.getMedarbejder());
            txfMængde.setText("" + destillering.getMændge());
            txfAlkoholProcent.setText("" + destillering.getAlkoholProcent());
            txfRygeMateriale.setText("" + destillering.getAlkoholProcent());
            txfKommentar.setText(destillering.getKommentar());
        }
    }

    private void updateControls() {
        destilleringListView.getItems().setAll(Controller.getDestilleringer());
    }
}
