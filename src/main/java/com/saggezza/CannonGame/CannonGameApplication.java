package com.saggezza.CannonGame;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.*;
import java.util.logging.FileHandler;


@SpringBootApplication
public class CannonGameApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        IGameFlow flowClass = applicationContext.getBean("flowClass", FlowClass.class);
        IRunGameFive runflowClass = applicationContext.getBean("runflowClass", RunGameFive.class);
        Scanner sc = new Scanner(System.in);
        IinsertPlayerHighestScoreToleaderBoard insertPlayerHighestScoreToleaderBoard = new InsertPlayerHighestScoreToleaderBoard();
        IRetrieveTheHighScores retrieveTheHighScores = new RetrieveHighScores();

        System.out.println(" Welcome to Ethan ,Mohamed & David's Game! ");
        System.out.println("You are required to enter velocity between (1 & 20) & Angel between (1 & 90 )");
        System.out.println("Please enter your name");
        String name = sc.nextLine();
        Player player = new Player(name);
        System.out.println("Welcome " +name +" Please enter your two numbers to start the game, your results will be displayed along with the target co-ordinates");

        for (int i = 0; i < 2; i++) {
            System.out.println("Starting Round: " + (i+1));
            flowClass.getTargetValues();
            runflowClass.startGame(flowClass);
        }
        int score = ((FlowClass) flowClass).getScore();
        player.setScore(score);
        insertPlayerHighestScoreToleaderBoard.writeTofile(player);
        System.out.println("Your score is " + score);
        System.out.println();
        ArrayList<Player> highScores = retrieveTheHighScores.readFile();
        IDisplayLeaderboard displayLeaderboard = new DisplayLeaderboard();
        displayLeaderboard.displayLeaderboard();
    }
}


