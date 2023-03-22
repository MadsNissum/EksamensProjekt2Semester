package gui;

import application.controller.Controller;
import application.model.Fad;
import application.model.Lager;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

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
        ChangeListener<Fad> listener1 = (ov, oldCompny, newCompany) -> this.selectedFade();
        lvwFade.getSelectionModel().selectedItemProperty().addListener(listener1);


        Button btnCreate= new Button("Create");
        this.add(btnCreate, 2, 1);

        btnCreate.setOnAction(actionEvent -> {
            LagerWindow lagerWindow = new LagerWindow();
            lagerWindow.showAndWait();});

        Button btnUpdate= new Button("Update");
        this.add(btnUpdate, 2, 2);

        Button btnDelete= new Button("Delete");
        this.add(btnDelete, 2, 3);





    }

    private void selectedFade() {
    }

    private void selectedLager() {
    }

}
