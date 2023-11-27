package com.example.javaapp1;

import java.io.*;

public class SaveLoadManager {
    private static final String SAVE_FILE_NAME = "savegame.dat";

    public static void saveGameState(GameState gameState) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(SAVE_FILE_NAME))) {
            outputStream.writeObject(gameState);
            System.out.println("Game state saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static GameState loadGameState() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(SAVE_FILE_NAME))) {
            GameState gameState = (GameState) inputStream.readObject();
            System.out.println("Game state loaded successfully.");
            return gameState;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
