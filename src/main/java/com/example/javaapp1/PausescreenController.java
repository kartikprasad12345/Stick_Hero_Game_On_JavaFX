package com.example.javaapp1;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

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

    @FXML
    private void handleSettingsButton() {
        // Implement the logic for the settings button
        System.out.println("Settings button clicked!");
    }

    // Add more methods for other buttons or controls as needed
}
