package com.saggezza.CannonGame;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class CannonFlowClassTests {
    @InjectMocks
    FlowClass flow;
    @Mock
    ITarget mockTarget;
    @Mock
    IValidateInput mockValidator;
    @Mock
    IShot mockShot;
    @Mock
    IRoundingShotResult mockRounding;
    @Mock
    IJudgeClass mockJudge;
    @Mock
    ICounter mockCounter;


    @Test
    public void testValidatorCheckInputMethodIsCalledOnceGivenVelocityAndAngleIsInput() {
//      Given: I start the game
        int velocity = 5;
        int angle = 45;
//      When: When I enter 5 for velocity and 45 for angle
        int[] resu = new int[2];

        given(mockTarget.getRandomXY()).willReturn(resu);

        given(mockValidator.checkInput(velocity, angle)).willReturn(true);
//      THen: The checkInput method is called one time
        flow.flow(velocity, angle);
        verify(mockValidator, times(1)).checkInput(velocity, angle);
    }
    @Test
    public void testShotClassComputeVelocityAndAngleMethodIsCalledOneTimeIfInputIsValid() {
//      Given: I enter 5 for velocity and 45 for angle
        int velocity = 5;
        int angle = 45;
//      When: The flow class is called
        double[] res = new double[2];
        int[] resu = new int[2];
        given(mockValidator.checkInput(velocity, angle)).willReturn(true);
        given(mockShot.computeVelocityAngle(velocity, angle)).willReturn(res);
//      THen: computeAngleVelocity method is called once
        flow.flow(velocity, angle);
        verify(mockShot, times(1)).computeVelocityAngle(velocity, angle);
    }
    @Test
    public void testRoundDoubleValuesMethodWillBeCalledOnceIfInputIsValid() {
//      Given: I enter 5 for velocity and 45 for angle
        int velocity = 5;
        int angle = 45;
//      When: The flow class method
        double[] res = new double[2];
        int[] resu = new int[2];
        given(mockValidator.checkInput(velocity, angle)).willReturn(true);
        given(mockShot.computeVelocityAngle(velocity, angle)).willReturn(res);
        given(mockRounding.roundDoubleValues(res)).willReturn(resu);
//      THen: roundDoubleValues method is called once
        flow.flow(velocity, angle);
        verify(mockRounding, times(1)).roundDoubleValues(res);
    }
    @Test
    public void testTheIncrementCounterWillBeCalledOneTimeWithValidInput() {
//      Given: I enter 5 for velocity and 45 for angle
        int velocity = 5;
        int angle = 45;
//      When: When I call the flow class method
        double[] res = new double[2];
        int[] resu = new int[2];
        given(mockValidator.checkInput(velocity, angle)).willReturn(true);
        given(mockShot.computeVelocityAngle(velocity, angle)).willReturn(res);
        given(mockRounding.roundDoubleValues(res)).willReturn(resu);
//      THen: incrementCounter method is called once
        flow.flow(velocity, angle);
        verify(mockCounter, times(1)).incrementCounter();
    }

    @Test
    public void testIfInputIsValidThenTheJudgeCompareShotAndTargetMethodWillBeCalledOneTime() {
//      Given: I enter 5 for velocity and 45 for angle
        int velocity = 5;
        int angle = 45;
//      When: When I call the flow class method
        double[] res = new double[2];
        int[] resu = new int[2];
//        given(mockTarget.getRandomXY()).willReturn(resu);
        given(mockValidator.checkInput(velocity, angle)).willReturn(true);
        given(mockShot.computeVelocityAngle(velocity, angle)).willReturn(res);
        given(mockRounding.roundDoubleValues(res)).willReturn(resu);
        given(mockJudge.compareShotAndTarget(resu, resu)).willReturn(true);
//      THen: compareShotAndTarget method is called once
        flow.flow(velocity, angle);
        verify(mockJudge, times(1)).compareShotAndTarget(resu, resu);
    }

    @Test
    public void testValidatorIsCalledOnceGivenVelocityAndAngleInputIsInvalid() {
//      Given: I enter 0 for velocity and 45 for angle
        int velocity = 0;
        int angle = 45;
//      When: When I call the flow class method
        int[] resu = new int[2];
        given(mockValidator.checkInput(velocity, angle)).willReturn(true);
//      THen: checkInput method is called once
        flow.flow(velocity, angle);
        verify(mockValidator, times(1)).checkInput(velocity, angle);
    }

    @Test
    public void testShotClassComputeVelocityAndAngleMethodIsNeverCalledIfInputIsInValid() {
//      Given: I enter 0 for velocity and 45 for angle
        int velocity = 0;
        int angle = 45;
//      When: When I call the flow class meth


        given(mockValidator.checkInput(velocity, angle)).willReturn(false);
//      THen: computeVelocityAngle method is never called
        flow.flow(velocity, angle);
        verify(mockShot, never()).computeVelocityAngle(velocity, angle);
    }
    @Test
    public void testRoundDoubleValuesIsNeverCalledIfInputIsInValid() {
//      Given: I enter 0 for velocity and 45 for angle
        int velocity = 0;
        int angle = 45;
//      When: When I call the flow class methdouble[] res = new double[2];
        double[] res = new double[2];
        given(mockValidator.checkInput(velocity, angle)).willReturn(false);
//      THen: roundDoubleValues method is never called
        flow.flow(velocity, angle);
        verify(mockRounding,never()).roundDoubleValues(res);
    }
    @Test
    public void testJudgeCompareShotAndTargetMethodIsNeverCalledIfInputIsInvalid() {
//      Given: I enter 0 for velocity and 45 for angle
        int velocity = 0;
        int angle = 45;
//      When: When I call the flow class method
        int[] resu = new int[2];
        given(mockValidator.checkInput(velocity, angle)).willReturn(true);
//      THen: compareShotAndTarget method is never called
        flow.flow(velocity, angle);
        verify(mockJudge, times(0)).compareShotAndTarget(resu,resu);
    }

    @Test
    public void  testIfJudgeResultWasFalseReturnCounterWillNeverBeCalled() {
//      Given: I enter 5 for velocity and 45 for angle
        int velocity = 5;
        int angle = 45;
//      When: When I call the flow class method
        double[] res = new double[2];
        int[] resu = new int[2];
//        given(mockTarget.getRandomXY()).willReturn(resu);
        given(mockValidator.checkInput(velocity, angle)).willReturn(true);
        given(mockShot.computeVelocityAngle(velocity, angle)).willReturn(res);
        given(mockRounding.roundDoubleValues(res)).willReturn(resu);
        given(mockJudge.compareShotAndTarget(resu, resu)).willReturn(false);

//      THen: compareShotAndTarget method is called once
        flow.flow(velocity, angle);
        verify(mockCounter, never()).returnCounter();
    }
    @Test
    public void  testIfJudgeResultWasTrueReturnCounterWillBeCalledOnce() {
//      Given: I enter 5 for velocity and 45 for angle
        int velocity = 5;
        int angle = 45;
//      When: When I call the flow class method
        double[] res = new double[2];
        int[] resu = new int[2];
//        given(mockTarget.getRandomXY()).willReturn(resu);
        given(mockValidator.checkInput(velocity, angle)).willReturn(true);
        given(mockShot.computeVelocityAngle(velocity, angle)).willReturn(res);
        given(mockRounding.roundDoubleValues(res)).willReturn(resu);
        given(mockJudge.compareShotAndTarget(resu, resu)).willReturn(true);

//      THen: compareShotAndTarget method is called once
        flow.flow(velocity, angle);
        verify(mockCounter, times(1)).returnCounter();
    }
}
