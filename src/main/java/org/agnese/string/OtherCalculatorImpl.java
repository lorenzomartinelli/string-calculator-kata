package org.agnese.string;

import java.util.List;

import org.agnese.string.interpreter.IInterpreterComponent;
import org.agnese.string.interpreter.InterpreterFactory;

/**
 * Seconda implementazione dell'interfaccia {@link ICalculator}.</br>
 * Questa seconda implementazione delega a {@link IInterpreterComponent} 
 * l'interpretazione della stringa <code>numbers</code>
 * 
 * @author Lorenzo Martinelli
 */
public class OtherCalculatorImpl implements ICalculator {

	public int add(String numbers) {
		IInterpreterComponent component = InterpreterFactory.getInterpreter();
		List<Integer> addends = component.evaluate(numbers);
		
		int result = 0;
		for (Integer addend : addends) {
			result = result + addend;
		}
		
		return result;
	}

}
