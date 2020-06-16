package esame.EsameProgrammazione.model;

import java.util.ArrayList;
import java.util.HashMap;

import esame.EsameProgrammazione.statistic.MakeStats;

/**
 * Classe che descrive le statistiche
 * 
 * @author Colucci Antonio
 * @author Andreozzi Carmen
 */
public class Statistics extends MakeStats{
	/**
	 * Il campo di una certa statistica
	 */
	private String field;

	/**
	 * Hashmap che contiene il nome della statistica e il rispettivo risultato
	 */
	private HashMap<String, Double> statistics = new HashMap<String, Double>();
	
	/**
	 * Costruttore che inizializza l'hashmap richiamando le funzioni di calcolo delle statistiche
	 * 
	 * @param tweet ArrayList usato per calcolare le statistiche
	 * @param field Campo inserito
	 */
	public Statistics(ArrayList<Tweet> tweet, String field) {
		this.field = field; 
		
		//Inizializzazione della hashmap con i risultati di tutte le statistiche relative a "field"
		statistics.put("min", Min(tweet,field));
		statistics.put("max", Max(tweet,field));
		statistics.put("sum", Sum(tweet,field));
		statistics.put("average", Average(tweet,field));
		statistics.put("variance", Variance(tweet,field));
		statistics.put("standard deviation",Math.pow(Variance(tweet,field),0.5));
	}
	
	/**
	 * @return field
	 */
	public String getField() {
		return field;
	}
	
	/**
	 * @return L'hashmap con le statistiche che sono state calcolate
	 */
	public HashMap<String, Double> getStatistics() {
		return statistics;
	}
}
