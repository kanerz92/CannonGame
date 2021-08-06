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
    PrintPlayers printPlayers;
    ConsoleInputGetter consoleInputGetter;

    public FiveRoundFlow(IRoundFlow roundFlow, ITarget target, ICounter counter, IinsertPlayerToLeaderBoard insertPlayerToleaderBoard,
                         IRetrieveScores retrieveTheHighScores, IReturnLeaderboard returnLeaderboard, GameWelcome gameWelcome,
                         PrintPlayers printPlayers, ConsoleInputGetter consoleInputGetter) {

        this.roundFlow = roundFlow;
        this.target = target;
        this.counter = counter;
        this.insertPlayerToleaderBoard = insertPlayerToleaderBoard;
        this.retrieveTheHighScores = retrieveTheHighScores;
        this.returnLeaderboard = returnLeaderboard;
        this.gameWelcome = gameWelcome;
        this.printPlayers = printPlayers;
        this.consoleInputGetter = consoleInputGetter;
    }
    public int flow() {

        System.out.println(gameWelcome.getGameWelcome());
        String name = consoleInputGetter.ask("Please enter your name");
        Player player = new Player(name);
        for (int i = 0; i < 1; i++) {
            System.out.println("Round: " + (i + 1));
            roundFlow.startRound(consoleInputGetter);
        }
        System.out.println("Total attempts taken: " + counter.returnCounter());
        player.setScore(counter.returnCounter());
        insertPlayerToleaderBoard.writeTofile(player);
        ArrayList<Player> leaderboard = returnLeaderboard.returnLeaderboard();
        printPlayers.printPlayers(leaderboard);

        return counter.returnCounter();
    }
}
