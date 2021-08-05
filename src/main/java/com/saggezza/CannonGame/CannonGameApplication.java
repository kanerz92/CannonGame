package com.saggezza.CannonGame;
import static com.mongodb.client.model.Filters.all;
import static com.mongodb.client.model.Filters.eq;

import com.mongodb.client.model.Filters;
import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.print.Doc;
import java.io.IOException;
import java.util.*;
import java.util.logging.FileHandler;
import com.google.gson.Gson;


@SpringBootApplication
public class CannonGameApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        FiveRoundFlow fiveRoundFlow = applicationContext.getBean("fiveRoundFlow", FiveRoundFlow.class);
        fiveRoundFlow.flow();
    }
}


