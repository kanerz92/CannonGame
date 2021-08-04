package com.saggezza.CannonGame;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ShotFlowTest {

    @InjectMocks
    ShotFlow shotFlow;
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
    void testGivenValidInputThenCheckInputCalledOnce() {
        //Given: I have a target
        int[] target = new int[] {2,2};

        //When: I take a valid shot

        int velocity = 10;
        int angle = 45;
        given(mockValidator.checkInput(velocity,angle)).willReturn(true);
        given(mockShot.computeCoordinates(velocity,angle)).willReturn(new double[]{7.071, 7.071});
        given(mockRounding.roundDoubleValues(new double[]{7.071, 7.071})).willReturn(new int[] {7,7});
//        IShotFlow shotFlow = new ShotFlow(mockValidateInput, mockShot, mockRoundingShotResult, mockJudge, mockCounter);
        shotFlow.flow(velocity, angle, target);
        //Then: checkInput is called once
        verify(mockValidator, times(1)).checkInput(velocity, angle);
    }

    @Test
    void testGivenValidInputThenComputeCoordinatesCalledOnce() {
        //Given: I have a target
        int[] target = new int[] {2,2};
        //When: I take a valid shot
        int velocity = 10;
        int angle = 45;
        given(mockValidator.checkInput(velocity,angle)).willReturn(true);
        given(mockShot.computeCoordinates(velocity,angle)).willReturn(new double[]{7.071, 7.071});
        given(mockRounding.roundDoubleValues(new double[]{7.071, 7.071})).willReturn(new int[] {7,7});
        shotFlow.flow(velocity, angle, target);
        //Then: computeVelocityAngle is called once
        verify(mockShot, times(1)).computeCoordinates(velocity,angle);
    }

    @Test
    void testGivenValidInputThenRoundDoubleCalledOnce() {
        //Given: I have a target
        int[] target = new int[] {2,2};
        //When: I take a valid shot
        int velocity = 10;
        int angle = 45;
        given(mockValidator.checkInput(velocity,angle)).willReturn(true);
        given(mockShot.computeCoordinates(velocity,angle)).willReturn(new double[]{7.071, 7.071});
        given(mockRounding.roundDoubleValues(new double[]{7.071, 7.071})).willReturn(new int[] {7,7});
        shotFlow.flow(velocity, angle, target);
        //Then: roundDoubleValues is called once
        verify(mockRounding, times(1)).roundDoubleValues(new double[] {7.071, 7.071});
    }

    @Test
    void testGivenValidInputThenCompareShotAndTargetCalledOnce() {
        //Given: I have a target
        int[] target = new int[] {2,2};

        //When: I take a valid shot
        int velocity = 10;
        int angle = 45;
        given(mockValidator.checkInput(velocity,angle)).willReturn(true);
        given(mockShot.computeCoordinates(velocity,angle)).willReturn(new double[]{7.071, 7.071});
        given(mockRounding.roundDoubleValues(new double[]{7.071, 7.071})).willReturn(new int[] {7,7});
        IShotFlow shotFlow = new ShotFlow(mockValidator, mockShot, mockRounding, mockJudge, mockCounter);
        shotFlow.flow(velocity, angle, target);
        //Then: compareShotAndTarget is called once
        verify(mockJudge, times(1)).compareShotAndTarget(any(int[].class), any(int[].class));
    }

    @Test
    void testGivenValidInputThenCounterCalledOnce() {
        //Given: I have a target
        int[] target = new int[] {2,2};

        //When: I take a valid shot
        int velocity = 10;
        int angle = 45;
        given(mockValidator.checkInput(velocity,angle)).willReturn(true);
        given(mockShot.computeCoordinates(velocity,angle)).willReturn(new double[]{7.071, 7.071});
        given(mockRounding.roundDoubleValues(new double[]{7.071, 7.071})).willReturn(new int[] {7,7});
        IShotFlow shotFlow = new ShotFlow(mockValidator, mockShot, mockRounding, mockJudge, mockCounter);
        shotFlow.flow(velocity, angle, target);
        //Then: compareShotAndTarget is called once
        verify(mockCounter, times(1)).incrementCounter();
    }

    @Test
    void testGivenInvalidInputThenCheckInputCalledOnce() {
        //Given: I have a target
        int[] target = new int[] {2,2};

        //When: I take an invalid shot
        int velocity = 0;
        int angle = 100;
        given(mockValidator.checkInput(velocity,angle)).willReturn(false);
        shotFlow.flow(velocity, angle, target);
        //Then: checkInput is called once
        verify(mockValidator, times(1)).checkInput(velocity, angle);
    }

    @Test
    void testGivenInvalidInputThenComputeCoordinatesCalledNever() {
        //Given: I have a target
        int[] target = new int[] {2,2};

        //When: I take a valid shot
        int velocity = 0;
        int angle = 100;
        given(mockValidator.checkInput(velocity,angle)).willReturn(false);
        shotFlow.flow(velocity, angle, target);
        //Then: computeVelocityAngle is called Never
        verify(mockShot, times(0)).computeCoordinates(anyInt(),anyInt());
    }

    @Test
    void testGivenInvalidInputThenRoundDoubleCalledNever() {
        //Given: I have a target
         int[] target = new int[] {2,2};

        //When: I take an invalid shot
        int velocity = 0;
        int angle = 100;
        given(mockValidator.checkInput(velocity,angle)).willReturn(false);
        shotFlow.flow(velocity, angle, target);
        //Then: roundDoubleValues is called never
        verify(mockRounding, times(0)).roundDoubleValues(any(double[].class));
    }

    @Test
    void testGivenInvalidInputThenCompareShotAndTargetCalledNever() {
        //Given: I have a target
        int[] target = new int[] {2,2};

        //When: I take an invalid shot
        int velocity = 0;
        int angle = 100;
        given(mockValidator.checkInput(velocity,angle)).willReturn(false);
        shotFlow.flow(velocity, angle, target);
        //Then: computeVelocityAngle is called never
        verify(mockJudge, never()).compareShotAndTarget(any(int[].class), any(int[].class));
    }
}


