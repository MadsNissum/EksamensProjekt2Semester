package gui;

import application.controller.Controller;
import application.model.Destillering;
import application.utility.Number;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;

public class DestilleringsWindow extends Stage {

    private final Destillering destillering;

    public DestilleringsWindow(String title, Destillering destillering) {
        GridPane pane = new GridPane();
        this.destillering = destillering;

        initContent(pane);

        this.setTitle(title);

        Scene scene = new Scene(pane);

        this.setScene(scene);
        pane.setPrefWidth(400);

    }

    public DestilleringsWindow(String title) {
        this(title, null);
    }

    private TextField txfMaltBatch, txfKornSort,
            txfMedarbejder, txfMængde, txfAlkoholProcent, txfRygeMateriale, txfKommentar;
    private Label lblError;
    private DatePicker dpStartDato, dpSlutDato;
    private void initContent(GridPane pane) {

        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        pane.add(new Label("Startdato"), 0, 0);
        pane.add(new Label("Slutdato"), 0, 1);
        pane.add(new Label("Maltbatch"), 0, 2);
        pane.add(new Label("Kornsort"), 0, 3);
        pane.add(new Label("Medarbejder"), 0, 4);
        pane.add(new Label("Mængde"), 0, 5);
        pane.add(new Label("Alkoholprocent"), 0, 6);
        pane.add(new Label("Rygemateriale"), 0, 7);
        pane.add(new Label("Kommentar"), 0, 8);

        dpStartDato = new DatePicker();
        pane.add(dpStartDato, 1, 0);

        dpSlutDato = new DatePicker();
        pane.add(dpSlutDato, 1, 1);

        txfMaltBatch = new TextField();
        pane.add(txfMaltBatch, 1, 2);

        txfKornSort = new TextField();
        pane.add(txfKornSort, 1, 3);

        txfMedarbejder = new TextField();
        pane.add(txfMedarbejder, 1, 4);

        txfMængde = new TextField();
        pane.add(txfMængde, 1, 5);

        txfAlkoholProcent = new TextField();
        pane.add(txfAlkoholProcent, 1, 6);

        txfRygeMateriale = new TextField();
        pane.add(txfRygeMateriale, 1, 7);

        txfKommentar = new TextField();
        pane.add(txfKommentar, 1, 8);

        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 1, 9);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK, 2, 9);
        btnOK.setOnAction(event -> this.okAction());

        lblError = new Label();
        pane.add(lblError, 1, 10);
        lblError.setStyle("-fx-text-fill: red");

        this.initControls();
    }

    private void initControls() {
        if (destillering != null) {
            dpStartDato.setValue(destillering.getStartDato());
            dpSlutDato.setValue(destillering.getSlutDato());
            txfMaltBatch.setText(destillering.getMaltbatch());
            txfKornSort.setText(destillering.getKornsort());
            txfMedarbejder.setText(destillering.getMedarbejder());
            txfMængde.setText("" + destillering.getKapacitet());
            txfAlkoholProcent.setText("" + destillering.getAlkoholProcent());
            txfRygeMateriale.setText((destillering.getRygemateriale()));
            txfKommentar.setText(destillering.getKommentar());
        } else {
            dpStartDato.setValue(null);
            dpSlutDato.setValue(null);
            txfMaltBatch.clear();
            txfKornSort.clear();
            txfMedarbejder.clear();
            txfAlkoholProcent.clear();
            txfRygeMateriale.clear();
            txfKommentar.clear();
            txfMængde.clear();
        }
    }

    private void cancelAction() {
        this.hide();
    }

    private void okAction() {
        LocalDate startDato = dpStartDato.getValue();
        LocalDate slutDato = dpSlutDato.getValue();
        String maltBatch = txfMaltBatch.getText().trim();
        String kornSort = txfKornSort.getText().trim();
        String medarbejder = txfMedarbejder.getText().trim();
        double mængde = Number.checkerDouble(txfMængde.getText().trim());
        double alkoholProcent = Number.checkerDouble(txfAlkoholProcent.getText().trim());
        String rygeMateriale = txfRygeMateriale.getText().trim();
        String kommentar = txfKommentar.getText().trim();
        if (startDato == null || slutDato == null) {
            lblError.setText("Indtast dato");
        } else if (startDato.isAfter(slutDato)) {
            lblError.setText("Indtast korrekt slutdato");
        } else if(maltBatch.isEmpty()) {
                lblError.setText("Indtast maltbatch");
        } else if(kornSort.isEmpty()) {
            lblError.setText("Indtast kornsort");
        } else if (medarbejder.isEmpty()) {
            lblError.setText("Indtast medarbejder");
        } else if (mængde < 0) {
            lblError.setText("Indtast mængde");
        } else if (alkoholProcent < 0) {
            lblError.setText("Indtast alkoholprocent");
        } else if (rygeMateriale.isEmpty()) {
            lblError.setText("Indtast rygemateriale");
        } else if (kommentar.isEmpty()) {
            lblError.setText("Indtast kommentar");
                } else {
                    if (destillering != null) {
                        Controller.updateDestillering(destillering, startDato, slutDato, maltBatch, kornSort, medarbejder, mængde, alkoholProcent, rygeMateriale, kommentar);
                    } else {
                        Controller.createDestillering(startDato,slutDato,maltBatch,kornSort,medarbejder,mængde,alkoholProcent,rygeMateriale,kommentar);
                    }
                    this.hide();
                }
            }
        }

