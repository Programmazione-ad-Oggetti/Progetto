package esame.EsameProgrammazione.filter;

import java.util.ArrayList;

import com.sun.el.parser.ParseException;

import esame.EsameProgrammazione.model.OurDate;
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
	public boolean filter(ArrayList<String> value, Tweet tweet);
	
	public boolean filterDate(OurDate data) throws ParseException, java.text.ParseException;

	boolean filter(Tweet tweet);

}
