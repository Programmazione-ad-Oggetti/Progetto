package esame.EsameProgrammazione.filter;

import java.util.ArrayList;

import esame.EsameProgrammazione.model.Tweet;

public class LtLikeFilter implements Filter {
	
	private String field = "favorite_count";
	public String operator = "$lt";
	
	
	public String getField() {
		return field;
	}

	
	public String getOperator() {
		return this.operator;
	}
	
	@Override
	public boolean filter(ArrayList<String> value, ArrayList<Tweet> tweet) {
		for (int i = 0; i < tweet.size(); i++)
			if (!(Double.parseDouble(value.get(0)) >= tweet.get(i).getLike()))
				return false;
		return true;
	}

}

