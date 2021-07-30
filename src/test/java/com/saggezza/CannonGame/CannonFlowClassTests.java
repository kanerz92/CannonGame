package com.saggezza.CannonGame;

import com.saggezza.CannonGame.*;
import org.junit.jupiter.api.Test;
import org.mockito.AdditionalMatchers;
import org.mockito.ArgumentMatchers;

import static org.apache.coyote.http11.Constants.a;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.anyByte;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class CannonFlowClassTests {

    @Test
    public void testIfInputIsValidThenJudgeMethodWillBeCalledOnce(){
//        Given: I have an inputted velocity and angle
        int velocity = 5;
        int angle = 45;
//        When: When I call the flow class method
        ITarget mockTarget = mock(ITarget.class);
        IValidateInput mockValidator = mock(IValidateInput.class);
        IShot mockShot = mock(IShot.class);
        IRoundingShotResult mockRounding = mock (IRoundingShotResult.class);
        IJudgeClass mockJudge = mock(IJudgeClass.class);
        ICounter mockCounter = mock(ICounter.class);
//        THen:
        IGameFlow flow = new FlowClass(mockTarget,mockValidator,mockShot,mockRounding,mockJudge,mockCounter);
        double[] res = new double[2];
        res = mockShot.computeVelocityAngle(1,50);
        int[] resu = new int[2];
        given(mockTarget.getRandomXY()).willReturn(resu);
        given(mockValidator.checkInput(1,50)).willReturn(true);
        given(mockShot.computeVelocityAngle(1, 50)).willReturn(res);
        given(mockRounding.roundDoubleValues(res)).willReturn(resu);
        given(mockCounter.returnCounter()).willReturn(1);
        given(mockJudge.compareShotAndTarget(resu, resu)).willReturn(true);


        flow.flow(1,50);
        verify(mockJudge, times(0)).compareShotAndTarget(resu,resu);
    }

}

