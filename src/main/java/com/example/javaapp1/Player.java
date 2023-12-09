package com.example.javaapp1;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Player extends ImageView {
    private int bridge_no;
    private int flag;
    int player_cherry_cnt;
    int score;

    public Player(){
        super();
        Image myimage=new Image(getClass().getResourceAsStream("unnamed-removebg-preview.png"));
        this.flag=1;
        super.setImage(myimage);
        super.setX(-2);
        super.setY(277);
        super.setFitHeight(34);
        super.setFitWidth(39);
        player_cherry_cnt=0;
        bridge_no=0;
        score=0;
    }
    public Player(PlayerStats ps){
        super();
        Image myimage=new Image(getClass().getResourceAsStream("unnamed-removebg-preview.png"));
        this.flag=1;
        super.setImage(myimage);
        super.setX(-2);
        super.setY(277);
        super.setFitHeight(34);
        super.setFitWidth(39);
        player_cherry_cnt=ps.cherry_cnt;
        bridge_no=0;
        score=ps.score;
    }

    public void felldown() throws IOException {
//        if (player_cherry_cnt >= 2) {
//            int a =player_cherry_cnt - 2;
//            player_cherry_cnt-=2;
//            PlayerStats pstemp1=new PlayerStats();
//            pstemp1.score=score;
//            pstemp1.cherry_cnt=player_cherry_cnt;
//            ObjectOutputStream f=new ObjectOutputStream(new FileOutputStream("C:\\Users\\ayush\\Desktop\\javaapp1\\src\\main\\java\\com\\example\\javaapp1\\ps.txt"));
//            f.writeObject(pstemp1);
//            // Display a message "Player Revived"
//            showMessage("Player Revived");
//
//            // Display the BackgroundGame scene
//           try {
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("BackgroundGame.fxml"));
//                Parent backgroundGame = loader.load();
//               // Access the controller of the BackgroundGame.fxml
////               Homescreencontroller backgroundGameController =new Homescreencontroller(a);
//
//
//               // Set the cherry count to the desired value
////               backgroundGameController.p.player_cherry_cnt = a;
//
//                // Create a new Scene with the loaded FXML as the root
//                Scene backgroundGameScene = new Scene(backgroundGame);
//
//                // Get the Stage from the current ImageView
//                Stage stage = (Stage) this.getScene().getWindow();
//
//                // Set the new Scene to the Stage
//                stage.setScene(backgroundGameScene);
//                stage.show();
////               backgroundGameController.p.player_cherry_cnt = a;
//
//
//           } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } else {
            // If cherries are less than 2, let the player fall
            TranslateTransition t = new TranslateTransition();
            t.setNode(this);
            t.setByY(535);
            t.setDuration(Duration.seconds(1));

            // Attach an event handler to execute after the TranslateTransition finishes
            t.setOnFinished(event -> showGameOverScene());
            t.play();
        }

    public int getBridge_no() {
        return bridge_no;
    }

    public void setBridge_no(int bridge_no) {
        this.bridge_no = bridge_no;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getPlayer_cherry_cnt() {
        return player_cherry_cnt;
    }

    public void setPlayer_cherry_cnt(int player_cherry_cnt) {
        this.player_cherry_cnt = player_cherry_cnt;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


//    private void showRevivedScene() {
//        try {
//            // Load the FXML file for the revived scene
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("revived_scene.fxml"));
//            Parent root = loader.load();
//
//            // Create a new Scene with the loaded FXML as the root
//            Scene revivedScene = new Scene(root);
//
//            // Get the Stage from the current ImageView
//            Stage stage = (Stage) this.getScene().getWindow();
//
//            // Set the new Scene to the Stage
//            stage.setScene(revivedScene);
//            stage.show();
//
//            // Pause for 1 second (adjust the duration as needed)
//            PauseTransition pause = new PauseTransition(Duration.seconds(1));
//            pause.setOnFinished(event -> {
//                // Continue with the game logic after the delay
//                showGameScene();
//            });
//            pause.play();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        }


    void showGameOverScene() {
        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("game_over.fxml"));
            Parent root = loader.load();

            // Create a new Scene with the loaded FXML as the root
            Scene gameOverScene = new Scene(root);

            // Get the Stage from the current ImageView
            Stage stage = (Stage) this.getScene().getWindow();

            // Set the new Scene to the Stage
            stage.setScene(gameOverScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void toggleflag(BridgeandPlatform bnpl, BridgeandPlatform bnph, Group g){
        if((bnpl.platform.getX()+bnpl.platform.getWidth()<-g.getTranslateX()) &&(bnph.platform.getX()>g.getTranslateX()) ){
            if(flag==1){
                flag=-1;
                System.out.println("Current flag:"+flag);
                super.setY(311);
                super.setRotationAxis(Rotate.Z_AXIS);
                super.setRotate(180);
            }else{
                flag=1;
                System.out.println("Current flag:"+flag);
                super.setY(277);
                super.setRotationAxis(Rotate.Z_AXIS);
                super.setRotate(0);
            }
        }

//        System.out.println(bnpl.platform.getX());

//        System.out.println(bnpl.platform.getTranslateX());

//        System.out.println("Flag changed");



//        if(flag==1){
//            if((bnpl.xccord+bnpl.width<-2) &&(bnph.xccord>-2+39) ){
//                flag=-1;
//                System.out.println("Current flag:"+flag);
//                super.setY(311);
//                super.setRotationAxis(Rotate.Z_AXIS);
//                super.setRotate(180);
//            }
////            flag=-1;
////            System.out.println("Current flag:"+flag);
////            super.setY(311);
////            super.setRotationAxis(Rotate.Z_AXIS);
////            super.setRotate(180);
//
//
//
//        }else{
//            flag=1;
//            System.out.println("Current flag:"+flag);
//            super.setY(277);
//            super.setRotationAxis(Rotate.Z_AXIS);
//            super.setRotate(0);
//        }
    }
    public int getFlag(){
        return flag;
    }
}
