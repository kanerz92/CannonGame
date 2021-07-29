package com.saggezza.CannonGame;

public class Counter implements ICounter {
    int result = 1;

    @Override
    public void incrementCounter() {
        result += 1;
    }

    @Override
    public int returnCounter() {
        return result;
    }
}
