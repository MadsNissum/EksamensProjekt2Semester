package gui;

import application.controller.Controller;
import application.model.Fad;
import application.model.Lager;
import application.utility.Utility;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;


public class FadPane extends GridPane {
    private final ListView<Fad> fadListView;
    private final TextField txfReol, txfHylde, txfPlads;
    private final Label lblError;
    private final ComboBox<Lager> lagerComboBox;

    public FadPane() {
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(20));
        this.setGridLinesVisible(false);

        this.add(new Label("Fad"), 0, 0);

        fadListView = new ListView<>();
        this.add(fadListView, 0, 1, 1, 10);
        fadListView.setPrefWidth(250);
        fadListView.setPrefHeight(200);
        updateControls();

        lagerComboBox = new ComboBox<>();
        this.add(lagerComboBox, 3, 1);
        lagerComboBox.setPromptText("Adresser");
        lagerComboBox.getItems().addAll(Controller.getLager());

        Button btnTilføj = new Button("Tilføj");
        this.add(btnTilføj, 3, 5);
        btnTilføj.setOnAction(event -> this.tilføj());

        txfReol = new TextField();
        this.add(txfReol, 3, 2);
        txfReol.setPromptText("Reol");

        txfHylde = new TextField();
        this.add(txfHylde, 3, 3);
        txfHylde.setPromptText("Hylde");

        txfPlads = new TextField();
        this.add(txfPlads, 3, 4);
        txfPlads.setPromptText("Plads");

        Button btnOpret = new Button("Opret");
        this.add(btnOpret, 4, 1);
        btnOpret.setPrefWidth(100);
        btnOpret.setOnAction(event -> this.opret());

        Button btnOpdater = new Button("Opdater");
        this.add(btnOpdater, 4, 2);
        btnOpdater.setPrefWidth(100);
        btnOpdater.setOnAction(event -> this.opdater());

        Button btnSlet = new Button("Slet");
        this.add(btnSlet, 4, 3);
        btnSlet.setPrefWidth(100);
        btnSlet.setOnAction(event -> this.slet());

        lblError = new Label();
        this.add(lblError, 3, 6);
        lblError.setStyle("-fx-text-fill: red");
    }

    private void tilføj() {
        String reol = txfReol.getText().trim();
        String hylde = txfHylde.getText().trim();
        String plads = txfPlads.getText().trim();
        Fad fad = fadListView.getSelectionModel().getSelectedItem();
        Lager lager = lagerComboBox.getSelectionModel().getSelectedItem();
        if (lagerComboBox.getSelectionModel().isEmpty()) {
            lblError.setText("Vælg adresse");
        } else if (reol.isEmpty()) {
            lblError.setText("Indtast en reol");
        } else if (hylde.isEmpty()) {
            lblError.setText("Indtast en hylde");
        } else if (plads.isEmpty()) {
            lblError.setText("Indtast en plads");
        } else {
            Controller.createLagerPlads(fad, reol, hylde, plads);
            Controller.addFadTilLager(fad, lager);
            Utility.alert("Tilføj fad til lager", "Fadet er tilføjet til: " + lagerComboBox.getSelectionModel().getSelectedItem());
            txfReol.clear();
            txfHylde.clear();
            txfPlads.clear();
            lagerComboBox.getSelectionModel().clearSelection();
        }

    }

    private void opret() {
        FadWindow fadWindow = new FadWindow("Opret fad");
        fadWindow.showAndWait();

        updateControls();
    }

    private void opdater() {
        Fad fad = fadListView.getSelectionModel().getSelectedItem();
        if (fad != null) {

            FadWindow fadWindow = new FadWindow("Opdater fad", fad);
            fadWindow.showAndWait();

            updateControls();
        }
    }

    private void slet() {
        Fad fad = fadListView.getSelectionModel().getSelectedItem();
        if (fad != null) {
            if (Utility.alert("Slet fad", "Er du sikker på, at du vil slette fadet?")) {
                Controller.removeFad(fad);
                updateControls();
            }
        }
    }

    public void updateControls() {
        fadListView.getItems().setAll(Controller.getFade());
    }

}

