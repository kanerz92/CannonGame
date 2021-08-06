package com.saggezza.CannonGame;

import java.util.ArrayList;
import java.util.Collections;

public class ReturnLeaderboard implements IReturnLeaderboard{
    RetrieveUsers retrieveScores;

    public ReturnLeaderboard(RetrieveUsers retrieveScores) {
        this.retrieveScores = retrieveScores;
    }

    @Override
    public ArrayList<User> returnLeaderboard() {
        ArrayList<User> leaderboard = new ArrayList<User>();
        ArrayList<User> players = retrieveScores.readUsersFromDB();
        Collections.sort(players);
        for (int i = 0; i < Math.min(10, players.size()); i++) {
            leaderboard.add(players.get(i));
        }
        return leaderboard;
    }
}
