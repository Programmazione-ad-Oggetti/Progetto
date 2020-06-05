package esame.EsameProgrammazione.filter;

import java.util.ArrayList;

import esame.EsameProgrammazione.model.Tweet;

public class LteLikeFilter implements Filter{
	
	private String field = "favorite_count";
	private String operator = "$lte";

	
	public String getField() {
		return field;
	}


	public String getOperator() {
		return this.operator;
	}
	
	@Override
	public boolean filter(ArrayList<String> value, Tweet tweet) {
		if (!(Double.parseDouble(value.get(0)) > tweet.getLike()))
			return false;
		
		return true;
	}
}
