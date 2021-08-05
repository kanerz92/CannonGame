package com.saggezza.CannonGame;

import java.util.ArrayList;

public interface IMongoDB {
    void create(Player player);
    ArrayList<Player> retrieve();
}
