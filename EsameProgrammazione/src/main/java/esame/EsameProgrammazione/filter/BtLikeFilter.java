package esame.EsameProgrammazione.filter;

import java.util.ArrayList;

import esame.EsameProgrammazione.model.Tweet;

public class BtLikeFilter implements Filter{
	private String field = "favorite_count";
	private String operator = "$bt";
	
	public String getField() {
		return field;
	}
	
	public String getOperator() {
		return operator;
	}
	
	
	@Override
	public boolean filter(ArrayList<String> value, ArrayList<Tweet> tweet) {
		double num1 = Double.parseDouble(value.get(0));
		double num2 = Double.parseDouble(value.get(1));
		double min;
		double max; 
		
		if (Math.max(num1, num2) == num1) {
			max = num1;
			min = num2;
		} else {
			max = num2;
			min = num1;
		}
		
		for (int i = 0; i < tweet.size(); i++)
			if (!(min < tweet.get(i).getLike() && max > tweet.get(i).getLike()))
				return false;
		return true;
	}
}
