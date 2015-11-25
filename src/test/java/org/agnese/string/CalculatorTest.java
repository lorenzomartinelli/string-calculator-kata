package org.agnese.string;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test per {@link ICalculator}
 */
public class CalculatorTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CalculatorTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite(CalculatorTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testAdd()
    {
    	ICalculator calculator = null;
    	
        assertTrue( calculator.add(null) == 0 );
        assertTrue(calculator.add("") == 0);
        assertTrue(calculator.add(" ") == 0);
        
        assertTrue( calculator.add("1") == 1 );
        assertTrue( calculator.add("1,2") == 3 );
    }
}
