package esame.EsameProgrammazione.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import esame.EsameProgrammazione.exceptions.FilterIllegalArgumentException;
import esame.EsameProgrammazione.exceptions.FilterNotFoundException;
import esame.EsameProgrammazione.exceptions.InternalGeneralException;
import esame.EsameProgrammazione.model.DateStatistics;
import esame.EsameProgrammazione.model.Hashtag;
import esame.EsameProgrammazione.model.LikeStatistics;
import esame.EsameProgrammazione.model.Tweet;
import esame.EsameProgrammazione.service.JsonParser;

@Service
public class ServTweetsImpl implements ServTweets{
	//public ArrayList<Tweet> TweetList = new ArrayList<Tweet>();
	private Map<Long, Tweet> timeline=new HashMap<>();
	private LikeStatistics filteredLikeStatistics;
	private DateStatistics filteredDateStatistics;
	
	//Costruttore
	public ServTweetsImpl(Hashtag hash) {
		
		try {
			ArrayList<Tweet> lista = JsonParser.parsingDataset(hash); //Viene richiamata la funzione che effettua il parsing del Json
			
			for(int i = 0; i < lista.size(); i++) {
				Tweet twt = lista.get(i);
				//TweetList.add(twt);
				timeline.put(twt.getID(),twt);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Collection<Tweet> getTweets(/*Hashtag hash*/) /*throws ParseException*/ {
		/*try {
			ArrayList<Tweet> lista = JsonParser.parsingDataset(hash); //Viene richiamata la funzione che effettua il parsing del Json
			
			for(int i = 0; i < lista.size(); i++) {
				Tweet twt = lista.get(i);
				TweetList.add(twt);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		return timeline.values();
	}
	
	//Ritorna le statistiche riferite ai like
	@Override
	public LikeStatistics StatsVisualizeLike(String filter, Hashtag hash) {
		try {
			filteredLikeStatistics = new LikeStatistics(RecognizeFilter.JsonParserColumn(filter, hash));
		} 
		catch (FilterNotFoundException | FilterIllegalArgumentException | InternalGeneralException
				| ParseException e) {
			e.printStackTrace();
		}
			
		return filteredLikeStatistics;
	}
	
	//Ritorna le statistiche riferite alla data
	@Override
	public DateStatistics StatsVisualizeDate(String filter, Hashtag hash) {
		
		try {
			filteredDateStatistics = new DateStatistics(RecognizeFilter.JsonParserColumn(filter, hash), hash, filter);
		} 
		catch (com.sun.el.parser.ParseException | java.text.ParseException | FilterNotFoundException | FilterIllegalArgumentException | InternalGeneralException
				| ParseException e) {

			e.printStackTrace();
		}

			
		return filteredDateStatistics;
	}
}

