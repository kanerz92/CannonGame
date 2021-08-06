package com.saggezza.CannonGame;

import java.util.ArrayList;

public class FiveRoundFlow implements IFiveRoundFlow{
    IRoundFlow roundFlow;
    ITarget target;
    ICounter counter;
    IinsertUserToLeaderBoard insertUserToleaderBoard;
    IRetrieveUsers retrieveTheHighScores;
    IReturnLeaderboard returnLeaderboard;
    GameWelcome gameWelcome;
    PrintPlayers printPlayers;
    ConsoleInputGetter consoleInputGetter;
    Login login;

    public FiveRoundFlow(IRoundFlow roundFlow, ITarget target, ICounter counter, IinsertUserToLeaderBoard insertUserToleaderBoard,
                         IRetrieveUsers retrieveTheHighScores, IReturnLeaderboard returnLeaderboard, GameWelcome gameWelcome,
                         PrintPlayers printPlayers, ConsoleInputGetter consoleInputGetter, Login login) {

        this.roundFlow = roundFlow;
        this.target = target;
        this.counter = counter;
        this.insertUserToleaderBoard = insertUserToleaderBoard;
        this.retrieveTheHighScores = retrieveTheHighScores;
        this.returnLeaderboard = returnLeaderboard;
        this.gameWelcome = gameWelcome;
        this.printPlayers = printPlayers;
        this.consoleInputGetter = consoleInputGetter;
        this.login = login;
    }
    public int flow() {

        System.out.println(gameWelcome.getGameWelcome());
        LogInResponse logInResponse= new LogInResponse();
        logInResponse = login.login();
        if (logInResponse.isLoginSuccessful()) {
            for (int i = 0; i < 1; i++) {
                System.out.println("Round: " + (i + 1));
                roundFlow.startRound(consoleInputGetter);
                System.out.println("Total attempts taken: " + counter.returnCounter());
                logInResponse.getUser().setScore(counter.returnCounter());
                insertUserToleaderBoard.writeToLeaderBoard(logInResponse.getUser());
                ArrayList<User> leaderboard = returnLeaderboard.returnLeaderboard();
                printPlayers.printPlayers(leaderboard);
            }
        }
        else {
            System.out.println("Incorrect username/password\nExiting Game");
        }
        return counter.returnCounter();
    }
}
