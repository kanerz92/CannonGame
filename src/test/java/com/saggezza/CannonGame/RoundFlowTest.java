package com.saggezza.CannonGame;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import static org.mockito.BDDMockito.given;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RoundFlowTest {
    @InjectMocks
    RoundFlow roundFlow;
    @Mock
    ITarget mockTarget;
    @Mock
    IShotFlow mockShotFlow;
    @Mock
    ICounter mockCounter;
    @Mock
    ShotResult mockShotResult;


    @Test
    void testGivenIPlayARoundATargetIsGenerated() {
        //Given: I am a user
        //When: I play a round
        ConsoleInputGetter mockConsoleInputGetter = mock(ConsoleInputGetter.class);
        given(mockConsoleInputGetter.ask("Please enter velocity")).willReturn("7");
        given(mockConsoleInputGetter.ask("Please enter angle")).willReturn("45");
        given(mockTarget.getRandomXY()).willReturn(new int[] {5,5});
        given(mockShotResult.getMessage()).willReturn("lkjdfg");
        given(mockShotResult.isHit()).willReturn(true);
        given(mockShotFlow.flow(7,45,new int[] {5,5})).willReturn(mockShotResult);
        roundFlow.startRound(mockConsoleInputGetter);

        //Then: A random target is generated
        verify(mockTarget, times(1)).getRandomXY();
    }

    @Test
    void testGivenIPlayARoundShotFlowIsCalledOnce() {
        //Given: I am a user
        //When: I play a round
        ConsoleInputGetter mockConsoleInputGetter = mock(ConsoleInputGetter.class);
        given(mockConsoleInputGetter.ask("Please enter velocity")).willReturn("7");
        given(mockConsoleInputGetter.ask("Please enter angle")).willReturn("45");
        given(mockTarget.getRandomXY()).willReturn(new int[] {5,5});
        given(mockShotResult.getMessage()).willReturn("lkjdfg");
        given(mockShotResult.isHit()).willReturn(true);
        given(mockShotFlow.flow(7,45,new int[] {5,5})).willReturn(mockShotResult);
        roundFlow.startRound(mockConsoleInputGetter);

        //Then: flow is called once
        verify(mockShotFlow, times(1)).flow(anyInt(), anyInt(), any(int[].class));
    }
}

