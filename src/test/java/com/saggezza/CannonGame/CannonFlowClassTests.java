package com.saggezza.CannonGame;

import com.saggezza.CannonGame.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.apache.coyote.http11.Constants.a;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.anyByte;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
public class CannonFlowClassTests {

    /*
    HappyPathTests
    Test - 1 mockValidatorIsCalledOnceGivenVelocityAndAngleIsInput()
    Test - 2 testShotClassComputeVelocityAndAngleMethodIsCalledOneTimeIfInputIsValid()
    Test - 3 roundDoubleValuesWillBeCalledOnceIfInputIsValid()
    Test - 4 testIfInputIsValidThenTheIncrementCounterWillBeCalledOneTime();
    Test - 5 testIfInputIsValidThenTheJudgeCompareShotAndTargetMethodWillBeCalledOneTime();
    Test - 6 testIfJudgeResultWasTrueReturnCounterWillBeCalledOnce() --Need hardcoded values to test
    Test - 7 testIfJudgeResultWasFalseReturnCounterWillBeCalledZeroTimes --Need hardcoded values to test

    NoHappyPath
    Test - 8 mockValidatorIsCalledOnceGivenVelocityAndAngleIsInputInvalid()
    Test - 9 computeVelocityAndAngleMethodIsCalledZeroTimesIfInputIsInValid()
   Test - 10 roundDoubleValuesWillBeCalledZeroTimesIfInputIsInValid()
    Test - 11 testIfInputIsInValidThenTheJudgeCompareShotAndTargetMethodWillBeCalledZeroTimes();

     */


//    @Mock
//    IGameFlow flow;
//    ITarget mockTarget;
//    IValidateInput mockValidator;
//    IShot mockShot;
//    IRoundingShotResult mockRounding;
//    IJudgeClass mockJudge;
//    ICounter mockCounter;
//    @BeforeEach
//    void setUp(){
//        MockitoAnnotations.openMocks(this);
//        this.flow = new FlowClass(mockTarget, mockValidator, mockShot, mockRounding, mockJudge, mockCounter);
//    }

    @Test
    public void mockValidatorIsCalledOnceGivenVelocityAndAngleIsInput() {
//      Given:
        int velocity = 5;
        int angle = 45;
//      When: When I call the flow class method
        ITarget mockTarget = mock(ITarget.class);
        IValidateInput mockValidator = mock(IValidateInput.class);
        IShot mockShot = mock(IShot.class);
        IRoundingShotResult mockRounding = mock(IRoundingShotResult.class);
        IJudgeClass mockJudge = mock(IJudgeClass.class);
        ICounter mockCounter = mock(ICounter.class);
//        THen:
        IGameFlow flow = new FlowClass(mockTarget, mockValidator, mockShot, mockRounding, mockJudge, mockCounter);
        double[] res = new double[2];
        int[] resu = new int[2];
        given(mockTarget.getRandomXY()).willReturn(resu);
        given(mockValidator.checkInput(1, 50)).willReturn(true);


        flow.flow(velocity, angle);
        verify(mockValidator, times(1)).checkInput(velocity, angle);
    }

    @Test
    public void testShotClassComputeVelocityAndAngleMethodIsCalledOneTimeIfInputIsValid() {
//      Given:
        int velocity = 5;
        int angle = 45;
//      When: When I call the flow class method
        ITarget mockTarget = mock(ITarget.class);
        IValidateInput mockValidator = mock(IValidateInput.class);
        IShot mockShot = mock(IShot.class);
        IRoundingShotResult mockRounding = mock(IRoundingShotResult.class);
        IJudgeClass mockJudge = mock(IJudgeClass.class);
        ICounter mockCounter = mock(ICounter.class);
//        THen:
        IGameFlow flow = new FlowClass(mockTarget, mockValidator, mockShot, mockRounding, mockJudge, mockCounter);
        double[] res = new double[2];

        int[] resu = new int[2];
        given(mockTarget.getRandomXY()).willReturn(resu);
        given(mockValidator.checkInput(velocity, angle)).willReturn(true);
        given(mockShot.computeVelocityAngle(velocity, angle)).willReturn(res);

        flow.flow(velocity, angle);
        verify(mockShot, times(1)).computeVelocityAngle(velocity, angle);
    }

