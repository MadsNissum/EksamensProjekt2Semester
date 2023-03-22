package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class LagerPane extends GridPane {

    public LagerPane() {
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(20));

        this.add(new Label("Test111"), 0, 0);

    }

}
