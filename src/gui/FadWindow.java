package gui;

import application.controller.Controller;
import application.model.Fad;
import application.model.Lager;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FadWindow extends Stage {
    private Fad fad;
    private Lager lager;
    public FadWindow(String title, Fad fad) {
        GridPane pane = new GridPane();

        initContent(pane);

        Scene scene = new Scene(pane);

        this.setScene(scene);

        this.fad = fad;
    }
    public FadWindow(String title) {
        this(title, null);
    }

    private TextField txfType, txfKapacitet, txfOprindelse;
    private Label lblError;

    private void initContent(GridPane pane) {
        //For testing
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        pane.add(new Label("Type"), 0, 0);
        pane.add(new Label("Kapacitet"), 0, 1);
        pane.add(new Label("Oprindelse"), 0, 2);

        txfType = new TextField();
        pane.add(txfType, 1, 0);

        txfKapacitet = new TextField();
        pane.add(txfKapacitet, 1, 1);

        txfOprindelse = new TextField();
        pane.add(txfOprindelse, 1, 2);

        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 1, 3);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK, 2, 3);
        btnOK.setOnAction(event -> this.okAction());


        lblError = new Label();
        pane.add(lblError, 1, 4);
        lblError.setStyle("-fx-text-fill: red");

        this.initControls();
    }

    private void initControls() {
        if (fad != null) {
            txfType.setText(fad.getType());
            txfKapacitet.setText("" + fad.getKapacitet());
            txfOprindelse.setText(fad.getOprindelse());
        } else {
            txfType.clear();
            txfKapacitet.clear();
            txfOprindelse.clear();
        }
    }


    private void cancelAction() {
        this.hide();
    }

    private void okAction() {
        String type = txfType.getText().trim();
        String oprindelse = txfOprindelse.getText().trim();
        if (type.length() == 0) {
            lblError.setText("Indtast type");
        } else {
            double kapacitet = -1;
            try {
                kapacitet = Double.parseDouble(txfKapacitet.getText().trim());
            } catch (NumberFormatException ex) {
                // do nothing
            }
            if (kapacitet < 0) {
                lblError.setText("Indtast et positiv talt i kapacitet");
            } else {
                if (oprindelse.length() == 0) {
                    lblError.setText("Indtast oprindelse");
                } else {
                if (fad != null) {
                    Controller.updateFad(fad, type, kapacitet,oprindelse);
                } else {
                    Controller.createFad(type,kapacitet,oprindelse);
                }
                this.hide();
            }
        }
    }

    }

}
