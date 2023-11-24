package com.example.javaapp1;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BridgeandPlatform extends Pane {
    public double xccord;
    public double width;
    public Rectangle bridge;
    public Rectangle platform;
    public BridgeandPlatform(double xcoord,double width){
        super();
        this.xccord=xcoord;
        this.width=width;
        bridge=new Rectangle(10,10, Color.BLACK);
        platform=new Rectangle(width,233,Color.BLACK);
        platform.setX(xcoord);
        platform.setY(310);
        bridge.setY(311);
        bridge.setX(xcoord+width-10);
        getChildren().addAll(platform,bridge);
    }
    public double getbridgelen(){
        return (bridge.getScaleY()*bridge.getHeight())/2;
    }
}