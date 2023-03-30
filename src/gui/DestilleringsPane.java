package gui;

import application.controller.Controller;
import application.model.Destillering;
import application.model.Fad;
import application.model.Tap;
import application.utility.Utility;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class DestilleringsPane extends GridPane {
    private Fad fad;
    private final ListView<Destillering> lvwDestillering = new ListView<>();
    private final ListView<Tap> lvwTap = new ListView<>();
    private final TextField txfStartDato = new TextField();
    private final TextField txfSlutDato = new TextField();
    private final TextField txfMaltBatch = new TextField();
    private final TextField txfKornSort = new TextField();
    private final TextField txfMedarbejder = new TextField();
    private final TextField txfLiter = new TextField();
    private final TextField txfAlkoholProcent = new TextField();
    private final TextField txfRygeMateriale = new TextField();
    private final TextField txfKommentar = new TextField();

    public DestilleringsPane() {
        // Padding and gap
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(20));
        this.setGridLinesVisible(false);

        // Labels
        this.add(new Label("Destillering"), 0, 0);
        this.add(new Label("Tappe"), 3, 0);

        // Destillering listview
        this.add(lvwDestillering, 0, 1, 1, 10);
        lvwDestillering.setPrefWidth(200);
        lvwDestillering.setPrefHeight(150);
        updateControls();
        ChangeListener<Destillering> listener = (ov, oldItem, newItem) -> this.selectDestillering();
        lvwDestillering.getSelectionModel().selectedItemProperty().addListener(listener);

        // Tap listview
        this.add(lvwTap, 3, 1, 1, 10);
        lvwTap.setPrefWidth(175);
        lvwTap.setPrefHeight(150);
        //ChangeListener<Tap> listener1 = (ov, oldItem, newItem) -> this.selectedTap();
        //lvwTap.getSelectionModel().selectedItemProperty().addListener(listener1);

        // Text felter

        this.add(new Label("Startdato: "), 1, 1);
        this.add(txfStartDato, 2, 1);
        txfStartDato.setEditable(false);

        this.add(new Label("Slutdato: "), 1, 2);
        this.add(txfSlutDato, 2, 2);
        txfSlutDato.setEditable(false);

        this.add(new Label("Maltbatch: "), 1, 3);
        this.add(txfMaltBatch, 2, 3);
        txfMaltBatch.setEditable(false);

        this.add(new Label("Kortsort: "), 1, 4);
        this.add(txfKornSort, 2, 4);
        txfKornSort.setEditable(false);

        this.add(new Label("Medarbejder: "), 1, 5);
        this.add(txfMedarbejder, 2, 5);
        txfMedarbejder.setEditable(false);

        this.add(new Label("Mængde: "), 1, 6);
        this.add(txfLiter, 2, 6);
        txfLiter.setEditable(false);

        this.add(new Label("Alkoholprocent: "), 1, 7);
        this.add(txfAlkoholProcent, 2, 7);
        txfAlkoholProcent.setEditable(false);

        this.add(new Label("Rygemateriale: "), 1, 8);
        this.add(txfRygeMateriale, 2, 8);
        txfRygeMateriale.setEditable(false);

        this.add(new Label("Kommentar: "), 1, 9);
        this.add(txfKommentar, 2, 9);
        txfKommentar.setEditable(false);

        // Opret knap
        Button btnOpret = new Button("Opret");
        this.add(btnOpret, 4, 1);
        btnOpret.setPrefWidth(75);
        btnOpret.setOnAction(actionEvent -> this.opret());

        // Opdater knap
        Button btnOpdater = new Button("Opdater");
        this.add(btnOpdater, 4, 2);
        btnOpdater.setPrefWidth(75);
        btnOpdater.setOnAction(actionEvent -> this.opdater());

        // Slet knap
        Button btnDelete = new Button("Slet");
        this.add(btnDelete, 4, 3);
        btnDelete.setPrefWidth(75);
        btnDelete.setOnAction(actionEvent -> this.slet());

        //Aftap knap
        Button btnTap = new Button("Aftap");
        this.add(btnTap, 4, 4);
        btnTap.setPrefWidth(75);
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
                clear();
                lvwDestillering.getItems().setAll(Controller.getDestilleringer());
                updateControls();
            }
        }
    }

    private void aftap() {

        Destillering destillering = lvwDestillering.getSelectionModel().getSelectedItem();

        if (destillering != null) {
            DestilleringsTapWindow destilleringsTapWindow = new DestilleringsTapWindow("Aftap destillat", destillering, fad);
            destilleringsTapWindow.showAndWait();

            updateControls();
            updateTapControls();
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
            txfLiter.setText("" + destillering.getTotalLiter());
            txfAlkoholProcent.setText("" + destillering.getAlkoholProcent());
            txfRygeMateriale.setText("" + destillering.getRygemateriale());
            txfKommentar.setText(destillering.getKommentar());

        }
    }

    private void clear() {
        txfStartDato.clear();
        txfSlutDato.clear();
        txfMaltBatch.clear();
        txfKornSort.clear();
        txfMedarbejder.clear();
        txfAlkoholProcent.clear();
        txfRygeMateriale.clear();
        txfKommentar.clear();
        txfLiter.clear();
    }



    private void updateControls() {
        lvwDestillering.getItems().setAll(Controller.getDestilleringer());
    }

    private void updateTapControls() {
        lvwTap.getItems().setAll(Controller.getTaps());
    }

}
