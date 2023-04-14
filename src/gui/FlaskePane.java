package gui;

import application.controller.Controller;
import application.model.*;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class FlaskePane extends GridPane {
    private final ListView<WhiskyFlaske> lvwFlaske = new ListView<>();
    private final TextField txfSearchBar = new TextField();
    private final TextArea txaInfo = new TextArea();

    public FlaskePane() {
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(20));
        this.setGridLinesVisible(false);

        this.add(new Label("Flasker"),0,0);
        this.add(new Label("Information"),1,1);

        this.add(txfSearchBar,0,1);
        txfSearchBar.setPromptText("🔍 Søg");

        txfSearchBar.textProperty().addListener((ov, oldItem, newItem) -> this.selectedSearchBar());

        this.add(lvwFlaske, 0, 2, 1, 10);
        lvwFlaske.setPrefWidth(500);
        lvwFlaske.setPrefHeight(200);
        lvwFlaske.setStyle("-fx-font-family: 'monospace';" + "-fx-font-size: 11px;");

        ChangeListener<WhiskyFlaske> listener = (ov, oldItem, newItem) -> this.flaskeInformation();
        lvwFlaske.getSelectionModel().selectedItemProperty().addListener(listener);

        txaInfo.setPrefWidth(300);
        txaInfo.setPrefHeight(311.2);
        this.add(txaInfo,1,2, 1, 10);
        txaInfo.setStyle("-fx-font-family: 'monospace';" + "-fx-font-size: 11px;");

        updateControls();
    }

    private void selectedSearchBar() {
        String str = txfSearchBar.getText().trim();

        lvwFlaske.getItems().setAll(Controller.getWhiskyFlaskerSearch(str));
    }

    private void flaskeInformation() {
            WhiskyFlaske flaske = lvwFlaske.getSelectionModel().getSelectedItem();
            if (flaske != null) {

                txaInfo.setText("Type: " + flaske.getFad().getType());
                txaInfo.setText(txaInfo.getText() + "\n" + "Kapacitet: " + flaske.getFad().getKapacitet());
                txaInfo.setText(txaInfo.getText() + "\n" + "Oprindelse: " + flaske.getFad().getOprindelse());
                txaInfo.setText(txaInfo.getText() + "\n" + "Fadnummer: " + flaske.getFad().getNummer());
                txaInfo.setText(txaInfo.getText() + "\n" + "BatchID: " + flaske.getBatchID());

                for (Tap tap : flaske.getFad().getTaps()) {
                    txaInfo.setText(txaInfo.getText() + "\n" + "Startdato: " + tap.getDestillering().getStartDato());
                    txaInfo.setText(txaInfo.getText() + "\n" + "Slutdato: " + tap.getDestillering().getSlutDato());
                    txaInfo.setText(txaInfo.getText() + "\n" + "Maltbatch: " + tap.getDestillering().getMaltbatch());
                    txaInfo.setText(txaInfo.getText() + "\n" + "Kornsort: " + tap.getDestillering().getKornsort());
                    txaInfo.setText(txaInfo.getText() + "\n" + "Medarbejder: " + tap.getDestillering().getMedarbejder());
                    txaInfo.setText(txaInfo.getText() + "\n" + "Alkoholprocent: " + tap.getDestillering().getAlkoholProcent());
                    txaInfo.setText(txaInfo.getText() + "\n" + "Rygemateriale: " + tap.getDestillering().getRygemateriale());
                    txaInfo.setText(txaInfo.getText() + "\n" + "Kommentar: " + tap.getDestillering().getKommentar());
                }
            }
    }
    public void updateControls() {
        lvwFlaske.getItems().setAll(Controller.getWhiskyflasker());
    }
}
