package gui;

import application.controller.Controller;
import javafx.application.Application;
import javafx.geometry.Pos;
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
        lagerPane.setAlignment(Pos.BASELINE_CENTER);

        lagerTab.setOnSelectionChanged(event -> lagerPane.selectedLager());

        FadPane fadPane = new FadPane();
        Tab fadTab = new Tab("Fad");
        fadTab.setContent(fadPane);
        tabPane.getTabs().add(fadTab);
        fadPane.setAlignment(Pos.BASELINE_CENTER);
        fadTab.setOnSelectionChanged(event -> fadPane.updateControls());

        DestilleringsPane destilleringsPane = new DestilleringsPane();
        Tab destilleringTab = new Tab("Destillering");
        destilleringTab.setContent(destilleringsPane);
        tabPane.getTabs().add(destilleringTab);
        destilleringsPane.setAlignment(Pos.BASELINE_CENTER);
        destilleringTab.setOnSelectionChanged(event -> {
            destilleringsPane.updateControls();
        });

        WhiskyPane whiskyPane = new WhiskyPane();
        Tab whiskyTab = new Tab("Whisky");
        whiskyTab.setContent(whiskyPane);
        tabPane.getTabs().add(whiskyTab);
        whiskyPane.setAlignment(Pos.BASELINE_CENTER);
        whiskyTab.setOnSelectionChanged(event -> whiskyPane.updateControls());

        FlaskePane flaskePane = new FlaskePane();
        Tab flaskeTab = new Tab("Flasker");
        flaskeTab.setContent(flaskePane);
        tabPane.getTabs().add(flaskeTab);
        flaskePane.setAlignment(Pos.BASELINE_CENTER);
        flaskeTab.setOnSelectionChanged(event -> flaskePane.updateControls());
    }

    private void setup() {
        Controller.initController();
    }
}
