package com.example.javaapp1;

import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Player extends ImageView {
    int flag;

    public Player(){
        super();
        Image myimage=new Image(getClass().getResourceAsStream("unnamed-removebg-preview.png"));
        this.flag=1;
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
}
