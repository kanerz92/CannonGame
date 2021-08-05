package com.saggezza.CannonGame;

public class Player implements Comparable<Player>{
    String name;
    int score;


    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return name + "," + score;
    }

    @Override
    public int compareTo(Player player) {
        return this.getScore() - player.getScore();
    }
}
