package com.example.javaapp1;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BridgeandPlatform extends Pane {
    Cherry cherry_var;
    int index;
    public double xccord;
    public double width;
    public Rectangle bridge;
    public Rectangle platform;
    public BridgeandPlatform(double xcoord,double width,int index){
        super();
        this.xccord=xcoord;
        this.width=width;
        this.index=index;
        bridge=new Rectangle(10,10, Color.BLACK);
        platform=new Rectangle(width,233,Color.BLACK);
        platform.setX(xcoord);
        platform.setY(310);
        bridge.setY(311);
        bridge.setX(xcoord+width-10);
        getChildren().addAll(platform,bridge);
    }
    public void setCherry_var(Cherry c){
        this.cherry_var=c;
        getChildren().add(c);
    }
    public void removecherry(){
        if(cherry_var.cnt==0){
            getChildren().remove(cherry_var);
        }
//        getChildren().remove(cherry_var);
    }

    public double getbridgelen(){
        return (bridge.getScaleY()*bridge.getHeight())/2;
    }
}