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
    public ValidateInput createValidInpute(){
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

    @Bean(name = "iRoundFlow")
    public RoundFlow createRoundFlow(){
        return new RoundFlow();
    }
    @Bean(name = "iShotResult")
    public ShotResult createShotResult(){
        return new ShotResult();
    }
    @Bean(name = "fiveRoundFlow")
    public FiveRoundFlow createFiveRounds(){
        return new FiveRoundFlow();
    }
    @Bean(name = "iShotFlow")
    public ShotFlow createShotFlow(){
        return new ShotFlow(createValidInpute(), createShot(),createRounding(),createJudgeClass(),createICounter());
    }

}
