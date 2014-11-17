package com.recursivechaos.xwing.main.objects;

import java.util.Random;

/**
 * @author andrew
 *
 */
public class Dice {

	int roll;

	/**
	 * Returns integer value of roll (1-8)
	 * 
	 * @return
	 */
	public int getRoll() {
		return roll;
	}

	/**
	 * Rolls the dice
	 */
	public void roll() {
		Random random = new Random();
		roll = random.nextInt(8) + 1;
	}

}
