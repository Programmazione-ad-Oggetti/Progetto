package esame.EsameProgrammazione.model;

import java.util.ArrayList;
import java.util.HashMap;

import esame.EsameProgrammazione.statistic.MakeStatsLike;

public class LikeStatistics extends MakeStatsLike{
	/**
	 * The field of what the stats where calculated
	 */
	private String field;

	/**
	 * An hashmap to contain the name of the stat and the result calculated
	 */
	private HashMap<String, Double> statistics = new HashMap<String, Double>();
	
	/**
	 * The constructor of the class; it inizialize the hashamap calculating the different stats with the right records
	 * @param recordToPass ArrayList that are used to calculate the stats
	 * @param fieldToPass field passed
	 */
	public LikeStatistics(ArrayList<Tweet> tweet,String field) {
		this.field=field;
		
		//filling the HashMap "statistic" with the different stats of a particular field, calculated on the images contained in the records passed
		statistics.put("min", LikeMin(tweet, this.field));
		statistics.put("max", LikeMax(tweet, this.field));
		statistics.put("sum", LikeSum(tweet, this.field));
		statistics.put("average", LikeAverage(tweet, this.field));
		statistics.put("variance", LikeVariance(tweet, this.field));
		statistics.put("standard deviation",Math.pow(LikeVariance(tweet,this.field),0.5));
	}
	/**
	 * Getter for the statsField
	 * @return the statsField
	 */
	public String getField() {
		return field;
	}
	
	/**
	 * Getter for the hasmap
	 * @return the hasmap with the calculated stats
	 */
	public HashMap<String, Double> getStatistics() {
		return statistics;
	}
	
}
