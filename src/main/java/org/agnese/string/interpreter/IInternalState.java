package org.agnese.string.interpreter;

/**
 * POJO che modella lo stato di avanzamento dell'intepretazione della stringa
 * @author Lorenzo Martinelli
 */
interface IInternalState {
	/**
	 * La regular expression da applicare per ottenere i numeri
	 * @return la regular expression
	 */
	String getRegEx();
	
	void setRegEx(String regEx);
}
