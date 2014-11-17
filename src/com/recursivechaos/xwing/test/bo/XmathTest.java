package com.recursivechaos.xwing.test.bo;

import static org.junit.Assert.*;

import org.junit.Test;

import com.recursivechaos.xwing.main.bo.Xmath;

public class XmathTest {

	@Test
	public void testGetHypotenuse() {
		double hyp = Xmath.getHypotenuse(10, 5);
		assertTrue((11.18<hyp)&&(hyp<11.19));
		hyp = Xmath.getHypotenuse(5, 10);
		assertTrue((11.18<hyp)&&(hyp<11.19));
	}

}
