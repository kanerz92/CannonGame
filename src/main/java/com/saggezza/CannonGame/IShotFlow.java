package com.saggezza.CannonGame;

public interface IShotFlow {
    ShotResult flow(int velocity, int angle, int[] target);
}
