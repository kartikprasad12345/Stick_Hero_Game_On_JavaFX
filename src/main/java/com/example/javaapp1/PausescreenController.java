package com.example.javaapp1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class PausescreenController {

    @FXML
    private void handleResumeButton() {
        // Implement the logic for the resume button
        System.out.println("Resume button clicked!");
    }

    @FXML
    private void handleExitButton() {
        // Implement the logic for the exit button
        System.out.println("Exit button clicked!");

        // Example: Show a confirmation dialog before exiting
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to exit?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            // Add code to exit the application
            System.exit(0);
        }
    }
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void switchToHomepage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Homepage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleSettingsButton() {
        // Implement the logic for the settings button
        System.out.println("Settings button clicked!");
    }

    // Add more methods for other buttons or controls as needed
}
