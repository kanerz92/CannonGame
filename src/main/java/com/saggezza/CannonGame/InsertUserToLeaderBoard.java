package com.saggezza.CannonGame;

public class InsertUserToLeaderBoard implements IinsertUserToLeaderBoard {
    MongoDB mongoDB;

    public InsertUserToLeaderBoard(MongoDB mongoDB) {
        this.mongoDB = mongoDB;
    }

    @Override
    public void writeToLeaderBoard(User user) {
        if (user.getScore() < mongoDB.retrieveScore(user)) {
            mongoDB.update(user);
        }
    }
}
