package com.example.javaapp1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HomescreencontrollerTest {
    Homescreencontroller YourClassName = new Homescreencontroller();
    @Test
    public void testGenNumberWithinRange() {
        double lo = 0.0;
        double hi = 10.0;


        double result = YourClassName.gen_number(lo, hi);

        assertTrue(result >= lo && result <= hi, "Generated number is within the specified range");
    }

    @Test
    public void testGenNumberWithSameBounds() {
        double lo = 5.0;
        double hi = 5.0;

        double result = YourClassName.gen_number(lo, hi);

        assertEquals(lo, result, "Generated number should be equal to the lower bound");
    }

}