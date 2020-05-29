package esame.EsameProgrammazione.statistic;

import java.util.ArrayList;

import ch.qos.logback.core.filter.Filter;
import esame.EsameProgrammazione.model.Tweet;
import esame.EsameProgrammazione.service.ServFilter;

public class MakeStats extends Statistics {
	
	Filter filtra;
	ArrayList<Tweet> filteredTweetList = new ArrayList<Tweet>();
	
	//Costruttore della superclasse Statistics
	public MakeStats(ArrayList<Tweet> tweet) {
		super(tweet);
	}
	
	filteredTweetList = filtra.Filtering(tweet, );
	
}
