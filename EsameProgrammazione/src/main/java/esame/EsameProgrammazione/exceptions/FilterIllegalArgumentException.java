package esame.EsameProgrammazione.exceptions;

/** 
 * Viene personalizzata un'eccezione che estende IllegalArgumentException
 * 
 * @author Antonio Colucci
 * @author Carmen Andreozzi
*/
public class FilterIllegalArgumentException extends IllegalArgumentException{
	
	    private static final long serialVersionUID = 1L;

		public FilterIllegalArgumentException() {
			super();
		}

		public FilterIllegalArgumentException(String message) {
			super(message);
		}
}



