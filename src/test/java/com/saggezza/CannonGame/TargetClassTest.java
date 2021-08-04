package com.saggezza.CannonGame;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class TargetClassTest {

    @Test
    public void testTargetCreatedWithRandomXYValues() {
//      Given: I need a target
        ITarget target = new Target();
//      When: the target is created
        int[] result = target.getRandomXY();
//      Then: it is created with random X/Y values
        int size = result.length;
        assertEquals(2, size);
        System.out.println(Arrays.toString(result));
    }
}


