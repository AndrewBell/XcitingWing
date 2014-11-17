package com.recursivechaos.xwing.main.bo;

import com.recursivechaos.xwing.main.objects.Ship;

/**
 * @author andrew
 *
 */
public class TargetingComputer {

	/**
	 * Returns the angle (in relation to 0 at y axis) of the two ships
	 * 
	 * @param aShip
	 * @param dShip
	 * @return angle in degrees between two ships
	 */
	private static double getAngleBetweenShips(Ship aShip, Ship dShip) {
		return wrap((90 - Xmath.GetAngleOfLineBetweenTwoPoints(
				aShip.getPoint(), dShip.getPoint())));
	}

	/**
	 * Gets the difference between the two ships on X axis (the delta x)
	 * 
	 * @param aShip
	 * @param dShip
	 * @return delta x between two ships in degrees
	 */
	private static double getDeltaX(Ship aShip, Ship dShip) {
		return dShip.getX() - aShip.getX();
	}

	/**
	 * Gets the difference between the two ships on Y axis (the delta y)
	 * 
	 * @param aShip
	 * @param dShip
	 * @return delta y between two ships in degrees
	 */
	private static double getDeltaY(Ship aShip, Ship dShip) {
		return dShip.getY() - aShip.getY();
	}

	/**
	 * Returns the distance between the two ships
	 * 
	 * @param aShip
	 * @param dShip
	 * @return distance between two ships in degrees
	 */
	private static double getDistance(Ship aShip, Ship dShip) {
		// Get deltas
		double deltaX = getDeltaX(aShip, dShip);
		double deltaY = getDeltaY(aShip, dShip);

		// Get hypotenuse
		double dist = Xmath.getHypotenuse(deltaX, deltaY);

		return dist;
	}

	/**
	 * Determines if the attacking ship has the defending ship within it's
	 * attack arc (But NOT whether or not it is within range).
	 * 
	 * @param aShip
	 * @param dShip
	 * @return True if attacking ship has defending ship within it's arc
	 */
	private static boolean inArc(Ship aShip, Ship dShip) {
		// get arc angles
		int startAngle = wrap(aShip.getHeading() - (aShip.getAttackArc() / 2));
		int endAngle = wrap(aShip.getHeading() + (aShip.getAttackArc() * 2));
		double targetAngle = getAngleBetweenShips(aShip, dShip);

		// If the target area encompasses the 0 degree heading, calculate OR
		if ((startAngle + aShip.getAttackArc() > 360)
				|| (endAngle - aShip.getAttackArc() < 0)) {
			if ((targetAngle > startAngle) || (targetAngle < endAngle)) {
				return true;
			}
		} else {// Otherwise calculate AND
			if ((targetAngle > startAngle) && (targetAngle < endAngle)) {
				return true;
			}
		}

		// Otherwise, failure
		return false;
	}

	/**
	 * Determines if the attacking ship is in range to fire on defending ship
	 * (But NOT whether or not if it is in the firing arc).
	 * 
	 * @param aShip
	 *            attacking ship
	 * @param dShip
	 *            defending ship
	 * @return True if attacking ship is in range of defending ship
	 */
	private static boolean inRange(Ship aShip, Ship dShip) {
		// Find distance between two ships
		double dist = getDistance(aShip, dShip);
		// Check if distance is less than the attack range
		if (dist < aShip.getAttackRange()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns whether or not the attacking ship can fire upon the defending
	 * ship, within attacking ships firing arc.
	 * 
	 * @param aShip
	 *            Attacking Ship
	 * @param dShip
	 *            Defending Ship
	 * @return True if attacking ship can fire on defending ship
	 */
	public static Boolean isInTargetRange(Ship aShip, Ship dShip) {
		return ((inArc(aShip, dShip)) && (inRange(aShip, dShip)));
	}

	/**
	 * Wraps numbers above 360 and below 0
	 * 
	 * @param d
	 *            double degree
	 * @return double between 0 and 360, equal to initial location
	 */
	private static double wrap(double d) {
		if (d >= 360) {
			d = d % 360;
		} else if (d < 0) {
			do {
				d += 360;
			} while (d < 0);
		}
		return d;
	}

	/**
	 * Wraps numbers above 360 and below 0
	 * 
	 * @param d
	 *            integer degree
	 * @return int between 0 and 360, equal to initial location
	 */
	private static int wrap(int d) {
		if (d >= 360) {
			d = d % 360;
		} else if (d < 0) {
			do {
				d += 360;
			} while (d < 0);
		}
		return d;
	}

}
