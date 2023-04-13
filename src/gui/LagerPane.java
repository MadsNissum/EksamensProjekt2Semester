package gui;

import application.controller.Controller;
import application.model.Fad;
import application.model.Lager;
import application.utility.Utility;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

public class LagerPane extends GridPane {
    private final ListView<Lager> lvwLager;
    private final ListView<Fad> lvwFade;

    public LagerPane() {
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(20));
        this.setGridLinesVisible(false);

        Label lblLagere = new Label("Lagere");
        this.add(lblLagere, 0, 0);

        lvwLager = new ListView<>();
        this.add(lvwLager, 0, 1, 1, 10);
        lvwLager.setPrefHeight(324);
        lvwLager.setPrefWidth(400);
        lvwLager.getItems().setAll(Controller.getLager());
        ChangeListener<Lager> listener = (ov, oldItem, newItem) -> this.selectedLager();
        lvwLager.getSelectionModel().selectedItemProperty().addListener(listener);
        lvwLager.setStyle("-fx-font-family: 'DejaVu Sans Mono';" + "-fx-font-size: 11px;");


        Label lblFade = new Label("Fade");
        this.add(lblFade, 1, 0);

        lvwFade = new ListView<>();
        this.add(lvwFade, 1, 1, 1, 10);
        lvwFade.setPrefHeight(324);
        lvwFade.setPrefWidth(400);
        lvwFade.setStyle("-fx-font-family: 'DejaVu Sans Mono';" + "-fx-font-size: 11px;");



        Button btnCreate= new Button("Create");
        this.add(btnCreate, 2, 1);
        btnCreate.setOnAction(actionEvent -> this.opretAction());

        Button btnUpdate= new Button("Update");
        this.add(btnUpdate, 2, 2);
        btnUpdate.setOnAction(actionEvent -> this.updateAction());

        Button btnDelete= new Button("Delete");
        this.add(btnDelete, 2, 3);
        btnDelete.setOnAction(actionEvent -> this.deleteAction());
    }

    private void deleteAction() {
        Lager lager = lvwLager.getSelectionModel().getSelectedItem();
        if (lager != null) {
            if (Utility.alert("Slet lager", "Er du sikker på du vil slette dette lager?")) {
                Controller.removeLager(lager);
                updateControls();
            }
        }
    }

    private void opretAction() {
        LagerWindow lagerWindow = new LagerWindow("Opret Lager");
        lagerWindow.showAndWait();

        updateControls();
    }


    private void updateAction() {
        Lager lager = lvwLager.getSelectionModel().getSelectedItem();
        if (lager != null) {
            LagerWindow lagerWindow = new LagerWindow("Opdatere Lager", lager);
            lagerWindow.showAndWait();

            updateControls();
        }
    }

    public void updateControls() {
        lvwLager.getItems().setAll(Controller.getLager());
    }

    public void selectedLager() {
        if (lvwLager.getSelectionModel().getSelectedItem() != null) {
            lvwFade.getItems().setAll(lvwLager.getSelectionModel().getSelectedItem().getFade());
        }
    }
}
