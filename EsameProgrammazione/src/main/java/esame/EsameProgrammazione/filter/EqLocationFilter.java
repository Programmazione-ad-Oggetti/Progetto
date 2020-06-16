package esame.EsameProgrammazione.filter;

import java.util.ArrayList;

import com.sun.el.parser.ParseException;

import esame.EsameProgrammazione.model.OurDate;
import esame.EsameProgrammazione.model.Tweet;

/**
 * Viene controllato se la posizizone ("location") di ogni Tweet 
 * corrisponde con la posizione presa come parametro
 * 
 * @author Colucci Antonio
 * @author Andreozzi Carmen
 */
public class EqLocationFilter extends FilterParentString implements Filter{

	/**
	 * Viene richiamato il costruttore della superclasse
	 * 
	 * @param parametro
	 */
	public EqLocationFilter(Object parametro) {
		super(parametro);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean filter(Tweet tweet) {
		if(!(tweet.getLocation()).equals(parametro))
			return false;
		else return true;
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
	public boolean filterDate(OurDate data) throws ParseException, java.text.ParseException {
		return false;
	}
}
