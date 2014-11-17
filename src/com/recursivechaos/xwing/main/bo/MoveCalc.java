package com.recursivechaos.xwing.main.bo;

import com.recursivechaos.xwing.main.objects.Move;
import com.recursivechaos.xwing.main.objects.Ship;

public class MoveCalc {

	/**
	 * Moves ship
	 * @param ship to be moved
	 * @param move to be played
	 */
	public static Ship moveShip(Ship ship, Move move) {
		switch(move.getTurnType()){
		case STRAIGHT:
			ship = moveStraight(ship,move);
			break;
		case BANK:
			ship = moveTurnAndBank(ship,move);
			break;
		case BROLL:
			break;
		case KTURN:
			break;
		case TURN:
			ship = moveTurnAndBank(ship,move);
			break;
		default:
			break;
		}

		return ship;
	}
	
	/**
	 * Used to calculate turns and banks. Moves ship to destination point, and then 
	 * adjusts heading.
	 * @param ship current ship
	 * @param move current movement
	 * @return	updated ship location and heading
	 */
	private static Ship moveTurnAndBank(Ship ship, Move move) {
		// Find degree/arcs. Degrees are determined by type, since it is constant.
		double totalArc = move.getTurnType().getTurnRadius() + ship.getHeading();
		
		// Find hypotenuse
		int opposite = move.getShift();
		int adjacent = move.getForward();
		double hypotenuse = Xmath.getHypotenuse(opposite, adjacent);
		
		// Find coordinates (opposite and adjacent)
		double y = Math.cos(Math.toRadians(totalArc))*hypotenuse;
		double x = Math.sin(Math.toRadians(totalArc))*hypotenuse;
		
		// Round
		ship.setX((int) Math.round(x)+ship.getX());
		ship.setY((int) Math.round(y)+ship.getY());
		
		// Change heading
		ship = changeHeading(ship,move);
				
		return ship;
	}

	/**
	 * Used to calculate Move.TurnType.STRAIGHT. Moves ship to destination point
	 * @param ship current ship
	 * @param move current movement
	 * @return updated ship location 
	 */
	private static Ship moveStraight(Ship ship, Move move) {
		// All calculations will happen with double precision,
		// and only rounded to int as being set.
		double x;
		double y;

		// Find x
		double xcos = Math.cos(Math.toRadians(ship.getHeading()));
		x = xcos * move.getForward();
		
		// Find y
		double ysin = Math.sin(Math.toRadians(ship.getHeading()));
		y = ysin * move.getForward();
		
		// Round
		ship.setX((int) Math.round(x)+ship.getX());
		ship.setY((int) Math.round(y)+ship.getY());
				
		return ship;
	}
	
	/**
	 * Changes ship direction/heading
	 * @param ship	ship to be moved
	 * @param move action
	 * @return ship with updated heading.
	 */
	private static Ship changeHeading(Ship ship, Move move) {
		int heading = ship.getHeading();
		int delta = move.getTurnClicks();
		int raw = heading + delta;
		int newHeading = raw%360;
		ship.setHeading(newHeading);
		
		return ship;
	}
}
