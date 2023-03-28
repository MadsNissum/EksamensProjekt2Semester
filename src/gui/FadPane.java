package gui;

import application.controller.Controller;
import application.model.Fad;
import application.model.Lager;
import application.model.Tap;
import application.utility.Utility;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class FadPane extends GridPane {
    private final ListView<Fad> fadListView = new ListView<>();
    private final ListView<Tap> tapListView = new ListView<>();
    private final TextField txfReol = new TextField();
    private final TextField txfHylde = new TextField();
    private final TextField txfPlads = new TextField();
    private final Label lblError = new Label();
    private final ComboBox<Lager> lagerComboBox = new ComboBox<>();
    private HBox hBox = new HBox();

    private Button btnOpret = new Button("+");
    private Button btnSlet = new Button("-");
    private Button btnOpdater = new Button("✎");

    public FadPane() {
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(20));
        this.setGridLinesVisible(false);

        this.add(new Label("Fad"), 0, 0);

        this.add(new Label("Tilføj fad til lager"), 3, 0);

        this.add(new Label("Tappe"), 4, 0);

        this.add(tapListView, 4, 1, 1, 10);
        tapListView.setPrefWidth(250);
        tapListView.setPrefHeight(324);

        this.add(hBox, 1, 0);
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.BASELINE_RIGHT);

        this.add(fadListView, 0, 1, 2, 10);
        fadListView.setPrefWidth(250);
        fadListView.setPrefHeight(324);
        updateControls();

        ChangeListener<Fad> listener = (ov, oldCompny, newCompany) -> this.selectedFad();
        fadListView.getSelectionModel().selectedItemProperty().addListener(listener);

        this.add(lagerComboBox, 3, 1);
        lagerComboBox.setPromptText("Adresser");
        lagerComboBox.getItems().addAll(Controller.getLager());

        Button btnTilføj = new Button("Tilføj / Opdater");
        btnTilføj.setPrefWidth(182);
        this.add(btnTilføj, 3, 5);
        btnTilføj.setOnAction(event -> this.tilføj());

        this.add(txfReol, 3, 2);
        txfReol.setPromptText("Reol");

        this.add(txfHylde, 3, 3);
        txfHylde.setPromptText("Hylde");

        this.add(txfPlads, 3, 4);
        txfPlads.setPromptText("Plads");

        btnOpret.setPrefWidth(29);
        btnOpret.setOnAction(event -> this.opret());

        btnOpret.setPrefWidth(29);
        btnOpdater.setOnAction(event -> this.opdater());

        btnSlet.setPrefWidth(29);
        btnSlet.setOnAction(event -> this.slet());

        hBox.getChildren().add(btnOpret);
        hBox.getChildren().add(btnSlet);
        hBox.getChildren().add(btnOpdater);

        this.add(lblError, 3, 6);
        lblError.setStyle("-fx-text-fill: red");
    }

    private void selectedFad() {
        Fad fad = fadListView.getSelectionModel().getSelectedItem();
        if (fad != null) {

            Lager lager = fad.getLager();

            if (lager != null) {
                lagerComboBox.getSelectionModel().select(lager);
                txfReol.setText(fad.getLagerPlads().getReol());
                txfHylde.setText(fad.getLagerPlads().getHylde());
                txfPlads.setText(fad.getLagerPlads().getPlads());
            } else {
                lagerComboBox.getSelectionModel().clearSelection();
                txfReol.clear();
                txfHylde.clear();
                txfPlads.clear();
            }
        }
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
            Utility.message("Tilføj fad til lager", "Fadet er tilføjet til: " + lagerComboBox.getSelectionModel().getSelectedItem());
            txfReol.clear();
            txfHylde.clear();
            txfPlads.clear();
            lagerComboBox.getSelectionModel().clearSelection();
            selectedFad();
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

