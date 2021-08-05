package com.saggezza.CannonGame;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class InsertPlayerToLeaderBoard implements IinsertPlayerToLeaderBoard {
    @Override
    public void writeTofile(Player player) {
        MongoDB mongoDB = new MongoDB();
        mongoDB.create(player);
    }
}
