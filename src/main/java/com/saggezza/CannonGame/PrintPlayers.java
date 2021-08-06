package com.saggezza.CannonGame;

import java.util.ArrayList;

public class PrintPlayers implements IPrintPlayers {

    @Override
    public void printPlayers(ArrayList<User> players) {
        for (User player: players) {
            System.out.println(player.toString());
        }
    }
}
