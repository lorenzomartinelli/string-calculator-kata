package org.agnese.string;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Casi di test per l'implementazione dell'interfaccia {@link ICalculator}
 */
public class CalculatorTest {
	/**
	 * Istanza da testare
	 */
	private ICalculator calculator = new Calculator();

    /**
     * Esecuzione dei casi di test positivi: stringhe nulle.</br>
     * Il test verifica <b>Step 1</b>
     */
    @Test
    public void testZero() {
        assertTrue( calculator.add(null) == 0 );
        assertTrue(calculator.add("") == 0);
        assertTrue(calculator.add("    ") == 0);
    }
    
    /**
     * Esecuzione dei casi di test positivi: somme di uno o due numeri</br>
     * Il test verifica <b>Step 1</b>
     */
    @Test
    public void testSum() {
    	assertTrue( calculator.add("1") == 1 );
    	assertTrue( calculator.add("157") == 157 );
        assertTrue( calculator.add("1,2") == 3 );
        assertTrue( calculator.add("18,29") == 47 );
    }
    
    /**
     * Esecuzione dei casi di test positivi: somme di numeri</br>
     * Il test verifica <b>Step 1</b>
     */
    @Test
    public void testSumUnknownAmountOfNumbers() {
    	assertTrue( calculator.add("1,2,3,4,5") == 15 );
        assertTrue( calculator.add("1,3,17,99") == 120 );
        assertTrue( calculator.add("2,1,18,29,1000,3,3447") == 4500 );
    }
}
