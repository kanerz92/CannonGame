package com.saggezza.CannonGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ShotClassTest {
    @Test
    public void testShotValuesAreComputedCorrectlyAndTransformedIntoCoordinates() {
//      Given: I need a shot
        IShot shot = new Shot();
//      When: I input a velocity of 5 and an angle of 75
        int velocity = 5;
        int angle = 75;
        double[] result;
        result = shot.computeCoordinates(velocity,angle);
//      Then: the inputted angle and velocity are converted into x,y co-ordinates
        double[] calculateResults = new double[2];
        calculateResults[0] = 1.2940952255126037;
        calculateResults[1] = 4.8296291314453415;
        assertArrayEquals(calculateResults,result);
    }
    @Test
    public void testShotValuesAreRoundedCorrectlyIntoIntArray() {
//      Given: I have a shot
        int velocity = 5;
        int angle = 75;
        Shot shot = new Shot();
//      When: The shot is created with velocity 5 and angle 75
        double[] result;
        result = shot.computeCoordinates(velocity,angle);
//      Then: it X and Y values are rounded to a whole number of type int
        IRoundingShotResult rounding = new RoundingShotResult();
        int[] actualRoundedResult;
        actualRoundedResult = rounding.roundDoubleValues(result);
        int[] roundedResult = new int[2];
        roundedResult[0] = 1;
        roundedResult[1] = 5;
        assertArrayEquals(roundedResult, actualRoundedResult);
    }
}
