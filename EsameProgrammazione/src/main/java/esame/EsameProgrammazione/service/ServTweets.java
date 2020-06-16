package esame.EsameProgrammazione.service;

import java.net.MalformedURLException;
import java.util.Collection;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

import esame.EsameProgrammazione.exceptions.FilterIllegalArgumentException;
import esame.EsameProgrammazione.exceptions.FilterNotFoundException;
import esame.EsameProgrammazione.exceptions.InternalGeneralException;
import esame.EsameProgrammazione.exceptions.StatsNotFoundException;
import esame.EsameProgrammazione.model.DateStatistics;
import esame.EsameProgrammazione.model.Hashtag;
import esame.EsameProgrammazione.model.LocationStatistics;
import esame.EsameProgrammazione.model.Statistics;
import esame.EsameProgrammazione.model.Tweet;


/////**************************************************************/////
/////  INTERFACCIA CHE METTE A DISPOSIZIONE IL METODO getTweets()  /////
/////**************************************************************/////

/** 
 * Interfaccia che mette a disposizione i metodi per la visualizzazione 
 * della lista completa di tweet e delle diverse statistiche
 * 
 * @author Colucci Antonio
 * @author Andreozzi Carmen
*/

public interface ServTweets {

	/** 
	 * Viene ritornata la lista completa di tweet
	 * 
	 * @return ArrayList di tweets.
	*/
	public abstract Collection<Tweet> getTweets();
	
	/**
	 * Vengono ritornate le statistiche dei tweet secondo un certo filtro
	 * 
	 * @param filter Filtro da applicare
	 * @param hash Hashtag inserito
	 * @return Le statistiche dei tweet secondo un certo filtro
	 * @throws MalformedURLException
	 * @throws JSONException
	 */
	public abstract Statistics[] VisualizeStats(Object filter, Hashtag hash)  
			throws MalformedURLException, JSONException;
	
	/**
	 * Vengono ritornate le statistiche dei tweet di una certa data
	 * 
	 * @param filter Filtro da applicare
	 * @param hash Hashtag inserito
	 * @return Le statistiche riferite ad una certa data
	 * @throws MalformedURLException
	 * @throws JSONException
	 */
	public abstract DateStatistics StatsVisualizeDate(Object filter, Hashtag hash) 
			throws MalformedURLException, JSONException;
	
	/**
	 * Vengono ritornate le statistiche secondo un certo filtro ed un certo campo
	 * 
	 * @param filter Filtro da applicare
	 * @param field Campo delle statistiche
	 * @param hash Hashtag inserito
	 * @return Statistiche riferite ad un certo campo
	 * @throws FilterNotFoundException
	 * @throws FilterIllegalArgumentException
	 * @throws MalformedURLException
	 * @throws JSONException
	 * @throws InternalGeneralException
	 * @throws ParseException
	 * @throws StatsNotFoundException
	 */
	public abstract Statistics VisualizeStatsField(Object filter, String field, Hashtag hash)
			throws FilterNotFoundException, FilterIllegalArgumentException, MalformedURLException, JSONException, InternalGeneralException, ParseException, StatsNotFoundException;
	
	/**
	 * Vengono ritornate le statistiche riferite ad una certa posizione geografica
	 * 
	 * @param filter Filtro da applicare
	 * @param hash Hashtag inserito
	 * @return Statistiche relative ad una certa posizione geografica
	 * @throws MalformedURLException
	 * @throws JSONException
	 */
	public abstract LocationStatistics StatsVisualizeLocation(Object filter, Hashtag hash) 
			throws MalformedURLException, JSONException ;
}