package com.saggezza.CannonGame;

import java.util.*;

public class RetrieveUsers implements IRetrieveUsers {
    MongoDB mongoDB;

    public RetrieveUsers(MongoDB mongoDB) {
        this.mongoDB = mongoDB;
    }

    @Override
    public ArrayList<User> readUsersFromDB() {
        ArrayList<User> users = mongoDB.retrieveAllUsers();
        return users;
    }
}