package com.saggezza.CannonGame;

import java.util.Arrays;

public class ShotFlow implements IShotFlow{
    IValidateInput validator;
    IShot shot;
    IRoundingShotResult rounding;
    IJudgeClass judge;
    ICounter counter;


    public ShotFlow(IValidateInput validator,
                     IShot shot, IRoundingShotResult rounding,
                     IJudgeClass judge, ICounter counter) {

        this.validator = validator;
        this.shot = shot;
        this.rounding = rounding;
        this.judge = judge;
        this.counter = counter;
    }

    @Override
    public ShotResult flow(int velocity, int angle, int[] target) {
        ShotResult shotResult = new ShotResult();
        if (target.length == 2) {
            boolean validateShot = validator.checkInput(velocity, angle);
            if (validateShot) {
                double[] calculatedResults = new double[2];
                int[] roundResults = new int[2];
                calculatedResults = shot.computeCoordinates(velocity, angle);
                roundResults = rounding.roundDoubleValues(calculatedResults);
                boolean judgeResult = judge.compareShotAndTarget(target, roundResults);
                counter.incrementCounter();
                String resultString = "The target was " + Arrays.toString(target) +" " + "Your shot landed at co-ordinates" + Arrays.toString(roundResults);
                if (judgeResult) {
                    shotResult.setHit(true);
                    shotResult.setMessage(resultString);
                } else {
                    shotResult.setMessage(resultString + "\nPlease enter another shot");
                }
            }else {
                shotResult.setMessage("Sorry! you entered invalid input. Please enter velocity between (1 & 20) & Angel between (1 & 90 )");
            }
        }
        return shotResult;
    }
}

