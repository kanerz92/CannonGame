package com.saggezza.CannonGame;

import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class RoundFlow implements IRoundFlow {

    ITarget target;
    IShotFlow shotFlow;
    ICounter counter;
    IShotResult shotResult;

    public RoundFlow(ITarget target, IShotFlow shotFlow, ICounter counter, IShotResult shotResult) {
        this.target = target;
        this.shotFlow = shotFlow;
        this.counter = counter;
        this.shotResult = shotResult;
    }

    @Override

    public int startRound(ConsoleInputGetter consoleInputGetter) {
        int[] t1 = new int[2];
        t1 = target.getRandomXY();
        System.out.println(Arrays.toString(t1)+" This is the target coordinates");
        int velocity;
        int angle;
        while (true) {
            //Get shot values
            String velocityInput = consoleInputGetter.ask("Please enter velocity");
            String angleInput = consoleInputGetter.ask("Please enter angle");
            try {
                velocity = Integer.parseInt(velocityInput);
                angle = Integer.parseInt(angleInput);

            } catch (Exception ex) {
                System.out.println("Please enter a number");
                continue;
            }
            shotResult = shotFlow.flow(velocity, angle, t1);
            System.out.println(shotResult.getMessage());
            if (shotResult.isHit()) {
                //return Counter;
                System.out.println("Attempts Taken: " + counter.returnCounter());
                return this.counter.returnCounter();
            }
        }
    }
}

