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
	 * Separatori supportati da {@link Calculator}
	 */
	private static final String SEPARATOR = ",";

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
		
		// Somma della stringa
		String[] addends = numbers.split(getSeparator());
		int result = 0;
		for (int i = 0; i < addends.length; i++) {
			result = result + Integer.parseInt(addends[i]);
		}
		return result;
	}
	

	static String getSeparator() {
		return SEPARATOR;
	}
	
	enum Separators {
		COMMAS(","), NEWLINE("\n");
		
		private String separator;
		
		Separators(String separator) {
			this.separator = separator;
		}
		
		String getSeparator() {
			return this.separator;
		}
	}
}
