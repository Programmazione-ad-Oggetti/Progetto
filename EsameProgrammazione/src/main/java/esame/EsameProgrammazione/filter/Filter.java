package esame.EsameProgrammazione.filter;

import esame.EsameProgrammazione.model.Tweet;

/** @author Antonio Colucci
 * 	@author Carmen Andreozzi
 */

public interface Filter {
	
	/////*************************************************************/////
	///// IL METODO filter() RESTITUISCE TRUE SE IL TWEET SODDISFA LE /////
	/////   CONDIZIONI DEL FILTRO CHE IMPLEMENTA QUESTA INTERFACCIA   /////
	/////*************************************************************/////
	
	/** 
	 * @param tweet sul quale si vuole eseguire la verifica.
	 * @return risposta booleana.
	*/
	public boolean filter(Tweet tweet);
}
