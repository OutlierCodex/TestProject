package org.outliercodex.testproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class MainController {

    @FXML
    private Button btnClickMe;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnToDoList;

    @FXML
    private Button btnCalorieTracker;

    @FXML
    private Label label;

    @FXML
    protected void onClickMeButtonClicked(ActionEvent event) {
        label.setText("Button Clicked!");
    }
    @FXML
    protected void onHomeButtonClicked(ActionEvent event) {
        label.setText("Home Clicked!");
    }
    @FXML
    protected void onToDoListButtonClicked(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ToDoList.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 1920, 1080);

            // Get the current stage from the event source
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            currentStage.setScene(scene);
            currentStage.setTitle("To-Do List");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void onCalorieTrackerButtonClicked(ActionEvent event) {
        label.setText("Calorie Tracker Clicked!");
    }
}