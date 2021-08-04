package com.saggezza.CannonGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class RetrieveHighScores implements IRetrieveTheHighScores{

    @Override
    public ArrayList<Player> readFile() {
        //Loop through lines
        //Split line on comma
        //Pass name and score into Player
        //Pass player into Set
        ArrayList<Player> playersFromLeaderboard = new ArrayList<Player>();
        String filename="src/main/resources/Leaderboard.txt";
        Path pathToFile = Paths.get(filename);

        try (InputStream in = Files.newInputStream(pathToFile);
             BufferedReader reader =
                     new BufferedReader(new InputStreamReader(in))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] playerDetails = line.split(",");
                Player player = new Player(playerDetails[0]);
                player.setScore(Integer.parseInt(playerDetails[1]));
                playersFromLeaderboard.add(player);
            }
        } catch (IOException x) {
            System.err.println(x);
        }
        Collections.sort(playersFromLeaderboard);
        return playersFromLeaderboard;
    }
}