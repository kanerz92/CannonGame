package com.saggezza.CannonGame;

public class InsertPlayerToLeaderBoard implements IinsertPlayerToLeaderBoard {
    MongoDB mongoDB;

    public InsertPlayerToLeaderBoard(MongoDB mongoDB) {
        this.mongoDB = mongoDB;
    }

    @Override
    public void writeTofile(Player player) {
        mongoDB.create(player);
    }
}
