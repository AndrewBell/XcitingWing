package com.recursivechaos.xwing.test.bo;

import static org.junit.Assert.*;

import org.junit.Test;

import com.recursivechaos.xwing.main.bo.TargetingComputer;
import com.recursivechaos.xwing.main.objects.Ship;

public class TargetingComputerTest {

	@Test
	public void testIsInTargetRange() {
		// Case 1, in range
		Ship shipA = new Ship(0,0,0);
		Ship shipB = new Ship(1,10,0);
		assertTrue(TargetingComputer.isInTargetRange(shipA, shipB));
		
		// Case 2, out of range, in arc
		Ship shipA2 = new Ship(0,0,0);
		Ship shipB2 = new Ship(1,20,0);
		assertFalse(TargetingComputer.isInTargetRange(shipA2, shipB2));
		
		// Case 3, in range, out of arc
		Ship shipA3 = new Ship(0,0,180);
		Ship shipB3 = new Ship(1,10,0);
		assertFalse(TargetingComputer.isInTargetRange(shipA3, shipB3));
		
	}

}
