package com.saggezza.CannonGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidateInputClassTest {

    @Test
    public void testForAValidInputForTheShot(){
//      Given: I enter a velocity and angle
        IValidateInput validate = new ValidateInput();
//      When: The Velocity is 1 and Angle is 90
        int velocity = 1 ;
        int angle = 90;
        boolean returnValue = validate.checkInput(velocity, angle);
//      Then: The shot is valid and returns true
        assertTrue(returnValue);
    }
    @Test
    public void testInValidInputForVelocityTheShotReturnFalse(){
//      Given: I enter a velocity and angle
        IValidateInput validate = new ValidateInput();
//      When: The Velocity is 1 and Angle is 90
        int velocity = 0 ;
        int angle = 90;
        boolean returnValue = validate.checkInput(velocity, angle);
//      Then: The shot is invalid and returns false
        assertFalse(returnValue);
    }
    @Test
    public void testInValidInputForAngleTheShotReturnFalse(){
//      Given: I enter a velocity and angle
        IValidateInput validate = new ValidateInput();
//      When: The Velocity is 1 and Angle is 90
        int velocity = 1 ;
        int angle = 91;
        boolean returnValue = validate.checkInput(velocity, angle);
//      Then: The shot is valid and returns true
        assertFalse(returnValue);
    }
}

