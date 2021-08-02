package com.saggezza.CannonGame;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;


@SpringBootApplication
public class CannonGameApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		IGameFlow flowClass = applicationContext.getBean("flowClass", FlowClass.class);

		System.out.println("Welcome to Ethan & Mohamed's Game! ");
		System.out.println("You are required to enter velocity between (1 & 20) & Angle between (1 & 90 )");
		System.out.println("Please enter your two numbers to start the game, your results will be displayed along with the target co-ordinates");
		Scanner sc = new Scanner(System.in);
		while (true) {
			int input = sc.nextInt();
			int input2 = sc.nextInt();
			String result = flowClass.flow(input, input2);
			System.out.println(result);
		}
	}
}