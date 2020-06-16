package esame.EsameProgrammazione.model;

import java.net.MalformedURLException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

import esame.EsameProgrammazione.exceptions.FilterIllegalArgumentException;
import esame.EsameProgrammazione.exceptions.FilterNotFoundException;
import esame.EsameProgrammazione.exceptions.InternalGeneralException;
import esame.EsameProgrammazione.service.RecognizeFilter;

/**
 * Classe che recupera il numero di tweet scritti in una certa data
 * 
 * @author Colucci Antonio
 * @author Andreozzi Carmen
 */
public class DateStatistics{
	private int numeroTweetPerGiorno;
	
	/**
	 * Costruttore che recupera e conta i tweet scritti in una certa data
	 * 
	 * @param filter Data nella quale sono stati scritti i tweet
	 * @param hash Hashtag inserito
	 * @throws ParseException
	 * @throws com.sun.el.parser.ParseException
	 * @throws java.text.ParseException
	 * @throws FilterNotFoundException
	 * @throws FilterIllegalArgumentException
	 * @throws MalformedURLException
	 * @throws JSONException
	 * @throws InternalGeneralException
	 */
	public DateStatistics(Object filter, Hashtag hash) throws ParseException, com.sun.el.parser.ParseException, java.text.ParseException, FilterNotFoundException, FilterIllegalArgumentException, MalformedURLException, JSONException, InternalGeneralException {
		ArrayList<Tweet> tweets = RecognizeFilter.JsonParserColumn(filter, hash);
		
		numeroTweetPerGiorno=tweets.size();
	}
	
	public int getNumeroTweetPerGiorno() {
		return numeroTweetPerGiorno;
	}
}
