package com.saggezza.CannonGame;

import com.google.gson.Gson;
import com.mongodb.Block;
import com.mongodb.client.*;
import org.bson.Document;
import java.util.*;

public class MongoDB implements IMongoDB{
    MongoClient mongoClient;
    MongoDatabase mongoDatabase;
    MongoCollection<Document> collection;

    public MongoDB() {
        this.mongoClient = MongoClients.create();
        this.mongoDatabase = mongoClient.getDatabase("CannonGame");
        this.collection = mongoDatabase.getCollection("People");
    }

    @Override
    public void create(Player player) {
        String playerJson = new Gson().toJson(player);
        Document document = Document.parse(playerJson);
        collection.insertOne(document);
    }

    @Override
    public ArrayList<Player> retrieve() {
        Gson gson = new Gson();
        ArrayList<Player> allPlayers = new ArrayList<Player>();
        FindIterable<Document> result = collection.find();
        result.forEach((Block<Document>) document -> {
            Player player = gson.fromJson(document.toJson(), Player.class);
            allPlayers.add(player);
        });
        return allPlayers;
    }
}
