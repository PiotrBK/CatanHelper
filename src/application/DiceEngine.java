package application;

import java.util.Random;

public class DiceEngine {

	public int rollDices(){
		
		Random rand = new Random();
		int number = rand.nextInt(6) + 1;
		return number;
		
	}
	
}
