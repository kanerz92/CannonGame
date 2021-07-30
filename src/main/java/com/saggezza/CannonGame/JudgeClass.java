package com.saggezza.CannonGame;

import java.util.Arrays;

public class JudgeClass implements IJudgeClass {
    ICounter counter;

    public JudgeClass() {
        counter = new Counter();//Place in flow class
    }

    //Change back to boolean return
    @Override
    public boolean compareShotAndTarget(int[] target, int[] shot) {
        boolean isShot = (Arrays.equals(target, shot));
        if (isShot) {
            return true;
        }
        return false;
    }
}
