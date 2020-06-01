package esame.EsameProgrammazione.exceptions;

/////**************************************************/////
/////   VIENE PERSONALIZZATA UN'ECCEZIONE CHE ESTENDE  /////
/////             ClassNotFoundException               /////
/////**************************************************/////

/** @author Antonio Colucci
* 	@author Carmen Andreozzi
*/

public class StatsNotFoundException extends ClassNotFoundException{
	
	private static final long serialVersionUID = 4L;

	public StatsNotFoundException() {
		super();
	}

	public StatsNotFoundException(String message) {
		super(message);
	}
	
}
