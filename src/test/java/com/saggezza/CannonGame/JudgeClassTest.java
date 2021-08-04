package com.saggezza.CannonGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JudgeClassTest {
    @Test
    public void testJudgeClassComparesTargetArrayAndRoundedShotArray() {
//      Given: I need to compare a shot vs a target
        int velocity = 5;
        int angle = 30;
        Shot shot = new Shot();
//      When: I pass a [4,2] target and [4,2] shot to the judge
        double[] result;
        result = shot.computeCoordinates(velocity, angle);
//      Then: the target array and shot array are compared and returns true for a match
        IRoundingShotResult rounding = new RoundingShotResult();
        IJudgeClass judge = new JudgeClass();
        int[] test = {4, 2};
        boolean judgeResult = judge.compareShotAndTarget(test, rounding.roundDoubleValues(result));
        assertTrue(judgeResult);
    }
}
