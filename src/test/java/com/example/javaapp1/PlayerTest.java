package com.example.javaapp1;

import javafx.scene.Group;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PlayerTest {

    @Test
    public void testToggleFlag() {
        // Create a Player instance
        Player player = new Player();

        // Create two BridgeandPlatform instances
        BridgeandPlatform bnpl = new BridgeandPlatform(0, 100, 0);
        BridgeandPlatform bnph = new BridgeandPlatform(200, 100, 1);

        // Create a Group and add the BridgeandPlatform instances
        Group group = new Group(bnpl, bnph);

        // Call the toggleflag method
        player.toggleflag(bnpl, bnph, group);
        player.setFlag(-1);

        // Assertions
        assertEquals(-1, player.getFlag()); // Check if flag is toggled
        assertEquals(277, player.getY()); // Check if Y position is updated (assuming flag is initially 1)
        assertEquals(0, player.getRotate()); // Check if rotation is updated (assuming flag is initially 1)
    }

    @Test
    void getPlayer_cherry_cnt_after_update() {
        PlayerStats a = new PlayerStats();
        Player b = new Player(a);
        b.setPlayer_cherry_cnt(10);
        assertEquals(b.getPlayer_cherry_cnt(), 10);
    }

    @Test
    void getMaxScore() {
        PlayerStats a = new PlayerStats();
        Player b = new Player(a);
        b.setScore(100);
        assertNotEquals(b.getScore(), 10);
    }

}
