package com.saggezza.CannonGame;

public interface IShotResult {
    public boolean isHit();
    public void setHit(boolean hit);
    public String getMessage();
    public void setMessage(String message);
}
