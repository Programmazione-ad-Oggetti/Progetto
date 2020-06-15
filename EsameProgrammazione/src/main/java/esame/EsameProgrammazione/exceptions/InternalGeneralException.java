package esame.EsameProgrammazione.exceptions;

/** 
 * Viene personalizzata un'eccezione che estende Exception
 * 
 * @author Antonio Colucci
 * @author Carmen Andreozzi
*/

public class InternalGeneralException extends Exception {
	
	    private static final long serialVersionUID = 3L;

		public InternalGeneralException() {
			super();
		}

		public InternalGeneralException(String message) {
			super(message); 
		}
}