    @Test
    public void roundDoubleValuesWillBeCalledOnceIfInputIsValid() {
//      Given:
        int velocity = 5;
        int angle = 45;
//      When: When I call the flow class method
        ITarget mockTarget = mock(ITarget.class);
        IValidateInput mockValidator = mock(IValidateInput.class);
        IShot mockShot = mock(IShot.class);
        IRoundingShotResult mockRounding = mock(IRoundingShotResult.class);
        IJudgeClass mockJudge = mock(IJudgeClass.class);
        ICounter mockCounter = mock(ICounter.class);
//        THen:
        IGameFlow flow = new FlowClass(mockTarget, mockValidator, mockShot, mockRounding, mockJudge, mockCounter);
        double[] res = new double[2];
        int[] resu = new int[2];
        given(mockTarget.getRandomXY()).willReturn(resu);
        given(mockValidator.checkInput(velocity, angle)).willReturn(true);
        given(mockShot.computeVelocityAngle(velocity, angle)).willReturn(res);
        given(mockRounding.roundDoubleValues(res)).willReturn(resu);


        flow.flow(velocity, angle);
        verify(mockRounding, times(1)).roundDoubleValues(res);
    }

    @Test
    public void testIfInputIsValidThenTheIncrementCounterWillBeCalledOneTime() {
//      Given:
        int velocity = 5;
        int angle = 45;
//      When: When I call the flow class method
        ITarget mockTarget = mock(ITarget.class);
        IValidateInput mockValidator = mock(IValidateInput.class);
        IShot mockShot = mock(IShot.class);
        IRoundingShotResult mockRounding = mock(IRoundingShotResult.class);
        IJudgeClass mockJudge = mock(IJudgeClass.class);
        ICounter mockCounter = mock(ICounter.class);
//        THen:
        IGameFlow flow = new FlowClass(mockTarget, mockValidator, mockShot, mockRounding, mockJudge, mockCounter);
        double[] res = new double[2];
        int[] resu = new int[2];
        given(mockTarget.getRandomXY()).willReturn(resu);
        given(mockValidator.checkInput(velocity, angle)).willReturn(true);
        given(mockShot.computeVelocityAngle(velocity, angle)).willReturn(res);
        given(mockRounding.roundDoubleValues(res)).willReturn(resu);


        flow.flow(velocity, angle);
        verify(mockCounter, times(1)).incrementCounter();
    }

    @Test
    public void testIfInputIsValidThenTheJudgeCompareShotAndTargetMethodWillBeCalledOneTime() {
//      Given:
        int velocity = 5;
        int angle = 45;
//      When: When I call the flow class method
        ITarget mockTarget = mock(ITarget.class);
        IValidateInput mockValidator = mock(IValidateInput.class);
        IShot mockShot = mock(IShot.class);
        IRoundingShotResult mockRounding = mock(IRoundingShotResult.class);
        IJudgeClass mockJudge = mock(IJudgeClass.class);
        ICounter mockCounter = mock(ICounter.class);
//        THen:
        IGameFlow flow = new FlowClass(mockTarget, mockValidator, mockShot, mockRounding, mockJudge, mockCounter);
        double[] res = new double[2];
        int[] resu = new int[2];
        given(mockTarget.getRandomXY()).willReturn(resu);
        given(mockValidator.checkInput(velocity, angle)).willReturn(true);
        given(mockShot.computeVelocityAngle(velocity, angle)).willReturn(res);
        given(mockRounding.roundDoubleValues(res)).willReturn(resu);
        given(mockJudge.compareShotAndTarget(resu, resu)).willReturn(true);


        flow.flow(velocity, angle);
        verify(mockJudge, times(1)).compareShotAndTarget(resu, resu);
    }


