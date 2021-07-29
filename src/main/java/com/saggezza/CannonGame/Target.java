package com.saggezza.CannonGame;

public class Target implements ITarget{


    @Override
    public int[] getRandomXY() {

        int randX = (int) (Math.random()*11) + 1;
        int randY = (int) (Math.random()*11) + 1;
        int[] target = new int[2];
        target[0] = randX;
        target[1] = randY;

        return target;

    }
}
