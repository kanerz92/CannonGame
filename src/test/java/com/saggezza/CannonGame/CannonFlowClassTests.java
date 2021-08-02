package com.saggezza.CannonGame;

import org.junit.jupiter.api.Test;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


//@ExtendWith(MockitoExtension.class)
//@RunWith(MockitoJUnitRunner.class)
public class CannonFlowClassTests {

//    @Mock
//    ITarget mockTarget;
//    IValidateInput mockValidator;
//    IShot mockShot;
//    IRoundingShotResult mockRounding;
//    IJudgeClass mockJudge;
//    ICounter mockCounter;
//    @InjectMocks
//    FlowClass flow;
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
    public void testValidatorCheckInputMethodIsCalledOnceGivenVelocityAndAngleIsInput() {
//      Given: I start the game
        int velocity = 5;
        int angle = 45;
//      When: When I enter 5 for velocity and 45 for angle
        ITarget mockTarget = mock(ITarget.class);
        IValidateInput mockValidator = mock(IValidateInput.class);
        IShot mockShot = mock(IShot.class);
        IRoundingShotResult mockRounding = mock(IRoundingShotResult.class);
        IJudgeClass mockJudge = mock(IJudgeClass.class);
        ICounter mockCounter = mock(ICounter.class);

        IGameFlow flow = new FlowClass(mockTarget, mockValidator, mockShot, mockRounding, mockJudge, mockCounter);
        int[] resu = new int[2];
        given(mockTarget.getRandomXY()).willReturn(resu);
        given(mockValidator.checkInput(1, 50)).willReturn(true);
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
        ITarget mockTarget = mock(ITarget.class);
        IValidateInput mockValidator = mock(IValidateInput.class);
        IShot mockShot = mock(IShot.class);
        IRoundingShotResult mockRounding = mock(IRoundingShotResult.class);
        IJudgeClass mockJudge = mock(IJudgeClass.class);
        ICounter mockCounter = mock(ICounter.class);

        IGameFlow flow = new FlowClass(mockTarget, mockValidator, mockShot, mockRounding, mockJudge, mockCounter);
        double[] res = new double[2];

        int[] resu = new int[2];
        given(mockTarget.getRandomXY()).willReturn(resu);
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
        ITarget mockTarget = mock(ITarget.class);
        IValidateInput mockValidator = mock(IValidateInput.class);
        IShot mockShot = mock(IShot.class);
        IRoundingShotResult mockRounding = mock(IRoundingShotResult.class);
        IJudgeClass mockJudge = mock(IJudgeClass.class);
        ICounter mockCounter = mock(ICounter.class);

        IGameFlow flow = new FlowClass(mockTarget, mockValidator, mockShot, mockRounding, mockJudge, mockCounter);
        double[] res = new double[2];
        int[] resu = new int[2];
        given(mockTarget.getRandomXY()).willReturn(resu);
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
        ITarget mockTarget = mock(ITarget.class);
        IValidateInput mockValidator = mock(IValidateInput.class);
        IShot mockShot = mock(IShot.class);
        IRoundingShotResult mockRounding = mock(IRoundingShotResult.class);
        IJudgeClass mockJudge = mock(IJudgeClass.class);
        ICounter mockCounter = mock(ICounter.class);

        IGameFlow flow = new FlowClass(mockTarget, mockValidator, mockShot, mockRounding, mockJudge, mockCounter);
        double[] res = new double[2];
        int[] resu = new int[2];
        given(mockTarget.getRandomXY()).willReturn(resu);
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
        ITarget mockTarget = mock(ITarget.class);
        IValidateInput mockValidator = mock(IValidateInput.class);
        IShot mockShot = mock(IShot.class);
        IRoundingShotResult mockRounding = mock(IRoundingShotResult.class);
        IJudgeClass mockJudge = mock(IJudgeClass.class);
        ICounter mockCounter = mock(ICounter.class);
        IGameFlow flow = new FlowClass(mockTarget, mockValidator, mockShot, mockRounding, mockJudge, mockCounter);
        double[] res = new double[2];
        int[] resu = new int[2];
        given(mockTarget.getRandomXY()).willReturn(resu);
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
        ITarget mockTarget = mock(ITarget.class);
        IValidateInput mockValidator = mock(IValidateInput.class);
        IShot mockShot = mock(IShot.class);
        IRoundingShotResult mockRounding = mock(IRoundingShotResult.class);
        IJudgeClass mockJudge = mock(IJudgeClass.class);
        ICounter mockCounter = mock(ICounter.class);
        IGameFlow flow = new FlowClass(mockTarget, mockValidator, mockShot, mockRounding, mockJudge, mockCounter);
        int[] resu = new int[2];
        given(mockTarget.getRandomXY()).willReturn(resu);
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
//      When: When I call the flow class method
        ITarget mockTarget = mock(ITarget.class);
        IValidateInput mockValidator = mock(IValidateInput.class);
        IShot mockShot = mock(IShot.class);
        IRoundingShotResult mockRounding = mock(IRoundingShotResult.class);
        IJudgeClass mockJudge = mock(IJudgeClass.class);
        ICounter mockCounter = mock(ICounter.class);
        IGameFlow flow = new FlowClass(mockTarget, mockValidator, mockShot, mockRounding, mockJudge, mockCounter);

        int[] resu = new int[2];
        given(mockTarget.getRandomXY()).willReturn(resu);
        given(mockValidator.checkInput(velocity, angle)).willReturn(false);
//      THen: computeVelocityAngle method is never called

        flow.flow(velocity, angle);
        verify(mockShot, times(0)).computeVelocityAngle(velocity, angle);
    }
    @Test
    public void testRoundDoubleValuesIsNeverCalledIfInputIsInValid() {
//      Given: I enter 0 for velocity and 45 for angle
        int velocity = 0;
        int angle = 45;
//      When: When I call the flow class method
        ITarget mockTarget = mock(ITarget.class);
        IValidateInput mockValidator = mock(IValidateInput.class);
        IShot mockShot = mock(IShot.class);
        IRoundingShotResult mockRounding = mock(IRoundingShotResult.class);
        IJudgeClass mockJudge = mock(IJudgeClass.class);
        ICounter mockCounter = mock(ICounter.class);
        IGameFlow flow = new FlowClass(mockTarget, mockValidator, mockShot, mockRounding, mockJudge, mockCounter);
        double[] res = new double[2];
        int[] resu = new int[2];
        given(mockTarget.getRandomXY()).willReturn(resu);
        given(mockValidator.checkInput(velocity, angle)).willReturn(false);
//      THen: roundDoubleValues method is never called

        flow.flow(velocity, angle);
        verify(mockRounding, times(0)).roundDoubleValues(res);
    }
    @Test
    public void testJudgeCompareShotAndTargetMethodIsNeverCalledIfInputIsInvalid() {
//      Given: I enter 0 for velocity and 45 for angle
        int velocity = 0;
        int angle = 45;
//      When: When I call the flow class method
        ITarget mockTarget = mock(ITarget.class);
        IValidateInput mockValidator = mock(IValidateInput.class);
        IShot mockShot = mock(IShot.class);
        IRoundingShotResult mockRounding = mock(IRoundingShotResult.class);
        IJudgeClass mockJudge = mock(IJudgeClass.class);
        ICounter mockCounter = mock(ICounter.class);
        IGameFlow flow = new FlowClass(mockTarget, mockValidator, mockShot, mockRounding, mockJudge, mockCounter);
        int[] resu = new int[2];
        given(mockTarget.getRandomXY()).willReturn(resu);
        given(mockValidator.checkInput(velocity, angle)).willReturn(true);

//      THen: compareShotAndTarget method is never called

        flow.flow(velocity, angle);
        verify(mockJudge, times(0)).compareShotAndTarget(resu,resu);
    }
}
