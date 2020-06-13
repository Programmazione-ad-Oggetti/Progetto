package esame.EsameProgrammazione.filter;

import java.util.ArrayList;

import esame.EsameProgrammazione.model.Tweet;

public class BtLikeFilter extends FilterParent implements Filter{
	
	
	
	public BtLikeFilter(Object parametro) {
		super(parametro);
	}

	@Override
	public boolean filter1(ArrayList<Double> value, Tweet tweet) {
		double num1 = value.get(0);
		double num2 = value.get(1);
		double min;
		double max; 
		
		if (Math.max(num1, num2) == num1) {
			max = num1;
			min = num2;
		} else {
			max = num2;
			min = num1;
		}
		
		
		if (!(min < tweet.getLike() && max > tweet.getLike()))
				return false;
		return true;
	}

	@Override
	public boolean filter(Tweet tweet) {
		return false;
	}

	@Override
	public boolean filter(ArrayList<String> value, Tweet tweet) {
		return false;
	}
}
