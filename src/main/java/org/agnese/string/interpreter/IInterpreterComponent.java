package org.agnese.string.interpreter;

import java.util.List;

/**
 * Modella l'interfaccia del Component nel pattern Decorator
 * @author Lorenzo Martinelli
 */
public interface IInterpreterComponent {
	/**
	 * Operazione eseguita dai decorator su numbers al fine di definire la lista
	 * di numeri e/o separatori da interpretare secondo le regole definite nel Kata
	 * @param numbers la stringa da interpetare
	 * @return lista di interi da sommare
	 */
	List<Integer> evaluate(String numbers);
}
