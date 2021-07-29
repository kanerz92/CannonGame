package com.saggezza.CannonGame;

import java.util.Arrays;

public class JudgeClass implements IJudgeClass {
    ICounter counter;

    public JudgeClass() {
        counter = new Counter();//Place in flow class
    }

    //Change back to boolean return
    @Override
    public int compareShotAndTarget(int[] target, int[] shot) {
        boolean isShot = (Arrays.equals(target, shot));
        System.out.println(isShot);
        int n = 0;
        if(isShot){
            n = counter.returnCounter();
        }else{
            counter.incrementCounter();
            //More logic
        }
        return n ;
    }
}
