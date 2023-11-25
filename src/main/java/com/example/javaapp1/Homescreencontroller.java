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
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

import static java.lang.Math.random;

public class Homescreencontroller {
    int current_block;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button mainbutton;
    @FXML
    private Rectangle myRectangle;
    @FXML
    private Pane rootPane;
    @FXML
    private Button pausebutton;
    private Timeline increaseHeightTimeline;
    private long pressStartTime;
    private int setonfinished=0;
    static Group g;
    Rectangle temp;
    private Player p;
    class Handlefell implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            p.felldown();
        }
    }
    class Afterrotation implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            TranslateTransition trans=new TranslateTransition();
            trans.setNode(g);
            trans.setDuration(Duration.seconds(2));

            BridgeandPlatform curr=(BridgeandPlatform) g.getChildren().get(current_block);
            BridgeandPlatform next=(BridgeandPlatform) g.getChildren().get(current_block+1);
            System.out.println(curr.getbridgelen());
            if((curr.getbridgelen()<next.xccord-(curr.width+curr.xccord)) || (curr.getbridgelen()>next.xccord+next.width-(curr.width+curr.xccord))){
                System.out.println("Fell down");
                trans.setByX(-curr.getbridgelen()-curr.width+39);
                trans.setOnFinished(new Handlefell());
            }else {
                trans.setByX(curr.xccord-next.xccord);
                trans.setOnFinished(new Aftertranslation());
            }
//            trans.setByX(curr.xccord-next.xccord);
//                TranslateTransition trans1=new TranslateTransition();
//                trans1.setNode(myRectangle);
//                trans1.setDuration(Duration.seconds(5));
//                trans1.setByX(-700);
//                trans1.play();

//            trans.setOnFinished(new Aftertranslation());
            trans.play();
        }
    }
    class Aftertranslation implements  EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            current_block++;
//            myRectangle=(Rectangle)g.getChildren().get(g.getChildren().size()-1);
        }
    }

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
    public static double gen_number(double lo,double hi){
        double random= random();
        double random_value=lo+random*(hi -lo);
        return random_value;
    }
    public static BridgeandPlatform gen_platform(int i){
        BridgeandPlatform prev=(BridgeandPlatform) g.getChildren().get(i);
        double x_coord_where=gen_number(prev.xccord+ prev.width+100,prev.xccord+prev.width +(450-prev.width)-50);
        double width_whre=gen_number(50,450-prev.width-(x_coord_where- prev.width-prev.xccord));
        BridgeandPlatform return_val=new BridgeandPlatform(x_coord_where,width_whre);
        return return_val;
    }
    @FXML
    public void initialize() {
//        Parent root= FXMLLoader.load(getClass().getResource("BackgroundGame.fxml"));
//        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
//        scene=new Scene(root);
        this.current_block=0;
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
//        rootPane.getChildren().add(new BridgeandPlatform());
//aa

//        rootPane.getChildren().add(myRectangle);
//        rootPane.getChildren().add(temp);
        this.p=new Player();
        BridgeandPlatform lvl1=new BridgeandPlatform(-2,122);
//        BridgeandPlatform lvl2=new BridgeandPlatform(313,73);
//        BridgeandPlatform lvl3=new BridgeandPlatform(563,70);
        g=new Group();
        g.getChildren().add(lvl1);
//        g.getChildren().add(lvl2);
//        g.getChildren().add(lvl3);
        for(int i=1;i<=1000;i++){
            g.getChildren().add(gen_platform(i-1));
        }
//        g.getChildren().add(myRectangle);
//        g.getChildren().add(temp);
//        g.getChildren().add(temp1);
//        g.getChildren().add(b2);
        System.out.println(rootPane.getChildren().size());
        rootPane.getChildren().add(3,g);
        rootPane.getChildren().add(p);
//        myRectangle=((BridgeandPlatform)g.getChildren().get(this.current_block)).bridge;
//        System.out.println(g.getChildren().size());
        System.out.println("Hey1");
        mainbutton.setOnMousePressed(this::handleMousePressed);
        mainbutton.setOnMouseReleased(this::handleMouseReleased);
//        createTimeline();
//        stage.setScene(scene);
//        stage.show();
//        createTimeline();
//        Group g=new Group(temp,myRectangle);
//        TranslateTransition trans=new TranslateTransition();
//        trans.setNode(temp);
//        trans.setToX(-700);
//        trans.setDuration(Duration.seconds(5));
//        trans.play();
    }
    private void handleMousePressed(MouseEvent event) {
        myRectangle=((BridgeandPlatform)g.getChildren().get(this.current_block)).bridge;
        createTimeline();
        System.out.println("Hey");
        // Record the start time when the left mouse button is pressed
//        createTimeline();
//        myRectangle=((BridgeandPlatform)g.getChildren().get(this.current_block)).bridge;
//        createTimeline();

        pressStartTime = System.currentTimeMillis();

        // Start the timeline for increasing height
        increaseHeightTimeline.play();
//        createTimeline();

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
//                createTimeline();
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
        rotate.setOnFinished(new Afterrotation());
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
//    @FXML
//    private void handlePauseButton(ActionEvent event) throws IOException {
//        // Load the PauseScreen.fxml file
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("PauseScreen.fxml"));
//        Parent pauseScreen = loader.load();
//
//        // Create a new stage for the pause screen
//        Stage pauseStage = new Stage();
//        pauseStage.setTitle("Pause Screen");
//        pauseStage.setScene(new Scene(pauseScreen));
//
//        // Set the stage to be a modal window (blocks interactions with the main window)
//        pauseStage.initOwner(((Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow()));
//        pauseStage.initModality(javafx.stage.Modality.APPLICATION_MODAL);
//
//        // Show the pause screen
//        pauseStage.showAndWait();
//    }

    @FXML
    private void handlePauseButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PauseScreen.fxml"));
        Parent pauseScreen = loader.load();

        PausescreenController pauseScreenController = loader.getController();
        pauseScreenController.setHomeScreenStage((Stage) pausebutton.getScene().getWindow()); // Pass the home screen's stage

        Stage pauseStage = new Stage();
        pauseStage.setTitle("Pause Screen");
        pauseStage.setScene(new Scene(pauseScreen));

        // Set the stage to be a modal window
        pauseStage.initModality(Modality.APPLICATION_MODAL);
        pauseStage.showAndWait();
    }
}
