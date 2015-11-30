package org.agnese.string.interpreter;

import java.util.ArrayList;
import java.util.List;

/**
 * Decorator che implementa il controllo della stringa "null" (Step 1)
 * @author Lorenzo Martinelli
 */
class EmptyStringDecorator extends AbstractInterpreterDecorator {

	/**
	 * Costruttore che crea la catena di decorator
	 * @param state lo stato dell'interpretazione
	 */
	EmptyStringDecorator(IInternalState state) {
		super(new DifferentDelimiterDecorator(state), state);
	}

	@Override
	public List<Integer> evaluate(String numbers) {
		// Verifica dello scenario stringa "nulla" (Step 1)
		if (numbers == null || numbers.trim().isEmpty()) {
			List<Integer> addends = new ArrayList<Integer>();
			addends.add(new Integer(0));
			return addends;
		}

		return super.evaluate(numbers);
	}
}
