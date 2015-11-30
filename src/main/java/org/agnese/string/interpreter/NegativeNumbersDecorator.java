package org.agnese.string.interpreter;

import java.util.List;
import java.util.logging.Logger;

/**
 * Decorator che implementa il controllo relativo ai numeri negativi (Step 5)
 * @author Lorenzo Martinelli
 */
class NegativeNumbersDecorator extends AbstractInterpreterDecorator {

	private final static Logger logger = 
			Logger.getLogger(NegativeNumbersDecorator.class.getName());

	/**
	 * Costruttore a cui viene passato lo stato
	 * @param state lo stato dell'interpretazione
	 */
	NegativeNumbersDecorator(IInternalState state) {
		super(new BigNumbersDecorator(state), state);
	}

	@Override
	public List<Integer> evaluate(String numbers) {
		String[] addends = numbers.split(getState().getRegEx());
		for (int i = 0; i < addends.length; i++) {
			if (Integer.parseInt(addends[i]) < 0) {
				String messageError = addends[i];
				for (int j = i + 1; j < addends.length; j++) {
					if (Integer.parseInt(addends[j]) < 0) {
						messageError = messageError.concat(", " +  addends[j]);
					}
				}
				logger.info("La stringa[" + numbers + "] conteneva numeri negativi");
				throw new IllegalArgumentException("negatives not allowed: " + 
					messageError);
			}
		}
		return super.evaluate(numbers);
	}

}
