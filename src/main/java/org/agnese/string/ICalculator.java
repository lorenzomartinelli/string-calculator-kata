package org.agnese.string;

/**
 * Interfaccia che definisce i metodi previsti dal Kata 
 * <strong>String Calculator Kata</strong>
 * @author Lorenzo Martinelli
 */
public interface ICalculator {
	/**
	 * Il metodo permette di sommare fino a due numeri separati da ,.</br>
	 * Se la stringa &egrave; vuota il risultato ottenuto &egrave; 0.
	 * @param numbers lista di numeri da sommare
	 * @return la somma dei numeri
	 */
	int add(String numbers);
	
	/**
	 * Lista di separatori supportati dal calcolatore
	 * @author Lorenzo Martinelli
	 */
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
