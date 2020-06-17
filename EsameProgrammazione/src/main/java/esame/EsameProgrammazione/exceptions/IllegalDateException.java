package esame.EsameProgrammazione.exceptions;

/** 
 * Viene personalizzata un'eccezione che estende IllegalArgumentException
 * 
 * @author Antonio Colucci
 * @author Carmen Andreozzi
*/
public class IllegalDateException extends IllegalArgumentException{
	private static final long serialVersionUID = 5L;

	public IllegalDateException() {
		super();
	}

	public IllegalDateException(String message) {
		super(message);
	}
}
