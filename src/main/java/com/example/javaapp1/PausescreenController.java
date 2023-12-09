package com.example.javaapp1;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;

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

    private void showMessage(String message) {
        // Display a message in a new Stage
        Stage messageStage = new Stage();
        messageStage.setTitle("Message");
        Text text = new Text(message);
        text.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        // Create a VBox to center the message
        VBox vbox = new VBox(text);
        vbox.setAlignment(Pos.CENTER);

        // Create a Scene with the VBox as the root
        Scene messageScene = new Scene(vbox, 200, 100);

        // Set the Scene to the Stage
        messageStage.setScene(messageScene);

        // Set the stage to be a modal window
        messageStage.initModality(Modality.APPLICATION_MODAL);

        // Display the Stage
        messageStage.show();

        // Close the Stage after a short delay (adjust the duration as needed)
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> messageStage.close());
        pause.play();
    }

    @FXML
    public void Deserialize() {
        try{
            ObjectInputStream f=new ObjectInputStream(new FileInputStream("ps1.txt"));
            PlayerStats pstemp=(PlayerStats) f.readObject();
            ObjectOutputStream f1=new ObjectOutputStream(new FileOutputStream("ps.txt"));
            f1.writeObject(pstemp);
            showMessage("Game saved successfully!");
        }catch(EOFException e){

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    private void handleResumeButton(ActionEvent event) {
        // Close the pause screen
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
