package com.recursivechaos.xwing.main;

import java.util.Scanner;

import com.recursivechaos.xwing.main.bo.MoveCalc;
import com.recursivechaos.xwing.main.objects.Engagement;
import com.recursivechaos.xwing.main.objects.Move;
import com.recursivechaos.xwing.main.objects.Player;
import com.recursivechaos.xwing.main.objects.Ship;

/**
 * This class is used to develop the game order mechanics
 * @author abell
 *
 */
public class MainManualTest {
	static Scanner reader = new Scanner(System.in);
	
	/**
	 * Emulates a playthrough of a 2 player game
	 * @param args
	 */
	public static void main(String[] args) {
		// Create players		
		Player playerOne = new Player("Player 1");
		Player playerTwo = new Player("Player 2");
		
		// Create ships
		Ship p1ship = new Ship(-10,0, 0);
		Ship p2ship = new Ship(10,0, 180);
		
		// Attach ships
		playerOne.setShip(p1ship);
		playerTwo.setShip(p2ship);
		
		// Begin game
		while(victoryConditions(playerOne,playerTwo)==false){
			// Player 1 move selection
			Move p1move = getPlayerMove(playerOne);
			// Player 2 move selection
			Move p2move = getPlayerMove(playerTwo);
			// Move ship for player 1
			playerOne.setShip(MoveCalc.moveShip(playerOne.getShip(),p1move));
			// Move ship for player 2
			playerTwo.setShip(MoveCalc.moveShip(playerTwo.getShip(),p2move));
			// Player 1, determine if any ships in firing arc
			Boolean canAttack = playerOne.getShip().canAttack(playerTwo.getShip());
			if(canAttack){
				// assume user wants to attack
				Engagement e1 = new Engagement(playerOne.getShip(),playerTwo.getShip());
				e1.attack();
				playerTwo.setShip(e1.getDefShip());
			}
			// Player 2 attack
			canAttack = playerTwo.getShip().canAttack(playerOne.getShip());
			if(canAttack){
				Engagement e2 = new Engagement(playerTwo.getShip(),playerOne.getShip());
				e2.attack();
				playerOne.setShip(e2.getDefShip());
			}
			
			// Check victory conditions
			
		}
		
	}







	/**
	 * Prompts user for move and returns their move
	 * @param player	player to be prompted
	 * @return	move selected
	 */
	private static Move getPlayerMove(Player player) {
		Move chosenMove = Move.NONE;
		// Open reader
		
		// Prompt player  for move
		System.out.println(player.getName() + " please enter move: ");
		// Player 1 inputs selection
		String rawMove = reader.nextLine();
		// Confirm valid move
		for(Move move : Move.values() ){
			if(move.toString().toUpperCase()==rawMove.toUpperCase()){
				chosenMove = move;
			}
		}
		if(chosenMove.equals(Move.NONE)){
			System.out.println(player.getName() + " has chosen an invalid move.");
			return getPlayerMove(player);
		}
		return chosenMove;
	}

	/**
	 * Given two players, checks to see if victory conditions are met, returning 
	 * true if the game is over
	 * @param playerOne
	 * @param playerTwo
	 * @return true if game is over
	 */
	private static boolean victoryConditions(Player playerOne, Player playerTwo) {
		boolean deceasedPlayer = false;
		if((playerOne.getShip().getHull()<=0)||(playerTwo.getShip().getHull()<=0)){
			deceasedPlayer = true;
		}
		return deceasedPlayer;
	}

}
