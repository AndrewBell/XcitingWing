package com.recursivechaos.xwing.main.objects;

import java.util.Collections;
import java.util.List;

public class Engagement {

	private Ship atkShip;
	private Ship defShip;
	private int settledHits;
	
	/**
	 * Creates an engagement between two ships
	 * @param attackingShip
	 * @param defendingShip
	 */
	public Engagement(Ship attackingShip, Ship defendingShip) {
		this.atkShip = attackingShip;
		this.defShip = defendingShip;
	}

	public Ship getAtkShip() {
		return atkShip;
	}

	public Ship getDefShip() {
		return defShip;
	}

	/**
	 * Attacking ship will attempt to do damage to defending ship 
	 */
	public void attack() {
		int atkDice = atkShip.getPrimaryWeaponValue();
		int defDice = defShip.getAgilityValue();
		List<AttackDice> atkRoll = rollAtkDice(atkDice);
		List<DefenseDice> defRoll = rollDefDice(defDice);
		int hits = getHits(atkRoll);
		int dodges = getDodges(defRoll);
		
		if (hits>dodges){
			settledHits = hits-dodges;
			defShip.setHull(defShip.getHull()-settledHits);
		}
	}

	/**
	 * Returns the amount of dodges from the defense Roll
	 * @param defRoll Defense Roll of List<DefenseDice>
	 * @return number of dodges
	 */
	private int getDodges(List<DefenseDice> defRoll) {
		int dodges = 0;
		for(DefenseDice dice : defRoll){
			if(dice.getDiceRoll().equals(DefenseDice.diceFaceOptions.DODGE)){
				dodges++;
			}
		}
		return dodges;
	}

	/**
	 * Returns the amount of hits from the attack roll
	 * @param atkRoll Attack roll of List<AttackRoll>
	 * @return number of doges
	 */
	private int getHits(List<AttackDice> atkRoll) {
		int hits = 0;
		for(AttackDice dice : atkRoll){
			if(dice.getDiceRoll().equals(AttackDice.diceFaceOptions.ATTACK)){
				hits++;
			}
		}
		return hits;
	}

	/**
	 * Rolls the defense dice
	 * @param defDice
	 * @return rolled dice
	 */
	private List<DefenseDice> rollDefDice(int defDice) {
		List<DefenseDice> roll = Collections.emptyList();
		for(int i = defDice; i<defDice; i++){
			DefenseDice dice = new DefenseDice();
			dice.roll();
			roll.add(dice);
		}
		return roll;
	}

	/**
	 * Rolls the attack dice
	 * @param atkDice 
	 * @return rolled dice
	 */
	private List<AttackDice> rollAtkDice(int atkDice) {
		List<AttackDice> roll = Collections.emptyList();
		for(int i = atkDice; i<atkDice; i++){
			AttackDice dice = new AttackDice();
			dice.roll();
			roll.add(dice);
		}
		return roll;
	}

	public int getSettledHits() {
		return settledHits;
	}

}
