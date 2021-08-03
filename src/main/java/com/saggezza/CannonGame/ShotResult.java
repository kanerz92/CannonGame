package com.saggezza.CannonGame;

public class ShotResult {
    private boolean isHit = false;
    private String message;

    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
