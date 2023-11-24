package com.example.javaapp1;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Homescreencontroller {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button mainbutton;
    @FXML
    private Button pause;
    @FXML
    private Rectangle myRectangle;
    @FXML
    private Pane rootPane;
    private Timeline increaseHeightTimeline;
    private long pressStartTime;
    private int setonfinished=0;
    Group g;
    Rectangle temp;
//    public void playbutton(ActionEvent e) throws Exception {
////        System.out.println("Play button");
//        Parent root= FXMLLoader.load(getClass().getResource("BackgroundGame.fxml"));
//        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
//        scene=new Scene(root);
//        myRectangle=new Rectangle(10,10, Color.BLACK);
//        rootPane.getChildren().add(myRectangle);
//        mainbutton.setOnMousePressed(this::handleMousePressed);
//        mainbutton.setOnMouseReleased(this::handleMouseReleased);
//        stage.setScene(scene);
//        stage.show();
//    }
    @FXML
    public void initialize(){
//        Parent root= FXMLLoader.load(getClass().getResource("BackgroundGame.fxml"));
//        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
//        scene=new Scene(root);
        myRectangle=new Rectangle(10,10, Color.BLACK);
        myRectangle.setX(110);
        myRectangle.setY(311);
        temp=new Rectangle(122,233,Color.BLACK);
        temp.setY(310);
        temp.setX(-2);
        Rectangle temp1=new Rectangle(73,233,Color.BLACK);
        temp1.setX(313);
        temp1.setY(310);
        Rectangle b2=new Rectangle(10,10,Color.BLACK);
        b2.setX(376);
        b2.setY(311);
//aa

//        rootPane.getChildren().add(myRectangle);
//        rootPane.getChildren().add(temp);
        g=new Group();
        g.getChildren().add(myRectangle);
        g.getChildren().add(temp);
        g.getChildren().add(temp1);
        g.getChildren().add(b2);
        rootPane.getChildren().add(g);
        System.out.println(g.getChildren().size());
        mainbutton.setOnMousePressed(this::handleMousePressed);
        mainbutton.setOnMouseReleased(this::handleMouseReleased);
//        stage.setScene(scene);
//        stage.show();
        createTimeline();
//        Group g=new Group(temp,myRectangle);
//        TranslateTransition trans=new TranslateTransition();
//        trans.setNode(temp);
//        trans.setToX(-700);
//        trans.setDuration(Duration.seconds(5));
//        trans.play();
    }
    private void handleMousePressed(MouseEvent event) {
        // Record the start time when the left mouse button is pressed
        pressStartTime = System.currentTimeMillis();

        // Start the timeline for increasing height
        increaseHeightTimeline.play();
    }

    private void handleMouseReleased(MouseEvent event) {
        // Stop the timeline when the left mouse button is released
        increaseHeightTimeline.stop();
        RotateTransition rotate = new RotateTransition();
        rotate.setNode(myRectangle);
        rotate.setDuration(Duration.millis(500));
//        rotate.setCycleCount(TranslateTransition.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setByAngle(90);
        rotate.setAxis(Rotate.Z_AXIS);
//        private int setonfinished=0;
        EventHandler<ActionEvent> eventHandler2 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Access the global variable within the event handler
//                setonfinished=1;
                myRectangle=(Rectangle)g.getChildren().get(g.getChildren().size()-1);
                createTimeline();
//                TranslateTransition trans=new TranslateTransition();
//                trans.setNode(g);
//                trans.setDuration(Duration.seconds(2));
//                trans.setByX(-315);
////                TranslateTransition trans1=new TranslateTransition();
////                trans1.setNode(myRectangle);
////                trans1.setDuration(Duration.seconds(5));
////                trans1.setByX(-700);
////                trans1.play();
//                trans.setOnFinished();
//                trans.play();

//                trans1.play();
            }
        };
        EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Access the global variable within the event handler
//                setonfinished=1;

                TranslateTransition trans=new TranslateTransition();
                trans.setNode(g);
                trans.setDuration(Duration.seconds(2));
                trans.setByX(-315);
//                TranslateTransition trans1=new TranslateTransition();
//                trans1.setNode(myRectangle);
//                trans1.setDuration(Duration.seconds(5));
//                trans1.setByX(-700);
//                trans1.play();
                trans.setOnFinished(eventHandler2);
                trans.play();

//                trans1.play();
            }
        };
////        rotate.setOnFinished(new EventHandler<ActionEvent>() {
////
////            @Override
////            public void handle(ActionEvent event) {
////                setonfinished=1;
////            }
////        });
        rotate.setOnFinished(eventHandler);
        rotate.play();
//        while(setonfinished==0){
//            if(setonfinished==1){
//                break;
//            }
//        }
//        ScaleTransition trans=new ScaleTransition();
//        trans.setNode(myRectangle);
//        trans.setDuration(Duration.seconds(5));
//        trans.setToX(-700);
//        trans.play();

    }
    @FXML
    private void handlePauseButton(ActionEvent event) throws IOException {
        // Load the PauseScreen.fxml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PauseScreen.fxml"));
        Parent pauseScreen = loader.load();

        // Create a new stage for the pause screen
        Stage pauseStage = new Stage();
        pauseStage.setTitle("Pause Screen");
        pauseStage.setScene(new Scene(pauseScreen));

        // Set the stage to be a modal window (blocks interactions with the main window)
        pauseStage.initOwner(((Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow()));
        pauseStage.initModality(javafx.stage.Modality.APPLICATION_MODAL);

        // Show the pause screen
        pauseStage.showAndWait();
    }
//    public void switchToPausescreen(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("Pausescreen.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }

    private void createTimeline() {
        // Create a Timeline for increasing height
        increaseHeightTimeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(myRectangle.scaleYProperty(), 1)),
                new KeyFrame(Duration.seconds(5), new KeyValue(myRectangle.scaleYProperty(), 100))
        );

        // Set cycle count to indefinite to keep increasing height as long as the timeline is playing
//        increaseHeightTimeline.setCycleCount(Timeline.INDEFINITE);

        // Set auto-reverse for a smooth animation when the mouse button is released
//        increaseHeightTimeline.setAutoReverse(false);
    }
}
