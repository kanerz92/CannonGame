package com.saggezza.CannonGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class RetrieveScores implements IRetrieveTheScores{

    @Override
    public ArrayList<Player> readScoresFromDB() {
        //Loop through lines
        //Split line on comma
        //Pass name and score into Player
        //Pass player into Set
        ArrayList<Player> players = new ArrayList<Player>();
        MongoDB mongoDB = new MongoDB();
        players = mongoDB.retrieve();
        Collections.sort(players);
        return players;
    }
}