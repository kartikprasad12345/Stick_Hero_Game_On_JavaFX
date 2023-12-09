package com.example.javaapp1;

import javafx.animation.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.random;

public class HomescreenController1 {
    int cherry_cnt;
    int cnt;
    Rectangle rec;
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
    @FXML
    private Label for_counter;
    private Timeline increaseHeightTimeline;
    private long pressStartTime;
    private int setonfinished=0;
    static Group g;
    Rectangle temp;
    Player p;
    @FXML
    Label score;

    class temp_thread extends Thread{
        @Override
        public void run(){
            while(true){
//                System.out.println("********"+g.getTranslateX());
//                if(g.getTranslateX()<=-150.00 && g.getTranslateX()>=-160.00 && p.getFlag()==-1){
                if(g.getTranslateX()-39<=-((BridgeandPlatform)g.getChildren().get(current_block)).cherry_var.xcoord && g.getTranslateX()>=-((BridgeandPlatform)g.getChildren().get(current_block)).cherry_var.xcoord-20 && p.getFlag()==-1 && ((BridgeandPlatform)g.getChildren().get(current_block)).cherry_var.cnt==0){
//                      System.out.println(((BridgeandPlatform)g.getChildren().get(current_block)).cherry_var.cnt);

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            if(((BridgeandPlatform)g.getChildren().get(current_block)).cherry_var.cnt==0){
                                p.player_cherry_cnt++;

                                for_counter.setText(Integer.toString(p.player_cherry_cnt));
//                                System.out.println(cherry_cnt);
//                                g.getChildren().remove(rec);
                                System.out.println("*"+p.player_cherry_cnt);
                                ((BridgeandPlatform)g.getChildren().get(current_block)).removecherry();
                                System.out.println("***"+((BridgeandPlatform)g.getChildren().get(current_block)).cherry_var.cnt);
                                ((BridgeandPlatform)g.getChildren().get(current_block)).cherry_var.cnt++;
                            }
//                                System.out.println("Got a cherry");
//                                cherry_cnt++;
////                                System.out.println(cherry_cnt);
////                                g.getChildren().remove(rec);
//                                System.out.println("*"+cherry_cnt);
//                                ((BridgeandPlatform)g.getChildren().get(current_block)).removecherry();
//                                System.out.println("***"+((BridgeandPlatform)g.getChildren().get(current_block)).cherry_var.cnt);
//                                ((BridgeandPlatform)g.getChildren().get(current_block)).cherry_var.cnt++;
//                                //update application thread
                        }
                    });
//                        g.getChildren().remove(rec);
//                        cnt++;
                }
//                    g.getChildren().remove(rec);
//                    System.out.println(g.getTranslateX()+"********************");

