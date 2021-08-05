package com.saggezza.CannonGame;

import java.util.ArrayList;
import java.util.Collections;

public class ReturnLeaderboard implements IReturnLeaderboard{
    RetrieveScores retrieveScores;

    public ReturnLeaderboard(RetrieveScores retrieveScores) {
        this.retrieveScores = retrieveScores;
    }

    @Override
    public String returnLeaderboard() {
        String leaderboard = "";
        ArrayList<Player> players = retrieveScores.readScoresFromDB();
        Collections.sort(players);
        leaderboard += "\033[4;2m"+ "This is the current leaderboard\n";
        for(int i = 0; i < Math.min(10, players.size()); i++){
            leaderboard += players.get(i).toString() + "\n";
        }
        return leaderboard;
    }
}
