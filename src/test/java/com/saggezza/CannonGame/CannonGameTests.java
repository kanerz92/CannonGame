package com.saggezza.CannonGame;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


public class CannonGameTests {

/*
Given: I need a target
When: I create target with an x and y
Then: it is created with the x and y coordinates

THen Shot call and methods - get coordinates

Judge to compare target values and shot values

Flow Class to call methods

 */

    @Test
    public void testTargetCreatedWithRandomXYValues() {
//      Given: I need a target
        ITarget target = new Target();
//      When: the target is created

//      Then: it is created with random X/Y values

        int[] result = target.getRandomXY();
        int size = result.length;
        assertEquals(2, size);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testShotValuesAreComputedCorrectly() {
//      Given: I need a shot
        IShot shot = new Shot();
//      When: I input a velocity of 5 and an angle of 75
        int velocity = 5;
        int angle = 75;
        double[] result;
        result = shot.computeVelocityAngle(velocity,angle);
//      Then: the inputted angle and velocity are converted into x,y co-ordinates
        double[] calculateResults = new double[2];
            calculateResults[0] = 1.2940952255126037;
            calculateResults[1] = 4.8296291314453415;

            assertArrayEquals(calculateResults,result);
    }
    @Test
    public void testShotValuesAreRoundedCorrectlyIntoIntArray() {
//      Given: I have a shot
        int velocity = 5; int angle = 75;
        Shot shot = new Shot();
//      When: The shot is created with velocity 5 and angle 75
        double[] result;
        result = shot.computeVelocityAngle(velocity,angle);
//      Then: it is rounded to a whole numbers of type int
        IRoundingShotResult rounding = new RoundingShotResult();
        int[] actualRoundedResult;
        actualRoundedResult = rounding.roundDoubleValues(result);
        int[] roundedResult = new int[2];
        roundedResult[0] = 1;
        roundedResult[1] = 5;

        assertArrayEquals(roundedResult, actualRoundedResult);
    }
    @Test
    public void testJudgeClassComparesTargetValuesAndRoundedValues() {
//      Given: I need to compare a shot vs a target
        int velocity = 5; int angle = 30;
        Shot shot = new Shot();
//      When: I pass a [4,2] target and [4,2] shot to the judge
        double[] result;
        result = shot.computeVelocityAngle(velocity,angle);
//      Then: the target array and shot array are compared and returns true for a match
        IRoundingShotResult rounding = new RoundingShotResult();
        IJudgeClass judge = new JudgeClass();
        int[] test = {4, 2};
        boolean judgeResult = judge.compareShotAndTarget(test,rounding.roundDoubleValues(result));
        assertTrue(judgeResult);
    }
    @Test
    public void testValidInputForTheShot(){
//        Given: I enter a velocity and angle
          IValidateInput validate = new ValidateInput();
//        When: The Velocity is 1 and Angle is 90
        int velocity = 1 ;
        int angle = 90;
          boolean returnValue = validate.checkInput(velocity, angle);
//        Then: The shot is valid and returns true

        assertTrue(returnValue);
    }
    @Test
    public void testInValidInputForVelocityTheShotReturnFalse(){
//        Given: I enter a velocity and angle
        IValidateInput validate = new ValidateInput();
//        When: The Velocity is 1 and Angle is 90
        int velocity = 0 ;
        int angle = 90;
        boolean returnValue = validate.checkInput(velocity, angle);
//        Then: The shot is valid and returns true

        assertFalse(returnValue);
    }
    @Test
    public void testInValidInputForAngleTheShotReturnFalse(){
//        Given: I enter a velocity and angle
        IValidateInput validate = new ValidateInput();
//        When: The Velocity is 1 and Angle is 90
        int velocity = 1 ;
        int angle = 91;
        boolean returnValue = validate.checkInput(velocity, angle);
//        Then: The shot is valid and returns true

        assertFalse(returnValue);
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


//@ExtendWith(MockitoExtension.class)
////@RunWith(MockitoJUnitRunner.class)
//public class CannonFlowClassTests {
//    @InjectMocks
//    FlowClass flow;
//
//    ITarget mockTarget;
//    IValidateInput mockValidator;
//    IShot mockShot;
//    IRoundingShotResult mockRounding;
//    IJudgeClass mockJudge;
//    ICounter mockCounter;
