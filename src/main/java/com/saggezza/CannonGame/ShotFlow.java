package com.saggezza.CannonGame;

import java.util.Arrays;

public class ShotFlow implements IShotFlow{
    IValidateInput validator =new ValidateInput();
    IShot shot;
    IRoundingShotResult rounding;
    IJudgeClass judge;
    ICounter counter;
    IRoundFlow roundFlow;


    public ShotFlow(){}
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
        System.out.println("V-----" + velocity);
        System.out.println("A-----" + angle);
        System.out.println("T" +Arrays.toString(target));
        ShotResult shotResult = new ShotResult();
        if (target.length == 2) {
            boolean validateShot = validator.checkInput(velocity, angle);
            if (validateShot) {
                double[] calculatedResults =new double[2];
                int[] roundResults =new int[2];

//                IShot shot = new Shot();
                System.out.println(Arrays.toString(shot.computeVelocityAngle(velocity, angle)));
                calculatedResults = shot.computeVelocityAngle(velocity, angle);
                roundResults = rounding.roundDoubleValues(calculatedResults);
                boolean judgeResult = judge.compareShotAndTarget(target, roundResults);
                counter.incrementCounter();
                shotResult.setMessage("The target was" + Arrays.toString(target) +" " + ("Your shot landed at co-ordinates" + Arrays.toString(roundResults)));
                if (judgeResult) {
                    shotResult.setHit(true);
                    shotResult.setMessage(Integer.toString(counter.returnCounter()));
                } else {
                    shotResult.setMessage("Please enter another shot");
                }
            }else {
                shotResult.setMessage("Sorry! you entered invalid input. Please velocity between (1 & 20) & Angel between (1 & 90 )");
            }
        }
        return shotResult;
    }
}

