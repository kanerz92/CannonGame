package com.saggezza.CannonGame;

import java.util.Arrays;

public class JudgeClass implements IJudgeClass {

    @Override
    public boolean compareShotAndTarget(int[] target, int[] shot) {
        return (Arrays.equals(target, shot));
    }
}
