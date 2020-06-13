package esame.EsameProgrammazione.service;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import esame.EsameProgrammazione.exceptions.FilterIllegalArgumentException;
import esame.EsameProgrammazione.exceptions.FilterNotFoundException;
import esame.EsameProgrammazione.exceptions.InternalGeneralException;
import esame.EsameProgrammazione.model.DateStatistics;
import esame.EsameProgrammazione.model.Hashtag;
import esame.EsameProgrammazione.model.Statistics;
import esame.EsameProgrammazione.model.Tweet;
import esame.EsameProgrammazione.service.JsonParser;

@Service
public class ServTweetsImpl implements ServTweets{
	public ArrayList<Tweet> TweetList = new ArrayList<Tweet>();
	private Map<Long, Tweet> timeline=new HashMap<>();
	private DateStatistics filteredDateStatistics;
	private Statistics[] filteredStatistics = new Statistics[2];
	
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
	
	@Override
	public Statistics VisualizeStatsField(String filter, String field, Hashtag hash) throws FilterNotFoundException, FilterIllegalArgumentException, MalformedURLException, JSONException, InternalGeneralException, ParseException {
		filteredStatistics[0] = new Statistics(RecognizeFilter.JsonParserColumn(filter, hash), RecognizeField(field));
		return filteredStatistics[0];
	}
	private String RecognizeField(String field) {
		if (field.equals("\"Like\""))
			return "width";
		if (field.equals("\"Followers\""))
			return "height";
		return null;
	}

	//Ritorna le statistiche riferite ai like
	@Override
	public Statistics[] VisualizeStats(String filter, Hashtag hash) throws MalformedURLException, JSONException {
		try {
			filteredStatistics[0] = new Statistics(RecognizeFilter.JsonParserColumn(filter, hash), "Like");
			filteredStatistics[1] = new Statistics(RecognizeFilter.JsonParserColumn(filter, hash), "Followers");
		} 
		catch (FilterNotFoundException | FilterIllegalArgumentException | InternalGeneralException
				| ParseException e) {
			e.printStackTrace();
		}
			
		return filteredStatistics;
	}
	
	//Ritorna le statistiche riferite alla data
	@Override
	public DateStatistics StatsVisualizeDate(String filter, Hashtag hash, String data_utente) throws MalformedURLException, JSONException {
		
		try {
			filteredDateStatistics = new DateStatistics(RecognizeFilter.JsonParserColumn(filter, hash), hash, data_utente);
		} 
		catch (com.sun.el.parser.ParseException | java.text.ParseException | FilterNotFoundException | FilterIllegalArgumentException | InternalGeneralException
				| ParseException e) {

			e.printStackTrace();
		}

			
		return filteredDateStatistics;
	}

}

