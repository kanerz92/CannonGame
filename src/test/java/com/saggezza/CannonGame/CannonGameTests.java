package com.saggezza.CannonGame;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


public class CannonGameTests {
    /* draw finite state machine all pieces and how they tie together
    stories for input and output
    Write Flow class
    Pair Programming
    */


/*
Given: I need a target
When: I create target with an x and y
Then: it is created with the x and y coordinates

THen Shot call and methods - get coordinates

Judge to compare target values and shot values

Flow Class to call methods

 */
    ITarget target;
    IShot shot;
    IRoundingShotResult rounding;

    @Before
    public void setUp(){
         target = new Target();
         shot = new Shot();
         rounding = new RoundingShotResult();


    }

    @Test
    public void testTargetCreatedWithSetXYValues() {
//        Given: I need a target
            ITarget target = new Target();
//        When: I create target with an x and y

//        Then: it is created with random X/Y values
        int[] result = new int[2];
        result = target.getRandomXY();
        int size = result.length;
        assertEquals(2, size);
    }

    @Test
    public void testShotValues() {
//        Given: I need a shot
            int velocity = 5;
            int angle = 75;
            IShot shot = new Shot();
//        When: I create target with an x and y
            double[] result = new double[2];
            result = shot.computeVelocityAngle(velocity,angle);
//        Then: it is created with random X/Y values
        double[] calculateResults = new double[2];
            calculateResults[0] =1.2940952255126037;
            calculateResults[1]=4.8296291314453415;

            assertArrayEquals(calculateResults,result);
    }
    @Test
    public void testRoundingShotResult() {
//        Given: I need a shot
        int velocity = 5;
        int angle = 75;
        Shot shot = new Shot();
//        When: I create target with an x and y
        double[] result = new double[2];
        result = shot.computeVelocityAngle(velocity,angle);
//        Then: it is created with random X/Y values
        IRoundingShotResult rounding = new RoundingShotResult();
        int[] actualRoundedResult = new int[2];
        actualRoundedResult = rounding.roundDoubleValues(result);
        int[] roundedResult = new int[2];
        roundedResult[0] = 1;
        roundedResult[1] = 5;

        assertArrayEquals(roundedResult, actualRoundedResult);
    }
    @Test
    public void testJudgeClassComparesTargetValuesAndRoundedValues() {
//        Given: I
        ITarget target = new Target();

        int velocity = 5;
        int angle = 30;
        Shot shot = new Shot();
//        When: I create target with an x and y
        double[] result = new double[2];
        result = shot.computeVelocityAngle(velocity,angle);
//        Then: it is created with random X/Y values
        IRoundingShotResult rounding = new RoundingShotResult();
        IJudgeClass judge = new JudgeClass();
        System.out.println(Arrays.toString(rounding.roundDoubleValues(result)));
        int[] test = {4, 2};
        int judgeResult = judge.compareShotAndTarget(test,rounding.roundDoubleValues(result));
        assertEquals(1,judgeResult);

    }

    /*
    Test counter
    Test Validator - and classes to test valid user input
    Flow - target? input is passed to Validtor.validate()->Shot.computeXY
    -> rounded object - > judge.compare ->false add counter//true return counter

    Game Class - to generate the target?
    Output


     */

}
