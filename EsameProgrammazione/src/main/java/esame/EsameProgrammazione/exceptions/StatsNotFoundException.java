package esame.EsameProgrammazione.exceptions;

/** 
 * Viene personalizzata un'eccezione che estende ClassNotFoundException
 * 
 * @author Antonio Colucci
 * @author Carmen Andreozzi
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
