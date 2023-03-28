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
    private ListView<Destillering> lvwDestillering;
    private ListView<Tap> lvwTap;
    private TextField txfStartDato, txfSlutDato, txfMaltBatch,
            txfKornSort, txfMedarbejder, txfMængde, txfAlkoholProcent, txfRygeMateriale, txfKommentar;

    public DestilleringsPane() {
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(20));
        this.setGridLinesVisible(false);

        this.add(new Label("Destillering"), 0, 0);
        this.add(new Label("Tappe"), 3, 0);

        lvwDestillering = new ListView<>();
        this.add(lvwDestillering, 0, 1, 1, 10);
        lvwDestillering.setPrefWidth(200);
        lvwDestillering.setPrefHeight(150);
        updateControls();
        ChangeListener<Destillering> listener = (ov, oldItem, newItem) -> this.selectDestillering();
        lvwDestillering.getSelectionModel().selectedItemProperty().addListener(listener);


        lvwTap = new ListView<>();
        this.add(lvwTap, 3, 1, 1, 10);
        lvwTap.setPrefWidth(150);
        lvwTap.setPrefHeight(150);

        txfStartDato = new TextField();
        this.add(new Label("Startdato: "), 1, 1);
        this.add(txfStartDato, 2, 1);
        txfStartDato.setEditable(false);

        txfSlutDato = new TextField();
        this.add(new Label("Slutdato: "), 1, 2);
        this.add(txfSlutDato, 2, 2);
        txfSlutDato.setEditable(false);

        txfMaltBatch = new TextField();
        this.add(new Label("Maltbatch: "), 1, 3);
        this.add(txfMaltBatch, 2, 3);
        txfMaltBatch.setEditable(false);

        txfKornSort = new TextField();
        this.add(new Label("Kortsort: "), 1, 4);
        this.add(txfKornSort, 2, 4);
        txfKornSort.setEditable(false);

        txfMedarbejder = new TextField();
        this.add(new Label("Medarbejder: "), 1, 5);
        this.add(txfMedarbejder, 2, 5);
        txfMedarbejder.setEditable(false);

        txfMængde = new TextField();
        this.add(new Label("Mængde: "), 1, 6);
        this.add(txfMængde, 2, 6);
        txfMængde.setEditable(false);

        txfAlkoholProcent = new TextField();
        this.add(new Label("Alkoholprocent: "), 1, 7);
        this.add(txfAlkoholProcent, 2, 7);
        txfAlkoholProcent.setEditable(false);

        txfRygeMateriale = new TextField();
        this.add(new Label("Rygemateriale: "), 1, 8);
        this.add(txfRygeMateriale, 2, 8);
        txfRygeMateriale.setEditable(false);

        txfKommentar = new TextField();
        this.add(new Label("Kommentar: "), 1, 9);
        this.add(txfKommentar, 2, 9);
        txfKommentar.setEditable(false);

        Button btnOpret = new Button("Opret");
        this.add(btnOpret, 4, 1);
        btnOpret.setPrefWidth(100);
        btnOpret.setOnAction(actionEvent -> this.opret());

        Button btnOpdater = new Button("Opdater");
        this.add(btnOpdater, 4, 2);
        btnOpdater.setPrefWidth(100);
        btnOpdater.setOnAction(actionEvent -> this.opdater());

        Button btnDelete = new Button("Slet");
        this.add(btnDelete, 4, 3);
        btnDelete.setPrefWidth(100);
        btnDelete.setOnAction(actionEvent -> this.slet());
        Button btnTap = new Button("Aftap");
        this.add(btnTap, 4, 4);
        btnTap.setPrefWidth(100);
        btnTap.setOnAction(actionEvent -> this.aftap());
    }

    private void opret() {
        DestilleringsWindow destilleringsWindow = new DestilleringsWindow("Opret destillering");
        destilleringsWindow.showAndWait();

        updateControls();
    }

    private void opdater() {
        Destillering destillering = lvwDestillering.getSelectionModel().getSelectedItem();
        if (destillering != null) {

            DestilleringsWindow destilleringsWindow = new DestilleringsWindow("Opdater destillering", destillering);
            destilleringsWindow.showAndWait();

            lvwDestillering.getSelectionModel().select(destillering);
            selectDestillering();
            updateControls();


        }
    }


    private void slet() {
        Destillering destillering = lvwDestillering.getSelectionModel().getSelectedItem();
        if (destillering != null) {
            if (Utility.alert("Slet destillering", "Er du sikker på, at du vil slette destilleringen?")) {
                Controller.removeDestilleringer(destillering);
                lvwDestillering.getItems().setAll(Controller.getDestilleringer());
                updateControls();
            }
        }
    }
    private void aftap() {

        Destillering destillering = lvwDestillering.getSelectionModel().getSelectedItem();

        if (destillering != null) {
            DestilleringsTapWindow destilleringsTapWindow = new DestilleringsTapWindow("Aftap destillat", destillering);
            destilleringsTapWindow.showAndWait();


            updateControls();
        } else {
            Utility.message("Ugyldigt input", "Der er ikke valgt et destillat");
        }
    }

    private void selectDestillering() {
        Destillering destillering = lvwDestillering.getSelectionModel().getSelectedItem();

        if (destillering != null) {
            txfStartDato.setText("" + destillering.getStartDato());
            txfSlutDato.setText("" + destillering.getSlutDato());
            txfMaltBatch.setText(destillering.getMaltbatch());
            txfKornSort.setText(destillering.getKornsort());
            txfMedarbejder.setText(destillering.getMedarbejder());
            txfMængde.setText("" + destillering.getMændge());
            txfAlkoholProcent.setText("" + destillering.getAlkoholProcent());
            txfRygeMateriale.setText("" + destillering.getRygemateriale());
            txfKommentar.setText(destillering.getKommentar());
        } else {
            txfStartDato.clear();
            txfSlutDato.clear();
            txfMaltBatch.clear();
            txfKornSort.clear();
            txfMedarbejder.clear();
            txfAlkoholProcent.clear();
            txfRygeMateriale.clear();
            txfKommentar.clear();
        }
    }

    private void updateControls() {
        lvwDestillering.getItems().setAll(Controller.getDestilleringer());

    }
}
