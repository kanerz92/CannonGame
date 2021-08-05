package com.saggezza.CannonGame;

import java.util.ArrayList;

public class PrintPlayers implements IPrintPlayers {

    @Override
    public void printPlayers(ArrayList<Player> players) {
        for (Player player: players) {
            System.out.println(player.toString());
        }
    }
}
