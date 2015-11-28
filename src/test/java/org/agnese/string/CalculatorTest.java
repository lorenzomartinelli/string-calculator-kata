package org.agnese.string;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
    	
    	for (ICalculator.Separators separator : ICalculator.Separators.values()) {
    		assertTrue(calculator.add("1" + 
    			separator.getSeparator() + "2") == 3 );
            assertTrue(calculator.add("18" + 
    			separator.getSeparator() + "29") == 47 );
		}
        
    }
    
    /**
     * Esecuzione dei casi di test positivi: somme di numeri</br>
     * Il test verifica <b>Step 2</b>
     */
    @Test
    public void testSumUnknownAmountOfNumbers() {
    	for (ICalculator.Separators separator : ICalculator.Separators.values()) {
    		assertTrue( calculator.add("1" + 
    			separator.getSeparator() + "2" + 
    			separator.getSeparator() + "3" + 
    			separator.getSeparator() + "4" + 
    			separator.getSeparator() + "5") == 15 );
            assertTrue( calculator.add("1" + 
    			separator.getSeparator() + "3" + 
    			separator.getSeparator() + "17" + 
    			separator.getSeparator() + "99") == 120 );
            assertTrue( calculator.add("2" + 
    			separator.getSeparator() + "1" + 
    			separator.getSeparator() + "18" + 
    			separator.getSeparator() + "29" + 
    			separator.getSeparator() + "1000" + 
    			separator.getSeparator() + "3" + 
    			separator.getSeparator() + "3447") == 4500 );
    	}
    }
    
    @Test
    public void testStep3() {
    	assertTrue( calculator.add("1\n2,3") == 6 );
    	
    	// Anche se non e' da testare...
    	try {
    		calculator.add("1,\n");
    		fail("La stringa non deve essere valida");
		} catch (Exception e) {
			assertTrue(true);
		}
    	
    }
}
