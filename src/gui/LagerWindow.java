package gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LagerWindow extends Stage {

    private TextField txfAdresse, txfkvm, txfKapacitet;
    public LagerWindow() {
        GridPane pane = new GridPane();

        initContent(pane);

        Scene scene = new Scene(pane);

        this.setScene(scene);
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

        Label lblKvm = new Label("Kvadratkilometer");
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
        //btnOK.setOnAction();

    }

}
