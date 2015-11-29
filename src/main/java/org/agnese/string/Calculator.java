package org.agnese.string;

import java.util.logging.Logger;

/**
 * Implementazione dell'interfaccia {@link ICalculator}.</br>
 * Ha la responsabilit&agrave; di realizzare un calcolatore che interpreta delle stringhe
 * come addendi e ritorna il risultato dell'addizione.</br>
 * Per le esigenze attuali il livello di visibilit&agrave; dell'intefaccia sufficiente
 * per testarla &egrave; a livello di package.
 * 
 * @author Lorenzo Martinelli
 */
class Calculator implements ICalculator {

	/**
	 * Implementazione del metodo add come da specifiche
	 * Per ora non sono gestite stringhe che non abbiano <code>,</code>
	 * come separatore
	 */
	public int add(String numbers) {
		// Verifica dello scenario stringa "nulla"
		if (numbers == null || numbers.trim().isEmpty()) {
			return 0;
		}
		
		// Istanzio l'interpreste dell'input
		InputInterpreter interpreter = new InputInterpreter(numbers);
		
		// Sfrutto le regular expression per ottenere gli addendi
		String[] addends = interpreter.getNumbers().split(interpreter.getRegEx());
		// Somma delle stringhe separate
		int result = 0;
		for (int i = 0; i < addends.length; i++) {
			if (Integer.parseInt(addends[i]) < 0) {
				String messageError = addends[i];
				for (int j = i + 1; j < addends.length; j++) {
					if (Integer.parseInt(addends[j]) < 0) {
						messageError = messageError.concat(", " + addends[j]);
					}
				}
				throw new IllegalArgumentException("negatives not allowed: " + 
					messageError);
			}
			
			if (Integer.parseInt(addends[i]) <= 1000) {
				result = result + Integer.parseInt(addends[i]);
			}
		}
		return result;
	}
	
	/**
	 * Ha la responsabilit&agrave; di interpretare la stringa di input al fine di
	 * capire se vi &egrave; un separatore
	 * 
	 * @author Lorenzo Martinelli
	 */
	private static class InputInterpreter {
		private final static Logger logger = 
			Logger.getLogger(Calculator.InputInterpreter.class.getName());

		private String numbers;
		private String regEx;

		/**
		 * Ha la responsabilit&agrave; di creare la regular expression necessaria
		 * per otterere gli addendi.</br>
		 * Gestisce sia la lista di separatori supportati che il delimitato passato
		 * dal client: </code>"//[delimiter]\n[numbers...]"</code>
		 * 
		 * @param numbers il parametro di input da interpretare
		 */
		InputInterpreter(String parameter) {
			if (parameter.startsWith("//")) {
				int index = parameter.indexOf("\n");
				if (index < 0) {
					logger.severe("La stringa[" + parameter + "] deve contenere \\n");
					throw new IllegalArgumentException();
				}

				String delimiter = parameter.substring(2, index);

				this.numbers = parameter.substring(index + 1);
				this.regEx = delimiter;
				return;
			}

			// Rendo dinamica la lista di separatori
			String regEx = "";
			for (ICalculator.Separators separator : ICalculator.Separators.values()) {
				regEx = regEx + separator.getSeparator();
			}

			this.numbers = parameter;
			this.regEx = "[" + regEx + "]";
		}

		private String getNumbers() {
			return this.numbers;
		}

		private String getRegEx() {
			return this.regEx;
		}
	}
}
