package org.agnese.string.interpreter;

import java.util.List;
import java.util.logging.Logger;

/**
 * Decorator che implementa l'interpretazione del separatore "passante" (Step 4)
 * @author Lorenzo Martinelli
 */
class DifferentDelimiterDecorator extends AbstractInterpreterDecorator {
	private final static Logger logger = 
			Logger.getLogger(DifferentDelimiterDecorator.class.getName());

	/**
	 * Costruttore che crea la catena di decorator
	 * @param state lo stato dell'interpretazione
	 */
	DifferentDelimiterDecorator(IInternalState state) {
		super(new NegativeNumbersDecorator(state), state);
	}
	
	@Override
	public List<Integer> evaluate(String numbers) {
		// Se presente estrapolo il delimitatore come previsto da Step 4
		if (numbers.startsWith("//")) {
			int index = numbers.indexOf("\n");
			if (index < 0) {
				logger.severe("La stringa[" + numbers + "] deve contenere \\n");
				throw new IllegalArgumentException();
			}

			getState().setRegEx(numbers.substring(2, index));
			return super.evaluate(numbers.substring(index + 1));
		}
		
		return super.evaluate(numbers);
	}

}
