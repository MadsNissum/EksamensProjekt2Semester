package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Start extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Eksamens projekt");

        GridPane gridPane = new GridPane();

        initContent(gridPane);

        Scene scene = new Scene(gridPane);

        stage.setScene(scene);

        stage.show();
    }


    //Nodes for GUI


    private void initContent(GridPane gridPane) {
        //For testing
        gridPane.setGridLinesVisible(false);

        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);


        Pane pane = new Pane();

        FadWindow fadWindow = new FadWindow();

        fadWindow.showAndWait();


    }
}
