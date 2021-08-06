package com.saggezza.CannonGame;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class ReturnLeaderboardTest {
    @Test
    void testGivenNoPlayersThenReturnEmptyLeaderboard() {
        //Given: I am a user
        //When: I want to retrieve the leaderboard and there are no players
        RetrieveScores mockRetrieveScores = mock(RetrieveScores.class);
        given(mockRetrieveScores.readScoresFromDB()).willReturn(new ArrayList<Player>());
        ReturnLeaderboard returnLeaderboard = new ReturnLeaderboard(mockRetrieveScores);
        ArrayList<Player> leaderboard = returnLeaderboard.returnLeaderboard();
        //Then: I receive an empty list of players
        assertEquals(0,leaderboard.size());
    }

    /*To test this further we really need to break the class down more.
    This class is retrieving a list, sorting it and returning the top 10
    Starting to understand why we need small classes for testing purposes

    @Test
    void testGivenOnePlayerThenReturnLeaderboardWithOnePlayer() {
        Given: I am a user
        When: I want to retrieve the leaderboard and there is one player
        Then: I receive a list with one player
    }

    @Test
    void testGiven2PlayersThenReturnSortedLeaderboardWithTwoPlayers() {
        Given: I am a user
        When: I want to retrieve the leaderboard and there are 2 players
        Then: I receive a sorted list with two players
    }

    @Test
    void testGiven10PlayersThenReturnSortedLeaderboardWithTwoPlayers() {
        /iven: I am a user
        When: I want to retrieve the leaderboard and there are 10 players
        Then: I receive a sorted list with ten players
    }

    @Test
    void testGiven11PlayersThenReturnSortedLeaderboardWith10Players() {
        Given: I am a user
        When: I want to retrieve the leaderboard and there are 11 players
        Then: I receive a sorted list with the top 10 players
    }*/
}