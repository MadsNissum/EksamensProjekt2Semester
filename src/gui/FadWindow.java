package gui;

import application.model.Fad;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FadWindow extends Stage {
    public FadWindow(String title) {
        GridPane pane = new GridPane();

        initContent(pane);

        Scene scene = new Scene(pane);

        this.setScene(scene);
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
        pane.add(txfType,1,0);

        txfKapacitet = new TextField();
        pane.add(txfKapacitet,1,1);

        txfOprindelse = new TextField();
        pane.add(txfOprindelse,1,2);










    }

}
