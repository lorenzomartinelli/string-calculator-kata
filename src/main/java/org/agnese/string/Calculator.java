package org.agnese.string;

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
		
		// Rendo dinamica la lista di separatori
		String regEx = "";
		for (ICalculator.Separators separator : ICalculator.Separators.values()) {
			regEx = regEx + separator.getSeparator();
		}
		
		// Sfrutto le regular expression
		String[] addends = numbers.split("[" + regEx + "]");
		// Somma delle stringhe separate
		int result = 0;
		for (int i = 0; i < addends.length; i++) {
			result = result + Integer.parseInt(addends[i]);
		}
		return result;
	}
}
