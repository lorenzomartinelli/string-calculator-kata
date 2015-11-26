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
     * Esecuzione dei casi di test positivi: stringhe nulle.
     */
    @Test
    public void testZero() {
        assertTrue( calculator.add(null) == 0 );
        assertTrue(calculator.add("") == 0);
        assertTrue(calculator.add("    ") == 0);
    }
    
    /**
     * Esecuzione dei casi di test positivi: somme di numeri
     */
    @Test
    public void testSum() {
    	assertTrue( calculator.add("1") == 1 );
        assertTrue( calculator.add("1,2") == 3 );
        assertTrue( calculator.add("18,29") == 47 );
    }
}
