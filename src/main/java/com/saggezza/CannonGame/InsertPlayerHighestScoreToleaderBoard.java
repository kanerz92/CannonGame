package com.saggezza.CannonGame;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class InsertPlayerHighestScoreToleaderBoard implements IinsertPlayerHighestScoreToleaderBoard {
    @Override
    public void writeTofile(Player player) {
        String name = player.getName();
        int score = player.getScore();
        RetrieveHighScores retrieveHighScores = new RetrieveHighScores();
        ArrayList<Player> playersFromLeaderBoard = retrieveHighScores.readFile();
        playersFromLeaderBoard.add(player);
        Collections.sort(playersFromLeaderBoard);
        String filename="src/main/resources/Leaderboard.txt";
        Path pathToFile = Paths.get(filename);
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filename, false));
            PrintWriter printWriter = new PrintWriter(writer);
            for (int i = 0; i < Math.min(10, playersFromLeaderBoard.size()); i++) {
                printWriter.println(playersFromLeaderBoard.get(i).toString());
            }
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
