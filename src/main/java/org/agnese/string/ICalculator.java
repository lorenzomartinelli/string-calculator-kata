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
	 * Lista di separatori supportati dal calcolatore.
	 * Ha la responsabilit&agrave; di definire i separatori supportati
	 * @author Lorenzo Martinelli
	 */
	enum Separators {
		COMMAS(","), NEWLINE("\n");
		
		private String separator;
		
		Separators(String separator) {
			this.separator = separator;
		}
		
		public String getSeparator() {
			return this.separator;
		}
		
		public static String getSingleDefaultSeparator() {
			return COMMAS.getSeparator();
		}
		
		public static String getAllSeparators() {
			String regEx = "";
			for (ICalculator.Separators separator : ICalculator.Separators.values()) {
				regEx = regEx + separator.getSeparator();
			}
			
			return "[" + regEx + "]";
		}
	}
}
