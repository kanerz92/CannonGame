package com.saggezza.CannonGame;

import java.util.Arrays;

public class FlowClass implements IGameFlow {
    ITarget target;
    IValidateInput validator;
    IShot shot;
    IRoundingShotResult rounding;
    IJudgeClass judge;
    ICounter counter;
    int [] generatedValues = new int[2];

    public FlowClass(ITarget target, IValidateInput validator,
                     IShot shot, IRoundingShotResult rounding,
                     IJudgeClass judge, ICounter counter) {

        this.target = target;
        this.validator = validator;
        this.shot = shot;
        this.rounding = rounding;
        this.judge = judge;
        this.counter = counter;

    }

    public int getScore () {
        return this.counter.returnCounter();
 }

    @Override
    public int [] getTargetValues() {
        this.generatedValues= target.getRandomXY();
        return generatedValues;
    }

    @Override
    public String flow(int velocity, int angle) {
        String resultResponse = "";
        int[] randomArr=new int[2];
//       randomArr=generatedValues;
        randomArr[0]=10;
        randomArr[1]=7;


        if (randomArr.length == 2) {
            boolean validateShot = validator.checkInput(velocity, angle);
            if (validateShot) {

                double[] calculatedResults;
                int[] roundResults;
                calculatedResults = shot.computeVelocityAngle(velocity, angle);
                roundResults = rounding.roundDoubleValues(calculatedResults);
                boolean judgeResult = judge.compareShotAndTarget(randomArr, roundResults);
                counter.incrementCounter();
                System.out.println("Attempts counter "+ counter.returnCounter());

                System.out.println("The target was" + Arrays.toString(randomArr) +" " + ("Your shot landed at co-ordinates" + Arrays.toString(roundResults)));
                if (judgeResult) {
                    resultResponse = Integer.toString(counter.returnCounter());
                    System.out.println("A Hit!!!!, counter is "+resultResponse);


                } else {
                    resultResponse = "Please enter another shot";
//                    System.out.println("The new target is located at " + " " +  Arrays.toString(this.getTargetValues()));
                }
            }else {
                System.out.println("Sorry! you entered invalid input. Please velocity between (1 & 20) & Angel between (1 & 90 )");
            }
        }
        return resultResponse;
    }
}


