package com.saggezza.CannonGame;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.*;
import java.util.logging.FileHandler;


@SpringBootApplication
public class CannonGameApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        FiveRoundFlow fiveRoundFlow = applicationContext.getBean("fiveRoundFlow", FiveRoundFlow.class);
        fiveRoundFlow.flow();
    }
}


