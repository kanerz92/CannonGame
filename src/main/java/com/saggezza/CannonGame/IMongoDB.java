package com.saggezza.CannonGame;

import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;

public interface IMongoDB {
    void create(Player player);
    ArrayList<Player> retrieve();
    void updatePlayerByName(String name, Player updatedPlayer);
    void delete(Player player);
}
