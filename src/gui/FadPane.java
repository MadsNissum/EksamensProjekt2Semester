package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class FadPane extends GridPane {

    public FadPane() {
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(20));

        this.add(new Label("Test222"), 0, 0);

    }
}
