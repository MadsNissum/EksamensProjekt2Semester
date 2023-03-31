package gui;

import application.model.WhiskeyFlaske;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class FlaskePane extends GridPane {
    private ListView<WhiskeyFlaske> lvwFlaske = new ListView<>();
    private TextField txfSearchBar = new TextField();
    private Label lblError = new Label();

    public FlaskePane() {
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(20));
        this.setGridLinesVisible(false);

        this.add(new Label("Flasker"),0,0);
        this.add(new Label("Information"),1,1);

        this.add(txfSearchBar,0,1);
        txfSearchBar.setPromptText("🔍 Søg");

        txfSearchBar.textProperty().addListener((ov, oldItem, newItem) -> this.selectedSearchBar());

        this.add(lvwFlaske, 0, 2, 1, 10);
        lvwFlaske.setPrefWidth(200);
        lvwFlaske.setPrefHeight(200);

        TextArea txaInfo = new TextArea();
        txaInfo.setPrefSize(150,200);
        this.add(txaInfo,1,2);

        ChangeListener<WhiskeyFlaske> listener = (ov, oldItem, newItem) -> this.selectedFlaske();
        lvwFlaske.getSelectionModel().selectedItemProperty().addListener(listener);

        this.add(lblError, 1, 3);
        lblError.setStyle("-fx-text-fill: red");

    }

    private void selectedSearchBar() {

    }

    private void selectedFlaske() {
        updateControls();
    }

    public void updateControls() {
        lvwFlaske.getSelectionModel().getSelectedItem();
    }
}
