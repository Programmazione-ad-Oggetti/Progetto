package esame.EsameProgrammazione.filter;

import esame.EsameProgrammazione.model.Tweet;

/////*******************************************************************/////
/////   VIENE CONTROLLATO SE L'HASHTAG DI OGNI TWEET CORRISPONDE CON    /////
/////               L'HASHTAG PRESO COME PARAMETRO                      /////
/////*******************************************************************/////

/** @author Antonio Colucci
* 	@author Carmen Andreozzi
*/

public class EqHashtagFilter extends FilterParent implements Filter {

	public EqHashtagFilter(Object parametro) {
		super(parametro);
	}
	
	public boolean filter(Tweet tweet) {
		boolean flag = true;
		
		for(int i = 0; i<tweet.getHashtag().size(); i++) {
			if(tweet.getHashtag().get(i).getTesto().equals(parametro)) 
				flag = true;
			else  flag = false;
		}
		
		return flag;
	}

}
