package gui;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class WhiskyPane extends GridPane {


    public WhiskyPane() {
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(20));
        this.setGridLinesVisible(false);
    }
}
