package com.recursivechaos.xwing.main.objects;

import java.awt.Point;

import com.recursivechaos.xwing.main.bo.TargetingComputer;

public class Ship {
	int x;
	int y;
	int heading;
	int attackArc = 90;
	int attackRange = 15;
	int primaryWeaponValue = 2;
	int agilityValue = 2;
	int hull;

	/**
	 * Creates a ship at x,y coordinates and facing heading
	 * 
	 * @param x
	 *            coordinate
	 * @param y
	 *            coordinate
	 * @param heading
	 *            in degrees
	 */
	public Ship(int x, int y, int heading) {
		this.x = x;
		this.y = y;
		this.heading = heading;
		this.hull = 4;
	}

	/**
	 * Determines if this ship can fire upon the given ship
	 * 
	 * @param enemyShip
	 *            to be attacked
	 * @return true if this ship can attack enemy ship
	 */
	public Boolean canAttack(Ship enemyShip) {
		return TargetingComputer.isInTargetRange(this, enemyShip);
	}

	public int getAgilityValue() {
		return agilityValue;
	}

	public int getAttackArc() {
		return attackArc;
	}

	public int getAttackRange() {
		return attackRange;
	}

	public int getHeading() {
		return heading;
	}

	/**
	 * Returns Point representing ship
	 * 
	 * @return Point of ship
	 */
	public Point getPoint() {
		Point point = new Point();
		point.setLocation(x, y);
		return point;
	}

	public int getPrimaryWeaponValue() {
		return primaryWeaponValue;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setHeading(int heading) {
		this.heading = heading;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHull() {
		return hull;
	}

	public void setHull(int hull) {
		this.hull = hull;
	}
}
