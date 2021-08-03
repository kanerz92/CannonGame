package com.saggezza.CannonGame;

import java.util.ArrayList;

public class DisplayLeaderboard implements IDisplayLeaderboard{
    @Override
    public void displayLeaderboard() {
        RetrieveHighScores retrieveHighScores = new RetrieveHighScores();
        ArrayList<Player> playersFromLeaderBoard = retrieveHighScores.readFile();
        System.out.println("\033[4;2m"+ "This is the current leaderboard");
        for(Player p: playersFromLeaderBoard){
            System.out.println( p.toString());
        }
    }
}