                try {
                    TimeUnit.MICROSECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
//                System.out.println(g.getTranslateX());
//                System.out.println(g.getTranslateX()<=-50.00 && g.getTranslateX()>=-90.00);
//                if(g.getTranslateX()<=-50.00 && g.getTranslateX()>=-90.00){
//                    System.out.println(g.getTranslateX()+"********************");
//                }
            }
        }
    }
    class HandleFellRevive implements EventHandler<ActionEvent>{
        HomescreenController1 temp;
        HandleFellRevive(HomescreenController1 temp){
            this.temp=temp;
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
        @Override
        public void handle(ActionEvent actionEvent) {
            p.player_cherry_cnt-=2;
            showMessage("Player Revived--> 2 cherries deducted");
            for_counter.setText(Integer.toString(p.player_cherry_cnt));
            double d=g.getTranslateX();
            TranslateTransition t1=new TranslateTransition(Duration.seconds(2));
            t1.setToX(-((BridgeandPlatform) g.getChildren().get(current_block+1)).xccord);
            t1.setNode(g);
            t1.play();
            t1.setOnFinished(new Aftertranslation(temp,0));
        }
    }
    class Handlefell implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            try {
                p.felldown();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    class Afterrotation implements EventHandler<ActionEvent>{
        HomescreenController1 outer;
        Afterrotation(HomescreenController1 outer){
            this.outer=outer;
        }

        @Override
        public void handle(ActionEvent actionEvent) {
            TranslateTransition trans=new TranslateTransition();
            trans.setNode(g);
            trans.setDuration(Duration.seconds(3));
//            mainbutton.setOnMousePressed((MouseEvent event) -> {
//                double currentX = g.getChildren().get(current_block).getTranslateX();
//                double currentY = g.getChildren().get(current_block).getTranslateY();
//                System.out.println("Current position: X=" + currentX + ", Y=" + currentY);
//            });
            mainbutton.setOnMouseClicked(this::Invertplayer);
            mainbutton.setOnMousePressed(this::Disablebutton1);
            mainbutton.setOnMouseReleased(this::Disablebutton1);
            BridgeandPlatform curr=(BridgeandPlatform) g.getChildren().get(current_block);
            BridgeandPlatform next=(BridgeandPlatform) g.getChildren().get(current_block+1);
            System.out.println(curr.getbridgelen());
            if((curr.getbridgelen()<next.xccord-(curr.width+curr.xccord)) || (curr.getbridgelen()>next.xccord+next.width-(curr.width+curr.xccord))){
                System.out.println("Fell down");
                trans.setByX(-curr.getbridgelen()-curr.width+39);
                if(p.player_cherry_cnt>=2){
//                    System.out.println("grrw34v4t3");
//                    TranslateTransition t=new TranslateTransition(Duration.seconds(2));
//                    t.setNode(g);
//                    double d=((BridgeandPlatform) g.getChildren().get(current_block)).xccord;
//                    t.setByX(50);
//                    t.play();
                    trans.setOnFinished(new HandleFellRevive(outer));



                }else{
                    trans.setOnFinished(new Handlefell());

                }
//                trans.setOnFinished(new Handlefell());
            }else {
                trans.setByX(curr.xccord-next.xccord);
                trans.setOnFinished(new Aftertranslation(outer,1));
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

        private void Disablebutton1(MouseEvent mouseEvent) {
        }

        private void Invertplayer(MouseEvent mouseEvent) {
            System.out.println(g.getTranslateX()+2);
//            p.toggleflag((BridgeandPlatform) g.getChildren().get(current_block),(BridgeandPlatform) g.getChildren().get(current_block+1));
            p.toggleflag((BridgeandPlatform) g.getChildren().get(current_block),(BridgeandPlatform) g.getChildren().get(current_block+1),g);
        }
    }
    class Aftertranslation implements  EventHandler<ActionEvent>{
        HomescreenController1 outer;
        int flag;
        Aftertranslation(HomescreenController1 outer,int flag){
            this.outer=outer;
            this.flag=flag;
        }


        @Override
        public void handle(ActionEvent actionEvent) {
            current_block++;
            System.out.println("Platform here:"+(g.getTranslateX()+2));
            if(flag==1){
                p.score+=10;
            }
//            p.score+=10;
            score.setText("Score:"+p.score);

            mainbutton.setOnMouseClicked((this::Disablebutton2));
            mainbutton.setOnMousePressed(outer::handleMousePressed);
            mainbutton.setOnMouseReleased(outer::handleMouseReleased);
//            myRectangle=(Rectangle)g.getChildren().get(g.getChildren().size()-1);
        }

        private void Disablebutton2(MouseEvent mouseEvent) {
        }
    }
//    class Invertplayer implements  EventHandler<ActionEvent>{
//
//        @Override
//        public void handle(ActionEvent actionEvent) {
//            p.toggleflag();
//        }
//    }

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
    public static BridgeandPlatform gen_platform(int i,int index){
        BridgeandPlatform prev=(BridgeandPlatform) g.getChildren().get(i);
        double x_coord_where=gen_number(prev.xccord+ prev.width+100,prev.xccord+prev.width +(450-prev.width)-50);
        double width_whre=gen_number(50,450-prev.width-(x_coord_where- prev.width-prev.xccord));
        BridgeandPlatform return_val=new BridgeandPlatform(x_coord_where,width_whre,index);
        return return_val;
    }
    @FXML
    public void initialize() throws IOException {
//        Parent root= FXMLLoader.load(getClass().getResource("BackgroundGame.fxml"));
//        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
//        scene=new Scene(root);
        System.out.println("Hey2");
        this.current_block=0;
        cnt=0;
//        cherry_cnt=0;
        for_counter.setFont(Font.font("Arial", FontWeight.BOLD, 36));
        score.setFont(Font.font("Arial", FontWeight.BOLD, 30));

//        for_counter.setFont();
//        for_counter.setText(Integer.toString(cherry_cnt));
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
        System.out.println("-------");
//        rootPane.getChildren().add(new BridgeandPlatform());
//aa

//        rootPane.getChildren().add(myRectangle);
//        rootPane.getChildren().add(temp);
        try{
            ObjectInputStream f=new ObjectInputStream(new FileInputStream("ps.txt"));
            PlayerStats pstemp=(PlayerStats) f.readObject();
            this.p=new Player(pstemp);
        }catch(EOFException e){
            this.p=new Player();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
//        this.p=new Player();
        score.setText("Score:"+p.score);

//        ObjectInputStream f=new ObjectInputStream(new FileInputStream("src/ps.txt"));


//        this.p=new Player();
        for_counter.setText(Integer.toString(p.player_cherry_cnt));
        rec=new Rectangle(20,20,Color.BLUE);
        rec.setX(190);
        rec.setY(300);
        BridgeandPlatform lvl1=new BridgeandPlatform(0,122,0);
//        BridgeandPlatform lvl2=new BridgeandPlatform(313,73,1);
//        BridgeandPlatform lvl3=new BridgeandPlatform(563,70,2);
        System.out.println("Hey3");
        g=new Group();
        g.getChildren().add(lvl1);
//        g.getChildren().add(lvl2);
//        g.getChildren().add(lvl3);
//        for(int k12=0;k12<2;k12++){
//            Cherry ctemp=new Cherry(gen_number(((BridgeandPlatform)g.getChildren().get(k12)).xccord+((BridgeandPlatform)g.getChildren().get(k12)).width+20,((BridgeandPlatform)g.getChildren().get(k12+1)).xccord)-20);
//            ((BridgeandPlatform)g.getChildren().get(k12)).setCherry_var(ctemp);
//        }
//        g.getChildren().add(rec);
        System.out.println("Hey4");
        for(int i=1;i<=1000;i++){
            g.getChildren().add(gen_platform(i-1,i));
        }
        System.out.println("Hey6");
        for(int k12=0;k12<50;k12++){
//            System.out.println("Hey8");
            Cherry ctemp=new Cherry(gen_number(((BridgeandPlatform)g.getChildren().get(k12)).xccord+((BridgeandPlatform)g.getChildren().get(k12)).width+20,((BridgeandPlatform)g.getChildren().get(k12+1)).xccord)-20);
            ((BridgeandPlatform)g.getChildren().get(k12)).setCherry_var(ctemp);
        }
        System.out.println("Hey7");
//        g.getChildren().add(myRectangle);
//        g.getChildren().add(temp);
//        g.getChildren().add(temp1);
//        g.getChildren().add(b2);
        System.out.println(rootPane.getChildren().size());
        System.out.println("Hey5");
        temp_thread t=new temp_thread();
        t.start();
        rootPane.getChildren().add(3,g);
        rootPane.getChildren().add(p);
//        myRectangle=((BridgeandPlatform)g.getChildren().get(this.current_block)).bridge;
//        System.out.println(g.getChildren().size());
        System.out.println("Hey1");
        System.out.println(g.getTranslateX()+2);
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
        rotate.setOnFinished(new Afterrotation(this));
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

    public void Serialize() throws IOException {
        PlayerStats pstemp1=new PlayerStats();
        pstemp1.score= p.score;
        pstemp1.cherry_cnt= p.player_cherry_cnt;
        ObjectOutputStream f=new ObjectOutputStream(new FileOutputStream("ps1.txt"));
        f.writeObject(pstemp1);
    }




    @FXML
    private void handlePauseButton(ActionEvent event) throws IOException {
        Serialize();
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
