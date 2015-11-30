package org.agnese.string.interpreter;

import org.agnese.string.ICalculator.Separators;

/**
 * Method factory che istanzia l'interprete
 * @author Lorenzo Martinelli
 */
public class InterpreterFactory {
	public static IInterpreterComponent getInterpreter() {
		return new EmptyStringDecorator(new InternalState());
	}
	
	/**
	 * POJO che implementa {@link IInternalState}
	 * @author Lorenzo Martinelli
	 */
	private static class InternalState implements IInternalState {
		private String regEx;
		
		private InternalState() {
			// Definisco i separatori di default (Step 3)
			setRegEx(Separators.getAllSeparators());
		}

		public String getRegEx() {
			return this.regEx;
		}

		public void setRegEx(String regEx) {
			this.regEx = regEx;
		}		
	}
}
