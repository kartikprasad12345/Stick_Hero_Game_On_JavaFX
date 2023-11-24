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
import java.util.List;

public class PausescreenController {
    private Stage stage;
    private Scene scene;
    private Parent root;
//    public void switchToHomepage(ActionEvent event) throws IOException {
//        root = FXMLLoader.load(getClass().getResource("Homepage.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }

    private Stage homeScreenStage;

    // This method is called from HomeScreenController to pass the home screen's stage
    public void setHomeScreenStage(Stage homeScreenStage) {
        this.homeScreenStage = homeScreenStage;
    }

    public void switchToHomepage(ActionEvent event) throws IOException {
        // Close both the pause screen stage and the home screen stage
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();

        if (homeScreenStage != null) {
            homeScreenStage.close(); // Close the home screen stage
        }

        // Load the homepage scene
        Parent homepageRoot = FXMLLoader.load(getClass().getResource("Homepage.fxml"));

        // Create a new stage for the homepage
        Stage homepageStage = new Stage();
        homepageStage.setTitle("Homepage");
        homepageStage.setScene(new Scene(homepageRoot));

        // Set the stage to be a normal window
        homepageStage.show();
    }

    @FXML
    private void handleResumeButton(ActionEvent event) {
        // Close the pause screen
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
