package com.saggezza.CannonGame;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


@SpringBootApplication
public class CannonGameApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		IGameFlow flowClass = applicationContext.getBean("flowClass", FlowClass.class);

		System.out.println(" Welcome to Ethan & Mohamed Game! ");
		System.out.println("You are required to enter velocity between (1 & 20) & Angel between (1 & 90 )");
		System.out.println("The target is " + " " +  Arrays.toString(flowClass.getTargetValues()));
		System.out.println("Please enter your two numbers to start the game, your results will be displayed along with the target co-ordinates");
		Scanner sc = new Scanner(System.in);

		while (true) {
			String input = sc.nextLine();
			String input2 = sc.nextLine();
			int velocity;
			int angle;
			try {
				velocity = Integer.parseInt(input);
				angle = Integer.parseInt(input2);
			}
			catch (Exception ex) {
				System.out.println("Please enter a number");
				continue;
			}

			String result = flowClass.flow(velocity, angle);
			System.out.println(result);

		}
	}
}
