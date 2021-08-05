package com.saggezza.CannonGame;
import static com.mongodb.client.model.Filters.all;
import static com.mongodb.client.model.Filters.eq;

import com.google.gson.Gson;
import com.mongodb.Block;
import com.mongodb.DBCursor;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import org.bson.conversions.Bson;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.print.Doc;
import java.io.IOException;
import java.util.*;
import java.util.logging.FileHandler;


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

    @Override
    public void updatePlayerByName(String name, Player updatedPlayer) {
        String playerJson = new Gson().toJson(updatedPlayer);
        Document document = Document.parse(playerJson);
        collection.updateMany(Filters.eq("name", name), document);
    }

    @Override
    public void delete(Player player) {
        String playerJson = new Gson().toJson(player);
        Document document = Document.parse(playerJson);
        collection.deleteMany(document);
    }
}
