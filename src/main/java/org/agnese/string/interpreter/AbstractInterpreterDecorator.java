package org.agnese.string.interpreter;

import java.util.List;

/**
 * Implementazione astratta del Decorator. Tale pattern viene applicato al fine
 * di interpretare la stringa <code>numbers</code> ed ha il vantaggio di rendere
 * flessibile l'aggiunta o l'eliminazione di una o pi&ugrave regole interpretative.</br>
 * Un punto di refactor &egrave la "centralizzazione" della catena dei decorator,
 * che in questa implementazione &egrave; distribuita nelle istanze dei decorator 
 * stessi.
 * 
 * @author Lorenzo Martinelli
 */
abstract class AbstractInterpreterDecorator implements IInterpreterComponent {
	/**
	 * Component associato al decorator
	 */
	private IInterpreterComponent component;
	
	/**
	 * Lo stato dell'interpretazione
	 */
	private IInternalState state;
	
	/**
	 * Associo al momento della creazione il component
	 * @param component il component associato al decorator
	 * @param state lo stato utilizzato dal decortator che estende 
	 * 			{@link AbstractInterpreterDecorator}
	 */
	AbstractInterpreterDecorator(IInterpreterComponent component, 
		IInternalState state) {
		super();
		setComponent(component);
		setState(state);
	}

	public List<Integer> evaluate(String numbers) {
		return getComponent().evaluate(numbers);
	}

	
	/**
	 * Il component associato al decorator
	 * @return
	 */
	protected IInterpreterComponent getComponent() {
		return component;
	}
	
	private void setComponent(IInterpreterComponent component) {
		this.component = component;
	}

	protected IInternalState getState() {
		return state;
	}
	
	private void setState(IInternalState state) {
		this.state = state;
	}
}
