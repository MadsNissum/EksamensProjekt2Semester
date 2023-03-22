package gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FadWindow extends Stage {
    public FadWindow() {
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


        pane.add(new Label("Test"), 0, 0);
    }

}
