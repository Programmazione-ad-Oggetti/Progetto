package esame.EsameProgrammazione.filter;

import java.util.ArrayList;

import com.sun.el.parser.ParseException;

import esame.EsameProgrammazione.model.OurDate;
import esame.EsameProgrammazione.model.Tweet;

public class BtFriendsFilter extends FilterParent implements Filter{
	
	public BtFriendsFilter (Object parametro) {
		super(parametro);
	}

	@Override
	public boolean filter(Tweet tweet) {
		if( tweet.getFriends() >= parametro1 & tweet.getFriends() <= parametro2) {
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
