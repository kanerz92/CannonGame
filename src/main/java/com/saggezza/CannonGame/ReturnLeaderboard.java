package com.saggezza.CannonGame;

import java.util.ArrayList;
import java.util.Collections;

public class ReturnLeaderboard implements IReturnLeaderboard{
    RetrieveScores retrieveScores;

    public ReturnLeaderboard(RetrieveScores retrieveScores) {
        this.retrieveScores = retrieveScores;
    }

    @Override
    public ArrayList<Player> returnLeaderboard() {
        ArrayList<Player> leaderboard = new ArrayList<Player>();
        ArrayList<Player> players = retrieveScores.readScoresFromDB();
        Collections.sort(players);
        for (int i = 0; i < Math.min(10, players.size()); i++) {
            leaderboard.add(players.get(i));
        }
        return leaderboard;
    }
}
