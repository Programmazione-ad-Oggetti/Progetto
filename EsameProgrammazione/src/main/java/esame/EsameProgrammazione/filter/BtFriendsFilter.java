package esame.EsameProgrammazione.filter;

import java.util.ArrayList;

import com.sun.el.parser.ParseException;

import esame.EsameProgrammazione.model.OurDate;
import esame.EsameProgrammazione.model.Tweet;

/**
 * Classe che effettua il filtraggio degli amici ("friends"), tramite l'operatore "$bt"
 * 
 * @author Colucci Antonio
 * @author Andreozzi Carmen
 */
public class BtFriendsFilter extends FilterParent implements Filter{
	
	/**
	 * Viene richiamato il costruttore della superclasse
	 * 
	 * @param parametro
	 */
	public BtFriendsFilter (Object parametro) {
		super(parametro);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean filter(Tweet tweet) {
		if( tweet.getFriends() >= parametro1 & tweet.getFriends() <= parametro2) {
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
