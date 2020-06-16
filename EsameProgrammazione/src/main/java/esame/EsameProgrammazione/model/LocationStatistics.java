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
 * Classe che recupera il numero di tweet aventi una certa posizione geografica ("location")
 * 
 * @author Colucci Antonio
 * @author Andreozzi Carmen
 */
public class LocationStatistics {
	private int numeroTweetPerLocation;
	
	/**
	 * Costruttore che recupera e conta i tweet aventi una certa posizione geografica
	 * 
	 * @param filter Posizione dei tweet
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
	public LocationStatistics(Object filter, Hashtag hash) throws ParseException, com.sun.el.parser.ParseException, java.text.ParseException, FilterNotFoundException, FilterIllegalArgumentException, MalformedURLException, JSONException, InternalGeneralException {
		
		ArrayList<Tweet> tweets = RecognizeFilter.JsonParserColumn(filter, hash);
		
		numeroTweetPerLocation=tweets.size();
	}
	
	/**
	 * @return Numero di tweet aventi una certa posizione geografica
	 */
	public int getNumeroTweetPerLocation() {
		return numeroTweetPerLocation;
	}
}
