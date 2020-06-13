package esame.EsameProgrammazione.filter;

import java.util.ArrayList;

import esame.EsameProgrammazione.model.Tweet;

public class GtLikeFilter implements Filter{
	
	private String field = "like";
	private String operator = "$gt";
	
	public String getField() {
		return field;
	}
	
	public String getOperator() {
		return operator;
	}
	
	
	@Override
	public boolean filter(ArrayList<String> value, Tweet tweet) {
			if (!(tweet.getLike() > Double.parseDouble(value.get(0))))
				return false;
		return true;
	}
	
}
