package com.saggezza.CannonGame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = "iTarget")
    public Target createTarget(){
        return  new Target();
    }
    @Bean(name = "iValidateInput")
    public ValidateInput createValidInput(){
        return  new ValidateInput();
    }
    @Bean(name = "ishot")
    public Shot createShot(){
        return  new Shot();
    }
    @Bean(name = "iroundedShot")
    public RoundingShotResult createRounding(){
        return  new RoundingShotResult();
    }
    @Bean(name = "ijudge")
    public JudgeClass createJudgeClass(){
        return  new JudgeClass();
    }
    @Bean(name = "icounter")
    public Counter createICounter(){
        return  new Counter();
    }

    @Bean(name = "iGameWelcome")
    public GameWelcome createGameWelcome(){
        return new GameWelcome();
    }

    @Bean(name = "iConsoleInputGetter")
    public ConsoleInputGetter createConsoleInputGetter(){
        return new ConsoleInputGetter(System.in, System.out);
    }

    @Bean(name = "iRoundFlow")
    public RoundFlow createRoundFlow(){
        return
                new RoundFlow(createTarget(), createShotFlow(), createICounter(), createIShotResult());
    }
    @Bean(name = "iShotResult")
    public ShotResult createIShotResult(){
        return new ShotResult();
    }

    @Bean(name = "InsertPlayerToLeaderBoard")
    public InsertPlayerToLeaderBoard createInsertPlayerToLeaderBoard(){
        return new InsertPlayerToLeaderBoard();
    }
    @Bean(name = "RetrieveHighScores")
    public RetrieveHighScores createRetrieveHighScores(){
        return new RetrieveHighScores();
    }
    @Bean(name = "DisplayLeaderboard")
    public DisplayLeaderboard createDisplayLeaderboard(){
        return new DisplayLeaderboard();
    }

    @Bean(name = "fiveRoundFlow")
    public FiveRoundFlow createFiveRounds(){
        return new FiveRoundFlow(createRoundFlow(), createTarget(),createICounter(),createInsertPlayerToLeaderBoard(),createRetrieveHighScores(),createDisplayLeaderboard(), createGameWelcome(), createConsoleInputGetter());
    }

    @Bean(name = "iShotFlow")
    public ShotFlow createShotFlow(){
        return new ShotFlow(createValidInput(), createShot(),createRounding(),createJudgeClass(),createICounter());
    }
}
