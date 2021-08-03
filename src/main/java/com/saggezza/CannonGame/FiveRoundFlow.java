package com.saggezza.CannonGame;

public class FiveRoundFlow {
    public int flow() {
        IRoundFlow roundFlow = new RoundFlow();
        int Counter = 0;
        for (int i = 0; i < 5; i++) {
            int roundCounter = roundFlow.startRound();
            Counter += roundCounter;
        }
        return Counter;
    }
}
