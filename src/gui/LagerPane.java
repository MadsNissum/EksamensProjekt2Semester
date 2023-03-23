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
import storage.Storage;

public class LagerPane extends GridPane {
    private ListView<Lager> lvwLager;
    private ListView<Fad> lvwFade;



    public LagerPane() {
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(20));
        this.setGridLinesVisible(false);

        Label lblLagere = new Label("Lagere");
        this.add(lblLagere, 0, 0);

        lvwLager = new ListView<>();
        this.add(lvwLager, 0, 1, 1, 10);
        lvwLager.setPrefHeight(200);
        lvwLager.setPrefWidth(200);
        lvwLager.getItems().setAll(Controller.getLager());
        ChangeListener<Lager> listener = (ov, oldCompny, newCompany) -> this.selectedLager();
        lvwLager.getSelectionModel().selectedItemProperty().addListener(listener);


        Label lblFade = new Label("Fade");
        this.add(lblFade, 1, 0);

        lvwFade = new ListView<>();
        this.add(lvwFade, 1, 1, 1, 10);
        lvwFade.setPrefHeight(200);
        lvwFade.setPrefWidth(200);
        lvwFade.getItems().setAll(Controller.getFade());


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
            if (Utility.alert("Slet fad", "Er du sikker på du vil slette dette lager?"))
            Storage.removeLager(lager);
            updateControls();
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
