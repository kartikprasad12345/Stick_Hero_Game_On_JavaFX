package com.example.javaapp1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomepageController {

    @FXML
    private Button playButton;

    @FXML
    private void playbutton() {
        // Implement the logic when the "Play" button is clicked
        System.out.println("Play button clicked!");
    }
}
