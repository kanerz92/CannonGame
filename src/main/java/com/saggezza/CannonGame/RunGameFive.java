package com.saggezza.CannonGame;

import java.util.Scanner;

public class RunGameFive implements IRunGameFive{
    IGameFlow flow;

    public RunGameFive(IGameFlow flow) {
        this.flow = flow;
    }

    @Override
    public void startGame(IGameFlow flow) {
        Scanner sc = new Scanner(System.in);
            while (true) {
                String input = sc.nextLine();
                String input2 = sc.nextLine();
                int velocity;
                int angle;
                try {
                    velocity = Integer.parseInt(input);
                    angle = Integer.parseInt(input2);
                } catch (Exception ex) {
                    System.out.println("Please enter a number");
                    continue;
                }

                String result = flow.flow(velocity, angle);
                System.out.println(result);
                try {
                    Integer.parseInt(result);
                    break;
                }
                catch (Exception ex) {
                }
            }
        }

    }


