package esame.EsameProgrammazione.filter;

import java.util.ArrayList;

import com.sun.el.parser.ParseException;

import esame.EsameProgrammazione.model.OurDate;
import esame.EsameProgrammazione.model.Tweet;
import esame.EsameProgrammazione.service.DateParser;

/** 
 * Viene controllato se la data di ogni Tweet corrisponde con la data presa come parametro
 * 
 * @author Antonio Colucci
 * @author Carmen Andreozzi
*/

public class EqDataFilter extends FilterParentString implements Filter{
	/**
	 * Viene richiamato il costruttore della superclasse
	 * 
	 * @param parametro
	 */
	public EqDataFilter(Object parametro) {
		super(parametro);
	}
	
	/**
	 * {@inheritDoc}
	 */
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
	
	/**
	 * Metodo derivante dell'interfaccia implementata, che in questo caso non fa' niente
	 */
	@Override
	public boolean filter(ArrayList<String> value, Tweet tweet) {
		return false;
	}

	/**
	 * Metodo derivante dell'interfaccia implementata, che in questo caso non fa' niente
	 */
	@Override
	public boolean filter(Tweet tweet) {
		return false;
	}
}
