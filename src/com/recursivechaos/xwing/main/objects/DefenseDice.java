package com.recursivechaos.xwing.main.objects;

import java.util.HashMap;
import java.util.Map;

public class DefenseDice extends Dice {

	public enum diceFaceOptions {
		DODGE, FAILDODGE
	}

	private Map<Integer, diceFaceOptions> diceFaces = new HashMap<Integer, diceFaceOptions>();

	/**
	 * Creates a new die
	 */
	public DefenseDice() {
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
		diceFaces.put(1, diceFaceOptions.DODGE);
		diceFaces.put(2, diceFaceOptions.DODGE);
		diceFaces.put(3, diceFaceOptions.DODGE);
		diceFaces.put(4, diceFaceOptions.FAILDODGE);
		diceFaces.put(5, diceFaceOptions.FAILDODGE);
		diceFaces.put(6, diceFaceOptions.FAILDODGE);
		diceFaces.put(7, diceFaceOptions.FAILDODGE);
		diceFaces.put(8, diceFaceOptions.FAILDODGE);
	}

}
