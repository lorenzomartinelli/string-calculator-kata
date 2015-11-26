package org.agnese.string;

/**
 * String calculator
 * @author Lorenzo Martinelli
 */
public interface ICalculator {
	/**
	 * Il metodo permette di sommare fino a due numeri.
	 * Se la stringa &egrave; vuota il risultato ottenuto sar&agrave; 0.
	 * @param numbers lista di numeri da sommare
	 * @return la somma dei numeri
	 */
	int add(String numbers);
}
