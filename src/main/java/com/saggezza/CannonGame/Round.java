package com.saggezza.CannonGame;

public class Round {
    ShotFlow shotFlow;
    int[] target;
    boolean isOver;

    public Round(ShotFlow shotFlow, Target target){
        this.shotFlow = shotFlow;
        this.target = target.getRandomXY();
    }


    public ShotResult takeShot(int velocity, int angle) {
        ShotResult shotResult = shotFlow.flow(velocity, angle, target);
        isOver = shotResult.isHit();
        return shotResult;
    }

    public boolean isOver() {
        return isOver;
    }
}
