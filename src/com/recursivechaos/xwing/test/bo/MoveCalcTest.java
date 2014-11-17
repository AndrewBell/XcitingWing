package com.recursivechaos.xwing.test.bo;

import static org.junit.Assert.*;

import org.junit.Test;

import com.recursivechaos.xwing.main.bo.MoveCalc;
import com.recursivechaos.xwing.main.objects.Move;
import com.recursivechaos.xwing.main.objects.Ship;

public class MoveCalcTest {

	@Test
	public void testMoveShipForward() {
		// Case 1
		Ship p1ship = new Ship(0,0, 45);
		Ship mShip = MoveCalc.moveShip(p1ship, Move.S5);
		assertEquals(7,mShip.getY());
		assertEquals(7,mShip.getX());
		
		// Case 2
		Ship ship2 = new Ship(0,0,225);
		ship2 = MoveCalc.moveShip(ship2, Move.S5);
		assertEquals(-7,ship2.getX());
		assertEquals(-7,ship2.getY());
		
		// Case 3
		Ship ship3 = MoveCalc.moveShip(new Ship(1,1,225), Move.S5);
		assertEquals(-6,ship3.getX());
		assertEquals(-6,ship3.getY());
	}
	
	@Test
	public void testMoveShipTurn(){
		// Case 1
		Ship ship1 = MoveCalc.moveShip(new Ship(0,0,315), Move.BR3);
		assertEquals(6,ship1.getY());
		assertEquals(-2,ship1.getX());
		assertEquals(0,ship1.getHeading());
		
		// Case 2
		Ship ship2 = MoveCalc.moveShip(new Ship(0,0,90), Move.TR3);
		assertEquals(-6,ship2.getY());
		assertEquals(6,ship2.getX());
		assertEquals(180,ship2.getHeading());
		
		// Case 3
		Ship ship3 = MoveCalc.moveShip(new Ship(0,0,135), Move.TR3);
		assertEquals(-8,ship3.getY());
		assertEquals(0,ship3.getX());
		assertEquals(225,ship3.getHeading());
		
	}
	

}
