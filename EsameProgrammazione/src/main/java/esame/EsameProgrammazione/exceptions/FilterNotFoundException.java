package esame.EsameProgrammazione.exceptions;

/** 
 * Viene personalizzata un'eccezione che estende ClassNotFoundException
 * 
 * @author Antonio Colucci
 * @author Carmen Andreozzi
*/
public class FilterNotFoundException extends ClassNotFoundException{
	
	private static final long serialVersionUID = 2L;

	public FilterNotFoundException() {
		super();
	}

	public FilterNotFoundException(String message) {
		super(message);
	}
	
}
