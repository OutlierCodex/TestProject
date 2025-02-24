package org.outliercodex.testproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class TestController {

    @FXML
    private Button btnClickMe;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnToDoList;

    @FXML
    private Label label;

    @FXML
    protected void onClickMeClicked(ActionEvent event) {
        label.setText("Button Clicked!");
    }
    @FXML
    protected void onHomeButtonClicked(ActionEvent event) {
        label.setText("Home Clicked!");
    }
    @FXML
    protected void onToDoListButtonClicked(ActionEvent event) {
        label.setText("To-Do List Clicked!");
    }
}