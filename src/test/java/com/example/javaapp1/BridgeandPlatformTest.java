package com.example.javaapp1;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BridgeandPlatformTest {

    @Test
    public void testConstructor() {
        double xCoord = 50.0;
        double width = 100.0;
        int index = 1;

        BridgeandPlatform bridgeAndPlatform = new BridgeandPlatform(xCoord, width, index);

        assertEquals(xCoord, bridgeAndPlatform.xccord);
        assertEquals(width, bridgeAndPlatform.width);
        assertEquals(index, bridgeAndPlatform.index);

        // Validate the properties of the bridge
        Rectangle bridge = bridgeAndPlatform.bridge;
        assertEquals(10.0, bridge.getWidth());
        assertEquals(10.0, bridge.getHeight());
        assertEquals(Color.BLACK, bridge.getFill());
        assertEquals(xCoord + width - 10, bridge.getX());
        assertEquals(311.0, bridge.getY());
    }

    @Test
    public void testSetCherry_var() {
        BridgeandPlatform bridgeAndPlatform = new BridgeandPlatform(0, 50, 1);
        Cherry cherry = new Cherry(0); // Assuming Cherry class has a constructor with coordinates

        bridgeAndPlatform.setCherry_var(cherry);

        assertTrue(bridgeAndPlatform.getChildren().contains(cherry));
    }

    @Test
    public void testRemoveCherry() {
        BridgeandPlatform bridgeAndPlatform = new BridgeandPlatform(0, 50, 1);
        Cherry cherry = new Cherry(0); // Assuming Cherry class has a constructor with coordinates

        bridgeAndPlatform.setCherry_var(cherry);
        cherry.cnt = 0; // Assuming cnt is initialized or modified within Cherry class logic

        bridgeAndPlatform.removecherry();

        assertFalse(bridgeAndPlatform.getChildren().contains(cherry));

    }

    @Test
    public void testGetBridgeLen() {
        BridgeandPlatform bridgeAndPlatform = new BridgeandPlatform(0, 50, 1);

        double bridgeLen = bridgeAndPlatform.getbridgelen();

        assertEquals(5.0, bridgeLen); // Assuming the initial scale of the bridge is 0.5
    }
}
