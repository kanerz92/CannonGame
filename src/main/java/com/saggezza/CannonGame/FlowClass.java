package com.saggezza.CannonGame;

import java.util.Arrays;

public class FlowClass implements IGameFlow {
    ITarget mockTarget;
    IValidateInput mockValidator;
    IShot mockShot;
    IRoundingShotResult mockRounding;
    IJudgeClass mockJudge;
    ICounter mockCounter;


    public FlowClass(ITarget mockTarget, IValidateInput mockValidator,
                     IShot mockShot, IRoundingShotResult mockRounding,
                     IJudgeClass mockJudge, ICounter mockCounter) {
        this.mockTarget = mockTarget;
        this.mockValidator = mockValidator;
        this.mockShot = mockShot;
        this.mockRounding = mockRounding;
        this.mockJudge = mockJudge;
        this.mockCounter = mockCounter;
    }

    @Override
    public String flow(int velocity, int angle) {
        String resultResponse = "";
        int[] randomArr;
            randomArr = mockTarget.getRandomXY();
            int [] r = new int[2];
            r[0]=5;
            r[1]=2;
        System.out.println("This is the target" + Arrays.toString(r));
        if (r.length == 2) {

            boolean validateShot = mockValidator.checkInput(velocity, angle);
            if (validateShot) {

                double[] calculatedResults = new double[2];
                int[] roundResults = new int[2];
                calculatedResults = mockShot.computeVelocityAngle(velocity, angle);
                roundResults = mockRounding.roundDoubleValues(calculatedResults);
                boolean judgeResult = mockJudge.compareShotAndTarget(r, roundResults);
                mockCounter.incrementCounter();
                System.out.println("The target was" + Arrays.toString(r) +" " + ("Your shot landed at co-ordinates" + Arrays.toString(roundResults)));
                if (judgeResult) {
                    resultResponse = Integer.toString(mockCounter.returnCounter());

                } else {
                    resultResponse = "Please enter another shot ";
                }
            }else {
                System.out.println("Sorry! You entered an invalid input. Please enter a velocity between (1 & 20) & Angle between (1 & 90 )");
            }
        }
        return resultResponse;
    }
}


