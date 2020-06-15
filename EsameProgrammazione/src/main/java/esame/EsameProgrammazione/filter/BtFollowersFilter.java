package esame.EsameProgrammazione.filter;

import java.util.ArrayList;
import java.util.Calendar;

import com.sun.el.parser.ParseException;

import esame.EsameProgrammazione.model.OurDate;
import esame.EsameProgrammazione.model.Tweet;

public class BtFollowersFilter extends FilterParent implements Filter{
	
	
	
	public BtFollowersFilter (Object parametro) {
		super(parametro);
	}

	@Override
	public boolean filter(Tweet tweet) {
		if( tweet.getFollowers() >= parametro1 & tweet.getFollowers() <= parametro2) {
			return true;
		}
		return false;
	}

	@Override
	public boolean filter(ArrayList<String> value, Tweet tweet) {
		return false;
	}


	@Override
	public boolean filterDate(OurDate data) throws ParseException, java.text.ParseException {
		return false;
	}
}
