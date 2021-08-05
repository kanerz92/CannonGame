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

    @Bean(name = "InsertPlayerToLeaderBoard")
    public InsertPlayerToLeaderBoard createInsertPlayerToLeaderBoard(){
        return new InsertPlayerToLeaderBoard(createMongoDB());
    }

    @Bean(name = "RetrieveScores")
    public RetrieveScores createRetrieveScores(){
        return new RetrieveScores(createMongoDB());
    }

    @Bean(name = "DisplayLeaderboard")
    public ReturnLeaderboard createReturnLeaderboard(){
        return new ReturnLeaderboard(createRetrieveScores());
    }

    @Bean(name = "FiveRoundFlow")
    public FiveRoundFlow createFiveRounds(){
        return new FiveRoundFlow(createRoundFlow(), createTarget(),createICounter(),createInsertPlayerToLeaderBoard(),createRetrieveScores(),createReturnLeaderboard(), createGameWelcome(), createConsoleInputGetter());
    }

    @Bean(name = "ShotFlow")
    public ShotFlow createShotFlow(){
        return new ShotFlow(createValidInput(), createShot(),createRounding(),createJudgeClass(),createICounter());
    }

    @Bean(name = "MongoDB")
    public MongoDB createMongoDB() {
        return new MongoDB();
    }
}



