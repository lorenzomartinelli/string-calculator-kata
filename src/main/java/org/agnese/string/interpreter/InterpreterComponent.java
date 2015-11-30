package org.agnese.string.interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Istanzia il component del pattern Decorator. Ha la responsabilit&agrave; di
 * ritornare la lista di addendi dopo l'interpretazione finale di <code>numbers</code>;
 * @author Lorenzo Martinelli
 */
class InterpreterComponent implements IInterpreterComponent {
	private final static Logger logger = 
			Logger.getLogger(InterpreterComponent.class.getName());
	private IInternalState state;
	
	InterpreterComponent(IInternalState state) {
		super();
		
		if (state == null) {
			logger.severe("state nullo: non posso istanziare il Component");
			throw new IllegalArgumentException(
				"lo stato nel Component non puo' essere nullo");
		}
		setState(state);
	}

	public List<Integer> evaluate(String numbers) {
		String[] output = numbers.split(getState().getRegEx());
		
		List<Integer> addends = new ArrayList<Integer>();
		for (int i = 0; i < output.length; i++) {
			addends.add(Integer.parseInt(output[i]));
		}
		
		return addends;
	}

	private IInternalState getState() {
		return this.state;
	}
	
	/**
	 * Definisce lo stato dell'interpretazione di <code>addends</code>
	 * @param state lo stato dell'interpretazione
	 */
	private void setState(IInternalState state) {
		this.state = state;
	}
}
