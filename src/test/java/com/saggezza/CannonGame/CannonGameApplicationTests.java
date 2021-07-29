package com.saggezza.CannonGame;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CannonGameApplicationTests {

	@Test
	void contextLoads() {


		int randX = (int) (Math.random()*11) + 1;
		int randY = (int) (Math.random()*11) + 1;
		int[] target = new int[2];
		target[0] = randX;
		target[1] = randY;

		int angle = 45;
		int velocity = 10;

		int degrees = (int) (angle *(Math.PI/180));
		int x = (int) ((Math.cos(degrees))* velocity);
		int y = (int) ((Math.sin(degrees))* velocity);




	}

}
