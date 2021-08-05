package com.saggezza.CannonGame;

import java.util.ArrayList;
import java.util.Collections;

public class DisplayLeaderboard implements IDisplayLeaderboard{
    @Override
    public void displayLeaderboard() {
        RetrieveScores retrieveScores = new RetrieveScores();
        ArrayList<Player> players = retrieveScores.readScoresFromDB();
        Collections.sort(players);
        System.out.println("\033[4;2m"+ "This is the current leaderboard");
        for(int i = 0; i < Math.min(10, players.size()); i++){
            System.out.println(players.get(i).toString());
        }
    }
}
