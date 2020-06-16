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
	public abstract Statistics[] VisualizeStats(Object filter, Hashtag hash)  throws MalformedURLException, JSONException;
	public abstract DateStatistics StatsVisualizeDate(Object filter, Hashtag hash) throws MalformedURLException, JSONException ;
	public abstract Statistics VisualizeStatsField(Object filter, String field, Hashtag hash)throws FilterNotFoundException, FilterIllegalArgumentException, MalformedURLException, JSONException, InternalGeneralException, ParseException, StatsNotFoundException;
	public abstract LocationStatistics StatsVisualizeLocation(Object filter, Hashtag hash) throws MalformedURLException, JSONException ;
}

