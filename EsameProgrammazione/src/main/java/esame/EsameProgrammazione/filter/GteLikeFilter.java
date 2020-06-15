package esame.EsameProgrammazione.filter;

import java.util.ArrayList;
import java.util.Calendar;

import com.sun.el.parser.ParseException;

import esame.EsameProgrammazione.model.OurDate;
import esame.EsameProgrammazione.model.Tweet;

/**
 * Classe che effettua il filtraggio dei like, tramite l'operatore "$gte"
 * 
 * @author Colucci Antonio
 * @author Andreozzi Carmen
 */
public class GteLikeFilter extends FilterParent implements Filter{
	
	/**
	 * Viene richiamato il costruttore della superclasse
	 * 
	 * @param parametro
	 */
	public GteLikeFilter(Object parametro) {
		super(parametro);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean filter(Tweet tweet) {
			if (!(tweet.getLike() >= parametro1))
				return false;
		return true;
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
