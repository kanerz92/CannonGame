package com.saggezza.CannonGame;

public class RoundingShotResult implements IRoundingShotResult {


    @Override
    public int[] roundDoubleValues(double[] shot) {
        int[] rounded = new int[2];
        int x = (int) Math.round(shot[0]);
        int y = (int) Math.round(shot[1]);
        rounded[0] = x;
        rounded[1] = y;
        return rounded;
    }
}
