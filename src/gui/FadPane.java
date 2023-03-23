package gui;

import application.controller.Controller;
import application.model.Fad;
import application.model.Lager;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.Optional;

public class FadPane extends GridPane {
    private ListView<Fad> fadListView;

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
        fadListView.getItems().setAll(Controller.getFade());

        ChangeListener<Fad> fadChangeListener = (ov, oldValue, newValue) -> this.fadChanged();
        fadListView.getSelectionModel().selectedItemProperty().addListener(fadChangeListener);

        ComboBox<Lager> lagerComboBox = new ComboBox<>();
        this.add(lagerComboBox, 3, 1);
        lagerComboBox.setPromptText("Adresser");
        lagerComboBox.getItems().addAll(Controller.getLager());

        Button btnTilføj = new Button("Tilføj");
        this.add(btnTilføj,3,2);
        btnTilføj.setOnAction(event -> this.tilføj());

        Button btnOpret = new Button("Opret");
        this.add(btnOpret, 4,1);
        btnOpret.setPrefWidth(100);
        btnOpret.setOnAction(event -> this.opret());

        Button btnOpdater = new Button("Opdater");
        this.add(btnOpdater, 4,2);
        btnOpdater.setPrefWidth(100);
        btnOpdater.setOnAction(event -> this.opdater());

        Button btnSlet = new Button("Slet");
        this.add(btnSlet, 4,3);
        btnSlet.setPrefWidth(100);
        btnSlet.setOnAction(event -> this.slet());
    }

    private void tilføj() {

    }

    private void opret() {
        FadWindow fadWindow = new FadWindow("Opret fad");
        fadWindow.showAndWait();

        fadListView.getItems().setAll(Controller.getFade());
        int index = fadListView.getItems().size() - 1;
        fadListView.getSelectionModel().select(index);
    }

    private void opdater() {
        Fad fad = fadListView.getSelectionModel().getSelectedItem();
        if (fad != null) {

            FadWindow fadWindow = new FadWindow("Opdater fad", fad);
            fadWindow.showAndWait();

            int selectIndex = fadListView.getSelectionModel().getSelectedIndex();
            fadListView.getItems().setAll(Controller.getFade());
            fadListView.getSelectionModel().select(selectIndex);
        }
    }

    private void slet() {
        Fad fad = fadListView.getSelectionModel().getSelectedItem();
        if (fad != null) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Slet fad");
            alert.setHeaderText("Er du sikker på, at du vil slette fadet?");
            Optional<ButtonType> result = alert.showAndWait();

            if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
                Controller.removeFad(fad);
                fadListView.getItems().setAll(Controller.getFade());

                this.updateControls();
            }
        }
    }

    private void fadChanged() {
            this.updateControls();
        }


        public void updateControls() {
            Fad fad = fadListView.getSelectionModel().getSelectedItem();
            if (fad != null) {

        }


    }
}
