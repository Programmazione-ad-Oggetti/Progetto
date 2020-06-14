package esame.EsameProgrammazione.filter;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.MONTH;

import java.util.ArrayList;
import java.util.Calendar;

import com.sun.el.parser.ParseException;

import esame.EsameProgrammazione.model.Tweet;
import esame.EsameProgrammazione.service.DateParser;

/////*******************************************************************/////
/////    VIENE CONTROLLATO SE LA DATA DI OGNI TWEET CORRISPONDE CON   	/////
/////                 LA DATA PRESA COME PARAMETRO                      /////
/////*******************************************************************/////

/** @author Antonio Colucci
* 	@author Carmen Andreozzi
*/

public class EqDataFilter implements Filter{
	
		public EqDataFilter() {
		}
		
		@Override
		public boolean filterDate(Calendar data, String data_utente) throws ParseException, java.text.ParseException {
			Calendar user_date;
			
			user_date = DateParser.userDateParsing(data_utente);
			
			if((data.get(DAY_OF_MONTH) == user_date.get(DAY_OF_MONTH)) && (data.get(MONTH) == user_date.get(MONTH)))
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
