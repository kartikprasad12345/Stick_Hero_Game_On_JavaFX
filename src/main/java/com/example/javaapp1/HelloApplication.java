package com.example.javaapp1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.nio.file.Paths;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //music();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("BackgroundGame.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 542, 451);
        primaryStage.setTitle("Stick Hero");
        Image icon=new Image("unnamed.png");
        primaryStage.getIcons().add(icon);
        primaryStage.setHeight(575);
        primaryStage.setWidth(464);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        // Play the startup sound


        primaryStage.show();

    }

    MediaPlayer mediaPlayer;

    public void music() {
        String s = "src/main/java/com/example/javaapp1/neon-gaming-128925.mp3";
        Media h = new Media(Paths.get(s).toUri().toString());
        mediaPlayer = new MediaPlayer(h);
        mediaPlayer.play();

    }



    public static void main(String[] args) {
        launch();
    }
}