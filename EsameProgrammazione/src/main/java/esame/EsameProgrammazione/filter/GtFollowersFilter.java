package esame.EsameProgrammazione.filter;

import java.util.ArrayList;

import com.sun.el.parser.ParseException;

import esame.EsameProgrammazione.model.OurDate;
import esame.EsameProgrammazione.model.Tweet;

public class GtFollowersFilter extends FilterParent implements Filter{
	
	public GtFollowersFilter(Object parametro) {
		super(parametro);
	}
	
	@Override
	public boolean filter(Tweet tweet) {
			if (!(tweet.getFollowers() > parametro1))
				return false;
		return true;
	}

	//METODO DERIVANTE DALL'INTERFACCIA IMPLEMENTATA, CHE IN QUESTO CASO NON FA NIENTE
	@Override
	public boolean filter(ArrayList<String> value, Tweet tweet) {
		return false;
	}

	//METODO DERIVANTE DALL'INTERFACCIA IMPLEMENTATA, CHE IN QUESTO CASO NON FA NIENTE
	@Override
	public boolean filterDate(OurDate data) throws ParseException, java.text.ParseException {
		return false;
	}
	
}