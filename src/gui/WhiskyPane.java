package gui;

import application.controller.Controller;
import application.model.Fad;
import application.utility.Number;
import application.utility.Utility;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class WhiskyPane extends GridPane {
    private final ListView<Fad> lvwFade = new ListView<>();
    private final TextField txfMængde = new TextField();
    private final TextField txfAntal = new TextField();
    private final Button btnOk = new Button("Ok");
    private final Button btnCancel = new Button("Cancel");
    private final Label lblError = new Label();


    public WhiskyPane() {
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(20));
        this.setGridLinesVisible(false);

        this.add(new Label("Fade"), 0, 0);

        this.add(lvwFade, 0, 1,1, 10);
        lvwFade.setPrefWidth(250);
        lvwFade.setPrefHeight(324);
        updateControls();
        ChangeListener<Fad> listener = (ov, oldCompny, newCompany) -> this.selectedFad();
        lvwFade.getSelectionModel().selectedItemProperty().addListener(listener);

        this.add(new Label("Mængde"), 1, 0);

        this.add(txfMængde, 1, 1,2,1);

        this.add(new Label("Antal"), 1, 2);

        this.add(txfAntal, 1, 3,2,1);

        this.add(btnCancel, 1, 4);
        btnCancel.setPrefWidth(75);

        this.add(btnOk, 2, 4);
        btnOk.setPrefWidth(75);
        GridPane.setHalignment(btnOk, HPos.RIGHT);
        btnOk.setOnAction(actionEvent -> okAction());

        this.add(lblError, 2, 5);
        lblError.setStyle("-fx-text-fill: red");



    }

    private void okAction() {
        double liter = Number.checkerDouble(txfMængde.getText().trim());
        int antal = Number.checkerInt(txfAntal.getText().trim());


        if (liter <= 0) {
            lblError.setText("Indtast en korrekt mængde");
        } else if (antal <= 0) {
            lblError.setText("Indtast et korrekt nummer");
        } else {
            Controller.createWhiskyflaske(liter);
            updateControls();
        }

    }

    private void selectedFad() {
        Fad fad = lvwFade.getSelectionModel().getSelectedItem();

    }

    public void updateControls() {
        lvwFade.getItems().setAll(Controller.getFadeWhisky());
    }
}