    @Test
    public void mockValidatorIsCalledOnceGivenVelocityAndAngleInputIsInvalid() {
///Given:
        int velocity = 0;
        int angle = 45;
//      When: When I call the flow class method
        ITarget mockTarget = mock(ITarget.class);
        IValidateInput mockValidator = mock(IValidateInput.class);
        IShot mockShot = mock(IShot.class);
        IRoundingShotResult mockRounding = mock(IRoundingShotResult.class);
        IJudgeClass mockJudge = mock(IJudgeClass.class);
        ICounter mockCounter = mock(ICounter.class);
//        THen:
        IGameFlow flow = new FlowClass(mockTarget, mockValidator, mockShot, mockRounding, mockJudge, mockCounter);
        double[] res = new double[2];
        int[] resu = new int[2];
        given(mockTarget.getRandomXY()).willReturn(resu);
        given(mockValidator.checkInput(velocity, angle)).willReturn(true);


        flow.flow(velocity, angle);
        verify(mockValidator, times(1)).checkInput(velocity, angle);
    }

    @Test
    public void testShotClassComputeVelocityAndAngleMethodIsCalledZeroTimesIfInputIsInValid() {
//      Given:
        int velocity = 0;
        int angle = 45;
//      When: When I call the flow class method
        ITarget mockTarget = mock(ITarget.class);
        IValidateInput mockValidator = mock(IValidateInput.class);
        IShot mockShot = mock(IShot.class);
        IRoundingShotResult mockRounding = mock(IRoundingShotResult.class);
        IJudgeClass mockJudge = mock(IJudgeClass.class);
        ICounter mockCounter = mock(ICounter.class);
//        THen:
        IGameFlow flow = new FlowClass(mockTarget, mockValidator, mockShot, mockRounding, mockJudge, mockCounter);
        double[] res = new double[2];

        int[] resu = new int[2];
        given(mockTarget.getRandomXY()).willReturn(resu);
        given(mockValidator.checkInput(velocity, angle)).willReturn(false);

        flow.flow(velocity, angle);
        verify(mockShot, times(0)).computeVelocityAngle(velocity, angle);
    }
    @Test
    public void roundDoubleValuesWillBeCalledZeroTimesIfInputIsInValid() {
//      Given:
        int velocity = 0;
        int angle = 45;
//      When: When I call the flow class method
        ITarget mockTarget = mock(ITarget.class);
        IValidateInput mockValidator = mock(IValidateInput.class);
        IShot mockShot = mock(IShot.class);
        IRoundingShotResult mockRounding = mock(IRoundingShotResult.class);
        IJudgeClass mockJudge = mock(IJudgeClass.class);
        ICounter mockCounter = mock(ICounter.class);
//        THen:
        IGameFlow flow = new FlowClass(mockTarget, mockValidator, mockShot, mockRounding, mockJudge, mockCounter);
        double[] res = new double[2];
        int[] resu = new int[2];
        given(mockTarget.getRandomXY()).willReturn(resu);
        given(mockValidator.checkInput(velocity, angle)).willReturn(false);

        flow.flow(velocity, angle);
        verify(mockRounding, times(0)).roundDoubleValues(res);
    }
    @Test
    public void testIfInputIsInValidThenTheJudgeCompareShotAndTargetMethodWillBeCalledZeroTimes() {
//      Given:
        int velocity = 0;
        int angle = 45;
//      When: When I call the flow class method
        ITarget mockTarget = mock(ITarget.class);
        IValidateInput mockValidator = mock(IValidateInput.class);
        IShot mockShot = mock(IShot.class);
        IRoundingShotResult mockRounding = mock(IRoundingShotResult.class);
        IJudgeClass mockJudge = mock(IJudgeClass.class);
        ICounter mockCounter = mock(ICounter.class);
//        THen:
        IGameFlow flow = new FlowClass(mockTarget, mockValidator, mockShot, mockRounding, mockJudge, mockCounter);
        double[] res = new double[2];
        int[] resu = new int[2];
        given(mockTarget.getRandomXY()).willReturn(resu);
        given(mockValidator.checkInput(velocity, angle)).willReturn(true);



        flow.flow(velocity, angle);
        verify(mockJudge, times(0)).compareShotAndTarget(resu,resu);
    }
}
