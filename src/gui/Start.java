package gui;

import application.controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
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
        setup();

        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        LagerPane lagerPane = new LagerPane();
        Tab lagerTab = new Tab("Lager");
        lagerTab.setContent(lagerPane);
        tabPane.getTabs().add(lagerTab);

        lagerTab.setOnSelectionChanged(event -> lagerPane.selectedLager());

        Tab fadTab = new Tab("Fad");
        fadTab.setContent(new FadPane());
        tabPane.getTabs().add(fadTab);

        Tab destilleringTab = new Tab("Destillering");
        destilleringTab.setContent(new DestilleringsPane());
        tabPane.getTabs().add(destilleringTab);
    }

    private void setup() {
        Controller.initController();
    }
}
