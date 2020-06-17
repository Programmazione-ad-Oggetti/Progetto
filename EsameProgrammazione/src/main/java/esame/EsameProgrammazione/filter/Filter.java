package esame.EsameProgrammazione.filter;

import java.util.ArrayList;

import com.sun.el.parser.ParseException;

import esame.EsameProgrammazione.model.OurDate;
import esame.EsameProgrammazione.model.Tweet;

/** 
 * Interfaccia che possiede tutti i metodi di filtraggio 
 * utilizzati nelle classi che la implementano
 * 
 * @author Antonio Colucci
 * @author Carmen Andreozzi
 */

public interface Filter {
	
	
	/** 
	 * Restituisce "True" se il tweet soddisfa le condizioni 
	 * del filtro che implementa questa interfaccia
	 * 
	 * @param value
	 * @param tweet sul quale si vuole eseguire la verifica.
	 * @return risposta booleana.
	*/
	public boolean filter(ArrayList<String> value, Tweet tweet);
	
	/**
	 * Controlla se la data presa come parametro � uguale a quella di ogni singolo tweet
	 * 
	 * @param data
	 * @return risposta booleana
	 * @throws ParseException
	 * @throws java.text.ParseException
	 */
	public boolean filterDate(OurDate data) throws ParseException, java.text.ParseException;

	/** 
	 * Restituisce "True" se il tweet soddisfa le condizioni 
	 * del filtro che implementa questa interfaccia
	 * 
	 * @param tweet sul quale si vuole eseguire la verifica.
	 * @return risposta booleana.
	*/
	boolean filter(Tweet tweet);

}
