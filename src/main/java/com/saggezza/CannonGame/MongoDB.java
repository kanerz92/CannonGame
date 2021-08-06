package com.saggezza.CannonGame;
import static com.mongodb.client.model.Filters.all;
import static com.mongodb.client.model.Filters.eq;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
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
        this.collection = mongoDatabase.getCollection("Users");
    }


    @Override
    public void create(User user) {
        String userJson = new Gson().toJson(user);
        Document document = Document.parse(userJson);
        collection.insertOne(document);
    }

    @Override
    public ArrayList<User> retrieveAllUsers() {
        Gson gson = new Gson();
        ArrayList<User> allUsers = new ArrayList<User>();
        FindIterable<Document> result = collection.find();
        result.forEach((Block<Document>) document -> {
            User user = gson.fromJson(document.toJson(), User.class);
            allUsers.add(user);
        });
        return allUsers;
    }

    @Override
    public int retrieveScore(User user) {
        int score;
        Gson gson = new Gson();
        String userJson = gson.toJson(user);
        Document document = new Document("username", user.getUsername());
        FindIterable<Document> result = collection.find(document);
        MongoCursor<Document> cursor = result.iterator();
        try {
            while (cursor.hasNext()) {
                score = gson.fromJson(cursor.next().toJson(), User.class).getScore();
                return score;
            }
        }
        finally {
            cursor.close();
        }
        return 999999;
    }

    public void update(User user) {
        BasicDBObject query = new BasicDBObject();
        query.put("username", user.getUsername());
        query.put("password", user.getPassword());// (1)

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("score", user.getScore()); // (2)

        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", newDocument); // (3)

        collection.updateOne(query, updateObject);
    }
}