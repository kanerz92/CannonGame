package com.saggezza.CannonGame;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Scanner;

public class RoundFlow implements IRoundFlow {

    ITarget target;
    IShotFlow shotFlow;
    ICounter counter;


    @Override
    public int startRound() {
        int[] t1 = new int[2];
       ITarget target = new Target();
               t1=target.getRandomXY();
        System.out.println(Arrays.toString(t1));
        Scanner sc = new Scanner(System.in);
        int velocity;
        int angle;
        while(true) {
            //Get shot values
            String input = sc.nextLine();
            String input2 = sc.nextLine();
            try {
                velocity = Integer.parseInt(input);
                angle = Integer.parseInt(input2);

            } catch (Exception ex) {
                System.out.println("Please enter a number");
                continue;
            }

             IShotFlow shotFlow = new ShotFlow();
               ShotResult shotResult = shotFlow.flow(velocity, angle, t1);
            System.out.println("ShotResult" +shotResult.getMessage());
           this.counter.incrementCounter();
            if (shotResult.isHit()) {
                //return Counter;
                System.out.println(this.counter.returnCounter());
            }
            else {
                System.out.println("please another shot");
//                System.out.println(shotResult.getMessage());
            }
        }
    }
}

