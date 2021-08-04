package com.saggezza.CannonGame;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FiveRoundsFlowTest {
    @InjectMocks
    FiveRoundFlow fiveRoundFlow;
    @Mock
    IRoundFlow roundFlow;
    @Mock
    ITarget target;
    @Mock
    ICounter counter;
    @Mock
    IinsertPlayerToLeaderBoard insertPlayerToleaderBoard;
    @Mock
    IRetrieveTheHighScores retrieveTheHighScores;
    @Mock
    IDisplayLeaderboard displayLeaderboard;
    @Mock
    GameWelcome gameWelcome;
    @Mock
    ConsoleInputGetter consoleInputGetter;

    @Test
    void testGivenIPlayGameThenStartRoundCalled5Times() {
        //Given: I am a user
        //When: I play a game
        given(consoleInputGetter.ask("Please enter your name")).willReturn("David");
        fiveRoundFlow.flow();
        //Then: 5 Rounds are played
        verify(roundFlow, times(5)).startRound(consoleInputGetter);
    }

    @Test
    void testGivenIPlayGameThenScoreWrittenToLeaderboard() {
        //Given: I am a user
        //When: I play a game
        given(consoleInputGetter.ask("Please enter your name")).willReturn("David");
        fiveRoundFlow.flow();
        //Then: 5 Rounds are played
        verify(insertPlayerToleaderBoard, times(1)).writeTofile(any(Player.class));
    }

    @Test
    void testGivenIPlayGameThenLeaderboardDisplayed() {
        //Given: I am a user
        //When: I play a game
        given(consoleInputGetter.ask("Please enter your name")).willReturn("David");
        fiveRoundFlow.flow();
        //Then: 5 Rounds are played
        verify(displayLeaderboard, times(1)).displayLeaderboard();
    }
}