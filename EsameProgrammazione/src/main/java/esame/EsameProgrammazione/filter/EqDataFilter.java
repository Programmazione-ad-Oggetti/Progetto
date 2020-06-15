package esame.EsameProgrammazione.filter;

import java.util.ArrayList;

import com.sun.el.parser.ParseException;

import esame.EsameProgrammazione.model.OurDate;
import esame.EsameProgrammazione.model.Tweet;
import esame.EsameProgrammazione.service.DateParser;

/////*******************************************************************/////
/////    VIENE CONTROLLATO SE LA DATA DI OGNI TWEET CORRISPONDE CON   	/////
/////                 LA DATA PRESA COME PARAMETRO                      /////
/////*******************************************************************/////

/** @author Antonio Colucci
* 	@author Carmen Andreozzi
*/

public class EqDataFilter extends FilterParentString implements Filter{
	
		public EqDataFilter(Object parametro) {
			super(parametro);
		}
		
		@Override
		public boolean filterDate(OurDate data) throws ParseException, java.text.ParseException {
			OurDate user_date;
			
			user_date = DateParser.userParsing(parametro);
			
			if( (data.getDay().equals(user_date.getDay())) 
					&& (data.getMonth().equals(user_date.getMonth())) 
					&& (data.getYear().equals(user_date.getYear())) )
				return true;
			
			else  return false;
		}
		
		//METODO DERIVANTE DALL'INTERFACCIA IMPLEMENTATA, CHE IN QUESTO CASO NON FA NIENTE
		@Override
		public boolean filter(ArrayList<String> value, Tweet tweet) {
			return false;
		}

		//METODO DERIVANTE DALL'INTERFACCIA IMPLEMENTATA, CHE IN QUESTO CASO NON FA NIENTE
		@Override
		public boolean filter(Tweet tweet) {
			return false;
		}

		//METODO DERIVANTE DALL'INTERFACCIA IMPLEMENTATA, CHE IN QUESTO CASO NON FA NIENTE
		@Override
		public boolean filter1(ArrayList<Double> value, Tweet tweet) {
			return false;
		}
}
