package com.saggezza.CannonGame;

import java.util.Arrays;

public class JudgeClass implements IJudgeClass {
    @Override
    public boolean compareShotAndTarget(int[] target, int[] shot) {
        int xDiff = Math.abs(target[0] - shot[0]);
        int yDiff = Math.abs(target[1] - shot[1]);
        return (xDiff <= 1 && yDiff <= 1);
    }
}
