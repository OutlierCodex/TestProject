package org.outliercodex.testproject;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class ToDoListController {

    @FXML private Button btnHome;
    @FXML private Button btnAdd;
    @FXML private Button btnClose;
    @FXML private ListView lvToDoList;
    @FXML private TextField tfNewTask;
    @FXML private ChoiceBox cbTimeFrame;

    ObservableList<String> tasks = FXCollections.observableArrayList();
    String st[] = {"Today", "This Week", "This Month", "Total"};
    ObservableList<String> timeFrames = FXCollections.observableArrayList(st);

    @FXML
    protected void initialize() {
        // Use a custom cell factory to add the "Complete" button
        lvToDoList.setCellFactory(listView -> new TaskCell());
        cbTimeFrame.setItems(timeFrames);
    }

    @FXML
    protected void onHomeButtonClicked(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Main.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 1920, 1080);

            // Get the current stage from the event source
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            currentStage.setScene(scene);
            currentStage.setTitle("Hello!");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onCloseButtonClicked(ActionEvent event) {
        // Get the current stage from the event source
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }

    @FXML
    protected void AddToList() {
        String task = tfNewTask.getText().trim();
        if (!task.isEmpty()) {
            tasks.add(task);
            lvToDoList.setItems(tasks);
            tfNewTask.clear();
        }
    }

    @FXML
    protected void onAddButtonClicked(ActionEvent event) {
        AddToList();
    }

    @FXML
    protected void onEnterKeyPressed(KeyEvent key) {
        try {
            if(key.getCode().equals(KeyCode.ENTER)) {
                AddToList();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // Custom ListCell to display a task with a "Complete" button
    private class TaskCell extends ListCell<String> {
        private final HBox content = new HBox();
        private final Label taskLabel = new Label();
        private final Button completeButton = new Button("Complete");
        private final Region spacer = new Region(); // Spacer to push the button right

        TaskCell() {
            content.getChildren().addAll(taskLabel, spacer, completeButton);
            content.setSpacing(10);

            // Allow the spacer to grow, pushing the button to the right
            HBox.setHgrow(spacer, Priority.ALWAYS);

            // Handle "Complete" button click
            completeButton.setOnAction(event -> Completed());
        }

        private void Completed() {
            tasks.remove(getItem());
            String Today = timeFrames.get(0);
            String ThisWeek = timeFrames.get(1);
            String ThisMonth = timeFrames.get(2);
            String Total = timeFrames.get(3);
        }

        @Override
        protected void updateItem(String task, boolean empty) {
            super.updateItem(task, empty);
            if (empty || task == null) {
                setGraphic(null);
            } else {
                taskLabel.setText(task);
                setGraphic(content);
            }
        }
    }
}
