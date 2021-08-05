package com.saggezza.CannonGame;

import java.util.*;

public class RetrieveScores implements IRetrieveScores {
    MongoDB mongoDB;

    public RetrieveScores(MongoDB mongoDB) {
        this.mongoDB = mongoDB;
    }

    @Override
    public ArrayList<Player> readScoresFromDB() {
        //Loop through lines
        //Split line on comma
        //Pass name and score into Player
        //Pass player into Set
        ArrayList<Player> players = mongoDB.retrieve();
        Collections.sort(players);
        return players;
    }
}