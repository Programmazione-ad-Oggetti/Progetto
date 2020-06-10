package esame.EsameProgrammazione.service;

import java.util.ArrayList;
import java.util.Collection;

import org.json.simple.parser.ParseException;

import esame.EsameProgrammazione.model.Hashtag;
import esame.EsameProgrammazione.model.Tweet;


/////**************************************************************/////
/////  INTERFACCIA CHE METTE A DISPOSIZIONE IL METODO getTweets()  /////
/////**************************************************************/////

/** @author Antonio Colucci
*  @author Carmen Andreozzi
*/

public interface ServTweets {
	
	/////*************************************************************/////
	///// IL METODO getTweets() RESTITUISCE UNA COLLECTION DI TWEETS  /////
	/////*************************************************************/////
	/** 
	 * @return ArrayList di tweets.
	*/
	public abstract Collection<Tweet> getTweets(/*Hashtag hash*/)  /*throws ParseException*/;

}
