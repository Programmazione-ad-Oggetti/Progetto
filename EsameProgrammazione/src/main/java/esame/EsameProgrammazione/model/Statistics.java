package esame.EsameProgrammazione.model;

import java.util.ArrayList;
import java.util.HashMap;

import esame.EsameProgrammazione.statistic.MakeStats;

public class Statistics extends MakeStats{
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
	 * @param tweet ArrayList usato per calcolare le statistiche
	 * @param field Campo inserito
	 */
	public Statistics(ArrayList<Tweet> tweet, String field) {
		
		this.field = field; 
		//filling the HashMap "statistic" with the different stats of a particular field, calculated on the images contained in the records passed
		statistics.put("min", Min(tweet,field));
		statistics.put("max", Max(tweet,field));
		statistics.put("sum", Sum(tweet,field));
		statistics.put("average", Average(tweet,field));
		statistics.put("variance", Variance(tweet,field));
		statistics.put("standard deviation",Math.pow(Variance(tweet,field),0.5));
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
