package esame.EsameProgrammazione.filter;

import static java.util.Calendar.DAY_OF_MONTH;

import java.util.Calendar;

import com.sun.el.parser.ParseException;

import esame.EsameProgrammazione.service.DateParser;

/////*******************************************************************/////
/////    VIENE CONTROLLATO SE LA DATA DI OGNI TWEET CORRISPONDE CON   	/////
/////                 LA DATA PRESA COME PARAMETRO                      /////
/////*******************************************************************/////

/** @author Antonio Colucci
* 	@author Carmen Andreozzi
*/

public class EqDataFilter {
	
		public EqDataFilter() {
		}
		
		public static boolean filter(Calendar data, String data_utente) throws ParseException, java.text.ParseException {
			Calendar user_date;
			
			user_date = DateParser.userDateParsing(data_utente);
			
			if(data.get(DAY_OF_MONTH) == user_date.get(DAY_OF_MONTH))
				return true;
			
			else  return false;
		}
}
