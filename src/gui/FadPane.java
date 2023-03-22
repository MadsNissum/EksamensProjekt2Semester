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
        fadListView.setPrefWidth(200);
        fadListView.setPrefHeight(200);
        // fadListView.getItems().setAll(Controller.);

        ChangeListener<Fad> fadChangeListener = (fad, fad2, fad3) -> this.fadChanged();
        fadListView.getSelectionModel().selectedItemProperty().addListener(fadChangeListener);

        ComboBox<Lager> lagerComboBox = new ComboBox<>();
        //lagerComboBox.setPromptText("Lager");
        this.add(lagerComboBox,3,1);

        Button btnTilføj = new Button("Tilføj");
        this.add(btnTilføj,3,2);

        Button btnOpret = new Button("Opret");
        this.add(btnOpret, 4,1);
        btnOpret.setOnAction(event -> this.opret());

        Button btnOpdater = new Button("Opdater");
        this.add(btnOpdater, 4,2);
        btnOpdater.setOnAction(event -> this.opdater());

        Button btnSlet = new Button("Slet");
        this.add(btnSlet, 4,3);
        btnSlet.setOnAction(event -> this.slet());



    }

    private void opret() {
        FadWindow fadWindow = new FadWindow("Opret fad");
        fadWindow.showAndWait();

        // Wait for the modal dialog to close

        //fadListView.getItems().setAll(Controller.());
        int index = fadListView.getItems().size() - 1;
        fadListView.getSelectionModel().select(index);
    }

    private void opdater() {
    }

    private void slet() {
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
