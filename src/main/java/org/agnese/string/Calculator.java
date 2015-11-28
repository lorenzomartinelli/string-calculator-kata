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
	 * Token che va a sostituire tutti i separatori supportati e definiti in
	 * <code>{@link ICalculator.Separators}</code>
	 */
	private static final String TOKEN = "@@@";

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
		
		for (ICalculator.Separators separator : ICalculator.Separators.values()) {
			numbers = numbers.replace(separator.getSeparator(), TOKEN);
		}
		
		// Somma della stringa
		String[] addends = numbers.split(TOKEN);
		int result = 0;
		for (int i = 0; i < addends.length; i++) {
			result = result + Integer.parseInt(addends[i]);
		}
		return result;
	}
}
