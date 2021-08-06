package com.saggezza.CannonGame;

public class User implements IUser, Comparable<User>{
    String username;
    String password;
    int score;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return username + "," + score;
    }

    @Override
    public int compareTo(User player) {
        return this.getScore() - player.getScore();
    }
}
