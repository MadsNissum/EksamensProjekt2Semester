package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Start extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Eksamens projekt");

        BorderPane borderPane = new BorderPane();

        initContent(borderPane);

        Scene scene = new Scene(borderPane);

        stage.setScene(scene);

        stage.show();
    }


    //Nodes for GUI


    private void initContent(BorderPane borderPane) {
        TabPane tabPane = new TabPane();
        initTabPane(tabPane);
        borderPane.setCenter(tabPane);
    }

    private void initTabPane(TabPane tabPane) {
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab lagerTab = new Tab("Lager");
        lagerTab.setContent(new LagerPane());
        tabPane.getTabs().add(lagerTab);

        Tab fadTab = new Tab("Fad");
        fadTab.setContent(new FadPane());
        tabPane.getTabs().add(fadTab);



    }
}
