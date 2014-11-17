package com.recursivechaos.xwing.main.bo;

import java.awt.Point;

public class Xmath {

	/**
	 * Returns the hypotenuse, or the distance between two points, given their deltas
	 * @param deltaX side a length (or deltaX)
	 * @param deltaY side b length (or deltaY)
	 * @return hypotenuse in degrees
	 */
	public static double getHypotenuse(double deltaX, double deltaY) {
		return Math.sqrt(Math.pow(deltaY, 2)+ Math.pow(deltaX,2));
	}
	
	/** 
	 *  Determines the angle of a straight line drawn between point one and two. The number
	 *  returned, which is a double in degrees, tells us how much we have to rotate a horizontal
	 *  line clockwise for it to match the line between the two points. 
	 */ 
	public static double GetAngleOfLineBetweenTwoPoints(Point point, Point point2) 
	{ 
		double xDiff = point2.x - point.x;
		double yDiff = point2.y - point.y;
		
		return Math.toDegrees(Math.atan2(yDiff, xDiff)); 
	}
	
}
