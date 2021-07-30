package com.saggezza.CannonGame;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Bean;

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
    @Bean(name = "flowClass")
    public FlowClass createFlowClass(){
        return  new FlowClass(createTarget(),createValidInpute(),createShot(),createRounding(),createJudgeClass(), createICounter());
    }


}
