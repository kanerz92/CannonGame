package com.saggezza.CannonGame;

import java.util.ArrayList;

public class FiveRoundFlow implements IFiveRoundFlow{
    IRoundFlow roundFlow;
    ITarget target;
    ICounter counter;
    IinsertPlayerToLeaderBoard insertPlayerToleaderBoard;
    IRetrieveScores retrieveTheHighScores;
    IReturnLeaderboard returnLeaderboard;
    GameWelcome gameWelcome;
    ConsoleInputGetter consoleInputGetter;

    public FiveRoundFlow(IRoundFlow roundFlow, ITarget target, ICounter counter, IinsertPlayerToLeaderBoard insertPlayerToleaderBoard,
                         IRetrieveScores retrieveTheHighScores, IReturnLeaderboard returnLeaderboard, GameWelcome gameWelcome, ConsoleInputGetter consoleInputGetter) {

        this.roundFlow = roundFlow;
        this.target = target;
        this.counter = counter;
        this.insertPlayerToleaderBoard = insertPlayerToleaderBoard;
        this.retrieveTheHighScores = retrieveTheHighScores;
        this.returnLeaderboard = returnLeaderboard;
        this.gameWelcome = gameWelcome;
        this.consoleInputGetter = consoleInputGetter;
    }
    public int flow() {

        System.out.println(gameWelcome.getGameWelcome());
        String name = consoleInputGetter.ask("Please enter your name");
        Player player = new Player(name);
        int Counter = 0;
        for (int i = 0; i < 1; i++) {
            System.out.println("Round: " + (i + 1));
            int roundCounter = roundFlow.startRound(consoleInputGetter);
            Counter += roundCounter;
        }
        System.out.println("Total attempts taken: " + counter.returnCounter());
        player.setScore(Counter);
        insertPlayerToleaderBoard.writeTofile(player);
        System.out.println(returnLeaderboard.returnLeaderboard());

        return Counter;
    }
}
