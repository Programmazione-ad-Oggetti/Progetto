package esame.EsameProgrammazione.filter;

import esame.EsameProgrammazione.model.Tweet;

/////*******************************************************************/////
/////    VIENE CONTROLLATO SE LA DATA DI OGNI TWEET CORRISPONDE CON   	/////
/////                 LA DATA PRESA COME PARAMETRO                      /////
/////*******************************************************************/////

/** @author Antonio Colucci
* 	@author Carmen Andreozzi
*/

public class DataFilter extends FilterParent implements Filter {
	
		public DataFilter(Object parametro) {
			super(parametro);
		}
		
		public boolean filter(Tweet tweet) {
			if(tweet.getData().equals(parametro))
				return true;
			else  return false;
		}
}
