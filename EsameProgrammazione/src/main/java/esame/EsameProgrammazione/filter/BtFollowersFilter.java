package esame.EsameProgrammazione.filter;

import java.util.ArrayList;
import java.util.Calendar;

import com.sun.el.parser.ParseException;

import esame.EsameProgrammazione.model.OurDate;
import esame.EsameProgrammazione.model.Tweet;

/**
 * Classe che effettua il filtraggio dei followers, tramite l'operatore "$bt"
 * 
 * @author Colucci Antonio
 * @author Andreozzi Carmen
 */
public class BtFollowersFilter extends FilterParent implements Filter{
	
	/**
	 * Viene richiamato il costruttore della superclasse
	 * 
	 * @param parametro
	 */
	public BtFollowersFilter (Object parametro) {
		super(parametro);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean filter(Tweet tweet) {
		if( tweet.getFollowers() >= parametro1 & tweet.getFollowers() <= parametro2) {
			return true;
		}
		return false;
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
