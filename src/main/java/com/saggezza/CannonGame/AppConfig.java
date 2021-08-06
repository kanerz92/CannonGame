package com.saggezza.CannonGame;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = "Target")
    public Target createTarget(){
        return  new Target();
    }

    @Bean(name = "ValidateInput")
    public ValidateInput createValidInput(){
        return  new ValidateInput();
    }

    @Bean(name = "Shot")
    public Shot createShot(){
        return  new Shot();
    }

    @Bean(name = "RoundedShot")
    public RoundingShotResult createRounding(){
        return  new RoundingShotResult();
    }

    @Bean(name = "Judge")
    public JudgeClass createJudgeClass(){
        return  new JudgeClass();
    }

    @Bean(name = "Counter")
    public Counter createICounter(){
        return  new Counter();
    }

    @Bean(name = "GameWelcome")
    public GameWelcome createGameWelcome(){
        return new GameWelcome();
    }

    @Bean(name = "PrintPlayers")
    public PrintPlayers createPrintPlayers(){
        return new PrintPlayers();
    }

    @Bean(name = "ConsoleInputGetter")
    public ConsoleInputGetter createConsoleInputGetter(){
        return new ConsoleInputGetter(System.in, System.out);
    }

    @Bean(name = "RoundFlow")
    public RoundFlow createRoundFlow(){
        return
                new RoundFlow(createTarget(), createShotFlow(), createICounter(), createIShotResult());
    }

    @Bean(name = "ShotResult")
    public ShotResult createIShotResult(){
        return new ShotResult();
    }

    @Bean(name = "InsertUserToLeaderBoard")
    public InsertUserToLeaderBoard createInsertPlayerToLeaderBoard(){
        return new InsertUserToLeaderBoard(createMongoDB());
    }

    @Bean(name = "RetrieveUsers")
    public RetrieveUsers createRetrieveScores(){
        return new RetrieveUsers(createMongoDB());
    }

    @Bean(name = "DisplayLeaderboard")
    public ReturnLeaderboard createReturnLeaderboard(){
        return new ReturnLeaderboard(createRetrieveScores());
    }

    @Bean(name = "FiveRoundFlow")
    public FiveRoundFlow createFiveRounds(){
        return new FiveRoundFlow(createRoundFlow(), createTarget(),createICounter(),createInsertPlayerToLeaderBoard(),createRetrieveScores(),createReturnLeaderboard(), createGameWelcome(), createPrintPlayers(), createConsoleInputGetter(), createLogin());
    }

    @Bean(name = "ShotFlow")
    public ShotFlow createShotFlow(){
        return new ShotFlow(createValidInput(), createShot(),createRounding(),createJudgeClass(),createICounter());
    }

    @Bean(name = "Login")
    public Login createLogin(){
        return new Login(createConsoleInputGetter(), createRetrieveScores());
    }

    @Bean(name = "MongoDB")
    public MongoDB createMongoDB() {
        return new MongoDB();
    }
}



