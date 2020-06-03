package esame.EsameProgrammazione.service;

import java.util.Collection;

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
	 * @return Collection di tweets.
	*/
	public abstract Collection<Tweet> getTweets();
}
