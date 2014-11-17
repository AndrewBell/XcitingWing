package com.recursivechaos.xwing.main.objects;

import java.util.HashMap;
import java.util.Map;

public class AttackDice extends Dice {

	public enum diceFaceOptions {
		ATTACK, MISS
	}

	private Map<Integer, diceFaceOptions> diceFaces = new HashMap<Integer, diceFaceOptions>();

	/**
	 * Creates a new die
	 */
	public AttackDice() {
		loadDiceFaces();
	}

	/**
	 * Returns dice roll face value
	 * 
	 * @return face value of dice roll
	 */
	public diceFaceOptions getDiceRoll() {
		return diceFaces.get(super.getRoll());
	}

	/**
	 * Each dice face is mapped with a value
	 */
	private void loadDiceFaces() {
		diceFaces.put(1, diceFaceOptions.ATTACK);
		diceFaces.put(2, diceFaceOptions.ATTACK);
		diceFaces.put(3, diceFaceOptions.ATTACK);
		diceFaces.put(4, diceFaceOptions.ATTACK);
		diceFaces.put(5, diceFaceOptions.MISS);
		diceFaces.put(6, diceFaceOptions.MISS);
		diceFaces.put(7, diceFaceOptions.MISS);
		diceFaces.put(8, diceFaceOptions.MISS);
	}

}
