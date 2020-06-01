package esame.EsameProgrammazione.exceptions;

/////***************************************************/////
/////    VIENE PERSONALIZZATA UN'ECCEZIONE CHE ESTENDE  /////
/////             IllegalArgumentException              /////
/////***************************************************/////

/** @author Antonio Colucci
* 	@author Carmen Andreozzi
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



