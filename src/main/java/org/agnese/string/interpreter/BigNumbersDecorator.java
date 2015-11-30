package org.agnese.string.interpreter;

import java.util.ArrayList;
import java.util.List;

import org.agnese.string.ICalculator.Separators;

/**
 * Decorator che implementa il controllo relativo ai numeri maggiori di 1000 (Step 6)
 * @author Lorenzo Martinelli
 */
class BigNumbersDecorator extends AbstractInterpreterDecorator {
	
	/**
	 * Costruttore a cui viene passato lo stato
	 * @param state lo stato dell'interpretazione
	 */
	BigNumbersDecorator(IInternalState state) {
		super(null, state);
	}

	@Override
	public List<Integer> evaluate(String numbers) {
		String[] addends = numbers.split(getState().getRegEx());
		List<String> output = new ArrayList<String>();
		for (int i = 0; i < addends.length; i++) {
			if (Integer.parseInt(addends[i]) <= 1000) {
				output.add(addends[i]);
			}
		}
		
		// Verifico se devo ricomporre numbers senza i numeri maggiori di 1000
		if (output.size() > 0) {
			numbers = output.get(0);
			getState().setRegEx(Separators.getSingleDefaultSeparator());
			
			for (int i = 1; i < output.size(); i++) {
				numbers = numbers + 
					Separators.getSingleDefaultSeparator() + output.get(i);
			}
		}
		
		// Associo il component a questo decorator
		IInterpreterComponent component = new InterpreterComponent(getState());
		setComponent(component);
		return super.evaluate(numbers);
	}
}
