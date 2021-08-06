package com.saggezza.CannonGame;

import java.util.ArrayList;

public interface IMongoDB {
    void create(User user);
    ArrayList<User> retrieveAllUsers();
    int retrieveScore(User user);
    void update(User user);
}
