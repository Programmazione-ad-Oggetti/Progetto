package esame.EsameProgrammazione.statistic;

import java.util.ArrayList;
import esame.EsameProgrammazione.model.Tweet;

/////***************************************/////
///// CREA UNA LISTA DI TWEET CHE VERRANNO  /////
///// PASSATI AI CALCOLATORI DI STATISTICHE /////
/////***************************************/////

/** @author Antonio Colucci
 *  @author Carmen Andreozzi
 */

public class Statistics {
	
	protected ArrayList<Tweet> tweet;

	public Statistics(ArrayList<Tweet> tweet) {
		this.tweet = tweet;
	}
	
}
