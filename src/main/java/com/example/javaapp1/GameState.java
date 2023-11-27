package com.example.javaapp1;

import java.io.Serializable;

public class GameState implements Serializable {
    private static final long serialVersionUID = 1L;

    // Add properties of your game state
    private int currentBlock;

    // Constructors, getters, and setters
    public GameState(int currentBlock) {
        this.currentBlock = currentBlock;
    }

    public int getCurrentBlock() {
        return currentBlock;
    }

    public void setCurrentBlock(int currentBlock) {
        this.currentBlock = currentBlock;
    }
}
