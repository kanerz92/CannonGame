package com.saggezza.CannonGame;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class JudgeClassTest {

    @InjectMocks
    JudgeClass judge;

    @Test
    public void testWhenShotIsEqualToTargetJudgeReturnsTrue() {
//      Given: I have a shot and a target
//      When: I pass a shot [4,2] and target [4,2] to the judge
        int[] shot = {3, 7};
        int[] target = {3, 7};
        boolean judgeResult = judge.compareShotAndTarget(target, shot);
//      Then: judgeResult returns true
        assertTrue(judgeResult);
    }

    @Test
    public void testWhenShotHasOneCoordinateOneAwayFromTargetThenJudgeReturnsTrue() {
//      Given: I have a shot and a target
//      When: I pass a shot [4,2] and target [4,3] to the judge
        int[] shot = {4, 2};
        int[] target = {4, 3};
        boolean judgeResult = judge.compareShotAndTarget(target, shot);
//      Then: judgeResult returns true
        assertTrue(judgeResult);
    }

    @Test
    public void testWhenShotHasBothCoordinatesOneAwayFromTargetThenJudgeReturnsTrue() {
//      Given: I have a shot and a target
//      When: I pass a shot [5,2] and target [4,3] to the judge
        int[] shot = {5, 2};
        int[] target = {4, 3};
        boolean judgeResult = judge.compareShotAndTarget(target, shot);
//      Then: judgeResult returns true
        assertTrue(judgeResult);
    }

    @Test
    public void testWhenShotHasOneCoordinateMoreThanOneAwayFromTargetThenJudgeReturnsFalse() {
//      Given: I have a shot and a target
//      When: I pass a shot [8,3] and target [6,3] to the judge
        int[] shot = {8, 3};
        int[] target = {6, 3};
        boolean judgeResult = judge.compareShotAndTarget(target, shot);
//      Then: judgeResult returns true
        assertFalse(judgeResult);
    }

    @Test
    public void testWhenShotHasBothCoordinatesMoreThanOneAwayFromTargetThenJudgeReturnsFalse() {
//      Given: I have a shot and a target
//      When: I pass a shot [7,3] and target [4,9] to the judge
        int[] shot = {7, 3};
        int[] target = {4, 9};
        boolean judgeResult = judge.compareShotAndTarget(target, shot);
//      Then: judgeResult returns true
        assertFalse(judgeResult);
    }
}
