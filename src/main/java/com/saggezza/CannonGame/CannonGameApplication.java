package com.saggezza.CannonGame;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication
public class CannonGameApplication {

    public static void main(String[] args) {
        ((LoggerContext) LoggerFactory.getILoggerFactory()).getLogger("org.mongodb.driver").setLevel(Level.ERROR);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        FiveRoundFlow fiveRoundFlow = applicationContext.getBean("FiveRoundFlow", FiveRoundFlow.class);
        fiveRoundFlow.flow();
//        MongoDB mongoDB = new MongoDB();
//        User user = new User("David", "password123");
//        user.setScore(18);
//        mongoDB.update(user);
    }
}


