package esame.EsameProgrammazione.filter;

import esame.EsameProgrammazione.model.Tweet;

/////*******************************************************************/////
/////   VIENE CONTROLLATO SE L'HASHTAG DI OGNI TWEET CORRISPONDE CON    /////
/////               L'HASHTAG PRESO COME PARAMETRO                      /////
/////*******************************************************************/////

/** @author Antonio Colucci
* 	@author Carmen Andreozzi
*/

public class HashtagFilter extends FilterParent implements Filter {

	public HashtagFilter(Object parametro) {
		super(parametro);
	}
	
	public boolean filter(Tweet tweet) {
		if(tweet.getHashtag().equals(parametro))
			return true;
		else  return false;
	}

}
