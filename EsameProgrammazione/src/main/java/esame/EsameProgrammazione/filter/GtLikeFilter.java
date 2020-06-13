package esame.EsameProgrammazione.filter;

import java.util.ArrayList;

import esame.EsameProgrammazione.model.Tweet;

public class GtLikeFilter extends FilterParent implements Filter{
	
	public GtLikeFilter(Object parametro) {
		super(parametro);
	}
	
	@Override
	public boolean filter(Tweet tweet) {
			if (!(tweet.getLike() > parametro))
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
	
}
