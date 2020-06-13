package esame.EsameProgrammazione.filter;

import java.util.ArrayList;

import esame.EsameProgrammazione.model.Tweet;

public class GteLikeFilter implements Filter{
	
	private String operator = "$gte";

	private String field = "like";

	
	public String getOperator() {
		return operator;
	}


	public String getField() {
		return field;
	}
	
	
	@Override
	public boolean filter(ArrayList<String> value, Tweet tweet) {
		if (!(Double.parseDouble(value.get(0)) <= tweet.getLike()))
				return false;
		return true;
	}
}
