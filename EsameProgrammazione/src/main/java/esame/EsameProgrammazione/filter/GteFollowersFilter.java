package esame.EsameProgrammazione.filter;

import java.util.ArrayList;
import java.util.Calendar;

import com.sun.el.parser.ParseException;

import esame.EsameProgrammazione.model.Tweet;

public class GteFollowersFilter extends FilterParent implements Filter{
	
	public GteFollowersFilter(Object parametro) {
		super(parametro);
	}
	
	@Override
	public boolean filter(Tweet tweet) {
			if (!(tweet.getFollowers() > parametro))
				return false;
		return true;
	}

	@Override
	public boolean filter(ArrayList<String> value, Tweet tweet) {
		return false;
	}

	@Override
	public boolean filter1(ArrayList<Double> value, Tweet tweet) {
		return false;
	}

	@Override
	public boolean filterDate(Calendar data, String data_utente) throws ParseException, java.text.ParseException {
		// TODO Auto-generated method stub
		return false;
	}
}

