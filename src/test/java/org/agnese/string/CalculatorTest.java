package org.agnese.string;

import static org.junit.Assert.assertEquals;
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
	private ICalculator calculator;
	
	public CalculatorTest() {
		// calculator = new Calculator();
		calculator = new OtherCalculatorImpl();
	}

    /**
     * Esecuzione dei casi di test positivi: stringhe nulle.</br>
     * Il test verifica <b>Step 1</b>
     */
    @Test
    public void testNullInput() {
        assertTrue(calculator.add(null) == 0);
        assertTrue(calculator.add("") == 0);
        assertTrue(calculator.add("    ") == 0);
    }
    
    /**
     * Esecuzione dei casi di test positivi: somme di uno o due numeri</br>
     * Il test verifica <b>Step 1</b> per tutti i separatori previsti.
     */
    @Test
    public void testSum() {
    	assertTrue(calculator.add("1") == 1);
    	assertTrue(calculator.add("157") == 157);
    	
    	for (ICalculator.Separators separator : ICalculator.Separators.values()) {
    		assertTrue(calculator.add("1" + 
    			separator.getSeparator() + "2") == 3);
            assertTrue(calculator.add("18" + 
    			separator.getSeparator() + "29") == 47);
		}
        
    }
    
    /**
     * Esecuzione dei casi di test positivi: somme di numeri</br>
     * Il test verifica <b>Step 2</b> per tutti i separatori previsti.
     */
    @Test
    public void testSumUnknownAmountOfNumbers() {
    	for (ICalculator.Separators separator : ICalculator.Separators.values()) {
    		assertTrue(calculator.add("1" + 
    			separator.getSeparator() + "2" + 
    			separator.getSeparator() + "3" + 
    			separator.getSeparator() + "4" + 
    			separator.getSeparator() + "5") == 15);
            assertTrue(calculator.add("1" + 
    			separator.getSeparator() + "3" + 
    			separator.getSeparator() + "17" + 
    			separator.getSeparator() + "99") == 120);
            assertTrue(calculator.add("2" + 
    			separator.getSeparator() + "1" + 
    			separator.getSeparator() + "18" + 
    			separator.getSeparator() + "29" + 
    			separator.getSeparator() + "1000" + 
    			separator.getSeparator() + "3" + 
    			separator.getSeparator() + "447") == 1500);
    	}
    }
    
    /**
     * Esecuzione dei casi di test descritti in <b>Step 3</b>
     */
    @Test
    public void testStep3() {
    	assertTrue(calculator.add("1\n2,3") == 6);
    }
    
    /**
     * Test della stringa <b>non</b> valida definita in <b>Step 3</b>
     * anche se non e' da testare...
     
    @Test
    public void testStepInvalidString() {
    	try {
    		calculator.add("1,\n");
    		fail("La stringa non deve essere valida");
		} catch (Exception e) {
			assertTrue(true);
		}
    }*/
    
    /**
     * Esecuzione dei casi di test descritti in <b>Step 4</b>
     * In particolare aggiungo un delimitatore variabile ovvero:
     * <p><code>"//[delimiter]\n[numbers...]"</code></p>
     */
    @Test
    public void testStepDifferentDelimiters() {
    	assertTrue(calculator.add("//;\n1;2") == 3);
    	assertTrue(calculator.add("//;\n1;2;19;43") == 65);
    	assertTrue(calculator.add("//%%\n1%%2%%19%%43") == 65);
    }
    
    /**
     * Verifico che vada in errore per la mancanza di \n
     */
    @Test(expected = IllegalArgumentException.class) 
    public void testInvalidInput() {
    	calculator.add("//;1;2;19;43");
    }
    
    /**
     * Esecuzione dei casi di test descritti in <b>Step 5</b>, ovvero la gestione
     * dei numeri negativi
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNegativeNumbers() {
    	calculator.add("1,4,-1");
    }
    
    /**
     * Verifica del messaggio di errore in caso di numeri negativi per <b>Step 5</b>
     */
    @Test
    public void testNegativeNumbersExceptionMessage() {
    	try {
    		calculator.add("1,4,-1,5,6,-7,8,-11,3,4,-99");
		} catch (IllegalArgumentException e) {
			assertEquals("La stringa di errore e' sbagliata", 
				"negatives not allowed: -1, -7, -11, -99", 
				e.getMessage());
		}
    }
    
    /**
     * Verifica che i numeri maggiori di 1000 siano omessi come richiesto da
     * <b>Step 6</b>
     */
    @Test
    public void testIgnoreBigNumbers() {
    	for (ICalculator.Separators separator : ICalculator.Separators.values()) {
    		assertTrue(calculator.add("2" + 
    			separator.getSeparator() + "1000") == 1002);
    		assertTrue(calculator.add("2" + 
        			separator.getSeparator() + "1001") == 2);
    		assertTrue(calculator.add("2" + 
        			separator.getSeparator() + "1001" + 
        			separator.getSeparator() + "1000" + 
        			separator.getSeparator() + "1401" + 
        			separator.getSeparator() + "998") == 2000);
    	}	
    }
    
    
}
