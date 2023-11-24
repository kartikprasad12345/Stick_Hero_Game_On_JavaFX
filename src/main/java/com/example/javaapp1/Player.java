package com.example.javaapp1;

import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Player extends ImageView {
    public Player(){
        super();
        Image myimage=new Image(getClass().getResourceAsStream("unnamed-removebg-preview.png"));
        super.setImage(myimage);
        super.setX(-2);
        super.setY(277);
        super.setFitHeight(34);
        super.setFitWidth(39);
    }
    public void felldown(){
        TranslateTransition t=new TranslateTransition();
        t.setNode(this);
        t.setByY(535);
        t.setDuration(Duration.seconds(2));
        t.play();
    }
}
