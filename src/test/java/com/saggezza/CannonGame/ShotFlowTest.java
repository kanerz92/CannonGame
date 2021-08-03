package com.saggezza.CannonGame;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ShotFlowTest {

    @Test
    void testGivenValidInputThenCheckInputCalledOnce() {
        //Given: I have a target
        int[] target = new int[] {};

        //When: I take a valid shot
        IJudgeClass mockJudge = mock(JudgeClass.class);
        IRoundingShotResult mockRoundingShotResult = mock(RoundingShotResult.class);
        IValidateInput mockValidateInput = mock(ValidateInput.class);
        IShot mockShot = mock(Shot.class);
        ICounter mockCounter = mock(Counter.class);
        int velocity = 10;
        int angle = 45;
        given(mockValidateInput.checkInput(velocity,angle)).willReturn(true);
        given(mockShot.computeVelocityAngle(velocity,angle)).willReturn(new double[]{70.71, 70.71});
        given(mockRoundingShotResult.roundDoubleValues(new double[]{7.071, 7.71})).willReturn(new int[] {7,7});
        IShotFlow shotFlow = new ShotFlow(mockValidateInput, mockShot, mockRoundingShotResult, mockJudge, mockCounter);
        shotFlow.flow(velocity, angle, target);
        //Then: checkInput is called once
        verify(mockValidateInput, times(1)).checkInput(velocity, angle);
    }

    @Test
    void testGivenValidInputThenComputeVelocityAngleCalledOnce() {
        //Given: I have a target
        int[] target = new int[] {};

        //When: I take a valid shot
        IJudgeClass mockJudge = mock(JudgeClass.class);
        IRoundingShotResult mockRoundingShotResult = mock(RoundingShotResult.class);
        IValidateInput mockValidateInput = mock(ValidateInput.class);
        IShot mockShot = mock(Shot.class);
        ICounter mockCounter = mock(Counter.class);
        int velocity = 10;
        int angle = 45;
        given(mockValidateInput.checkInput(velocity,angle)).willReturn(true);
        given(mockShot.computeVelocityAngle(velocity,angle)).willReturn(new double[]{70.71, 70.71});
        given(mockRoundingShotResult.roundDoubleValues(new double[]{7.071, 7.071})).willReturn(new int[] {7,7});
        IShotFlow shotFlow = new ShotFlow(mockValidateInput, mockShot, mockRoundingShotResult, mockJudge, mockCounter);
        shotFlow.flow(velocity, angle, target);
        //Then: computeVelocityAngle is called once
        verify(mockShot, times(1)).computeVelocityAngle(velocity,angle);
    }

    @Test
    void testGivenValidInputThenRoundDoubleCalledOnce() {
        //Given: I have a target
        int[] target = new int[] {};

        //When: I take a valid shot
        IJudgeClass mockJudge = mock(JudgeClass.class);
        IRoundingShotResult mockRoundingShotResult = mock(RoundingShotResult.class);
        IValidateInput mockValidateInput = mock(ValidateInput.class);
        IShot mockShot = mock(Shot.class);
        ICounter mockCounter = mock(Counter.class);
        int velocity = 10;
        int angle = 45;
        given(mockValidateInput.checkInput(velocity,angle)).willReturn(true);
        given(mockShot.computeVelocityAngle(velocity,angle)).willReturn(new double[]{7.071, 7.071});
        given(mockRoundingShotResult.roundDoubleValues(new double[]{7.071, 7.071})).willReturn(new int[] {7,7});
        IShotFlow shotFlow = new ShotFlow(mockValidateInput, mockShot, mockRoundingShotResult, mockJudge, mockCounter);
        shotFlow.flow(velocity, angle, target);
        //Then: roundDoubleValues is called once
        verify(mockRoundingShotResult, times(1)).roundDoubleValues(new double[] {7.071, 7.071});
    }

    @Test
    void testGivenValidInputThenCompareShotAndTargetCalledOnce() {
        //Given: I have a target
        int[] target = new int[] {};

        //When: I take a valid shot
        IJudgeClass mockJudge = mock(JudgeClass.class);
        IRoundingShotResult mockRoundingShotResult = mock(RoundingShotResult.class);
        IValidateInput mockValidateInput = mock(ValidateInput.class);
        IShot mockShot = mock(Shot.class);
        ICounter mockCounter = mock(Counter.class);
        int velocity = 10;
        int angle = 45;
        given(mockValidateInput.checkInput(velocity,angle)).willReturn(true);
        given(mockShot.computeVelocityAngle(velocity,angle)).willReturn(new double[]{7.071, 7.071});
        given(mockRoundingShotResult.roundDoubleValues(new double[]{7.071, 7.071})).willReturn(new int[] {7,7});
        given(mockJudge.compareShotAndTarget(new int[] {7,7}, new int[] {7,7})).willReturn(true);
        IShotFlow shotFlow = new ShotFlow(mockValidateInput, mockShot, mockRoundingShotResult, mockJudge, mockCounter);
        shotFlow.flow(velocity, angle, target);
        //Then: compareShotAndTarget is called once
        verify(mockJudge, times(1)).compareShotAndTarget(new int[] {7, 7}, new int[] {7, 7});
    }

    @Test
    void testGivenInvalidInputThenCheckInputCalledNever() {
        //Given: I have a target
        int[] target = new int[] {};

        //When: I take an invalid shot
        IJudgeClass mockJudge = mock(JudgeClass.class);
        IRoundingShotResult mockRoundingShotResult = mock(RoundingShotResult.class);
        IValidateInput mockValidateInput = mock(ValidateInput.class);
        IShot mockShot = mock(Shot.class);
        ICounter mockCounter = mock(Counter.class);
        int velocity = 0;
        int angle = 100;
        given(mockValidateInput.checkInput(velocity,angle)).willReturn(false);
        IShotFlow shotFlow = new ShotFlow(mockValidateInput, mockShot, mockRoundingShotResult, mockJudge, mockCounter);
        shotFlow.flow(velocity, angle, target);
        //Then: checkInput is called Never
        verify(mockValidateInput, times(0)).checkInput(anyInt(), anyInt());
    }

    @Test
    void testGivenInvalidInputThenComputeVelocityAngleCalledNever() {
        //Given: I have a target
        int[] target = new int[] {};

        //When: I take a valid shot
        IJudgeClass mockJudge = mock(JudgeClass.class);
        IRoundingShotResult mockRoundingShotResult = mock(RoundingShotResult.class);
        IValidateInput mockValidateInput = mock(ValidateInput.class);
        IShot mockShot = mock(Shot.class);
        ICounter mockCounter = mock(Counter.class);
        int velocity = 0;
        int angle = 100;
        given(mockValidateInput.checkInput(velocity,angle)).willReturn(false);
        IShotFlow shotFlow = new ShotFlow(mockValidateInput, mockShot, mockRoundingShotResult, mockJudge, mockCounter);
        shotFlow.flow(velocity, angle, target);
        //Then: computeVelocityAngle is called Never
        verify(mockShot, times(0)).computeVelocityAngle(anyInt(),anyInt());
    }

    @Test
    void testGivenInvalidInputThenRoundDoubleCalledNever() {
        //Given: I have a target
         int[] target = new int[] {};

        //When: I take a valid shot
        IJudgeClass mockJudge = mock(JudgeClass.class);
        IRoundingShotResult mockRoundingShotResult = mock(RoundingShotResult.class);
        IValidateInput mockValidateInput = mock(ValidateInput.class);
        IShot mockShot = mock(Shot.class);
        ICounter mockCounter = mock(Counter.class);
        int velocity = 0;
        int angle = 100;
        given(mockValidateInput.checkInput(velocity,angle)).willReturn(false);
        IShotFlow shotFlow = new ShotFlow(mockValidateInput, mockShot, mockRoundingShotResult, mockJudge, mockCounter);
        shotFlow.flow(velocity, angle, target);
        //Then: roundDoubleValues is called never
        verify(mockRoundingShotResult, times(0)).roundDoubleValues(new double[] {anyDouble(),anyDouble()});
    }

    @Test
    void testGivenInvalidInputThenCompareShotAndTargetCalledNever() {
        //Given: I have a target
        int[] target = new int[] {};

        //When: I take a valid shot
        IJudgeClass mockJudge = mock(JudgeClass.class);
        IRoundingShotResult mockRoundingShotResult = mock(RoundingShotResult.class);
        IValidateInput mockValidateInput = mock(ValidateInput.class);
        IShot mockShot = mock(Shot.class);
        ICounter mockCounter = mock(Counter.class);
        int velocity = 0;
        int angle = 100;
        given(mockValidateInput.checkInput(velocity,angle)).willReturn(false);
        IShotFlow shotFlow = new ShotFlow(mockValidateInput, mockShot, mockRoundingShotResult, mockJudge, mockCounter);
        shotFlow.flow(velocity, angle, target);
        //Then: computeVelocityAngle is called once
        verify(mockJudge, times(0)).compareShotAndTarget(new int[] {anyInt(),anyInt()}, new int[] {anyInt(),anyInt()});
    }
}


