package esame.EsameProgrammazione.filter;

import java.util.ArrayList;

import esame.EsameProgrammazione.model.Tweet;

public class LtLikeFilter implements Filter {
	
	private String field = "like";
	public String operator = "$lt";
	
	
	public String getField() {
		return field;
	}

	
	public String getOperator() {
		return this.operator;
	}
	
	@Override
	public boolean filter(ArrayList<String> value, Tweet tweet) {
		if (!(Double.parseDouble(value.get(0)) >= tweet.getLike()))
			return false;
		
		return true;
	}

}

