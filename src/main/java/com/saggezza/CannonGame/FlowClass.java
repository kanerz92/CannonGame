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

        System.out.println("\033[4;2m" +"This is the target " + Arrays.toString(randomArr));
        if (randomArr.length == 2) {
            boolean validateShot = mockValidator.checkInput(velocity, angle);
            if (validateShot) {
                double[] calculatedResults;
                int[] roundResults;
                calculatedResults = mockShot.computeVelocityAngle(velocity, angle);
                roundResults = mockRounding.roundDoubleValues(calculatedResults);
                boolean judgeResult = mockJudge.compareShotAndTarget(randomArr, roundResults);
                mockCounter.incrementCounter();
                System.out.println(("Your shot landed at coordinates " + Arrays.toString(roundResults)) +" " + "The target was located at "+ Arrays.toString(randomArr));
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


