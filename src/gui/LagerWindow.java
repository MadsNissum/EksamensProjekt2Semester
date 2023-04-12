package gui;

import application.controller.Controller;
import application.model.Lager;
import application.utility.Number;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LagerWindow extends Stage {

    private Lager lager;
    private Label lblError;
    private TextField txfAdresse, txfkvm, txfKapacitet;
    public LagerWindow(String str, Lager lager) {
        this.lager = lager;
        this.setTitle(str);
        GridPane pane = new GridPane();

        initContent(pane);

        Scene scene = new Scene(pane);

        this.setScene(scene);
    }
    public LagerWindow(String str) {
        this(str, null);
    }

    private void initContent(GridPane pane) {
        //For testing
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);


        Label lblAdresse = new Label("Adresse");
        pane.add(lblAdresse, 0, 0);

        txfAdresse = new TextField();
        pane.add(txfAdresse, 0, 1);
        txfAdresse.setEditable(true);

        Label lblKvm = new Label("Kvadratmeter");
        pane.add(lblKvm, 0, 2);

        txfkvm = new TextField();
        pane.add(txfkvm, 0, 3);
        txfkvm.setEditable(true);

        Label lblKapacitet = new Label("Kapacitet");
        pane.add(lblKapacitet, 0, 4);

        txfKapacitet = new TextField();
        pane.add(txfKapacitet, 0, 5);
        txfKapacitet.setEditable(true);

        Button btnOK = new Button("OK");
        pane.add(btnOK, 0, 6);
        btnOK.setOnAction(event -> this.okAction());
        
        
        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 1, 6);
        btnCancel.setOnAction(event -> this.cancelAction());

        lblError = new Label();
        pane.add(lblError, 0, 7);
        lblError.setStyle("-fx-text-fill: red");

        this.initControls();

    }

    private void cancelAction() { hide();
    }

    private void initControls() {
        if (lager != null) {
            txfAdresse.setText(lager.getAdresse());
            txfkvm.setText("" + lager.getKvm());
            txfKapacitet.setText("" + lager.getKapacitet());
        } else {
            txfAdresse.clear();
            txfkvm.clear();
            txfKapacitet.clear();
        }
    }

    private void okAction() {
        String adresse = txfAdresse.getText().trim();
        double kvm = Number.checkerDouble(txfkvm.getText().trim());
        int kapacitet = Number.checkerInt(txfKapacitet.getText().trim());


        if (adresse.length() == 0) {
            lblError.setText("Intast en Adresse");
        } else if (kvm < 0) {
            lblError.setText("Indtast et tal i Kvm");
        } else if (kapacitet < 0) {
            lblError.setText("Intast et tal i Kapacitet");
        } else {
            if (lager != null) {
                Controller.updateLager(lager, adresse, kvm, kapacitet);
            } else {
                Controller.createLager(adresse, kvm, kapacitet);
            }
            hide();
        }

    }


}
