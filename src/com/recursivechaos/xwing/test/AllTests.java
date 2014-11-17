package com.recursivechaos.xwing.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.recursivechaos.xwing.test.bo.MoveCalcTest;
import com.recursivechaos.xwing.test.bo.XmathTest;

@RunWith(Suite.class)
@SuiteClasses({ MoveCalcTest.class, XmathTest.class })
public class AllTests {

}
