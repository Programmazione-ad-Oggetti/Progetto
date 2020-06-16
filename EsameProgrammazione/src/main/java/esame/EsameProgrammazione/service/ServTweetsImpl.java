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
import esame.EsameProgrammazione.exceptions.StatsNotFoundException;
import esame.EsameProgrammazione.model.DateStatistics;
import esame.EsameProgrammazione.model.Hashtag;
import esame.EsameProgrammazione.model.LocationStatistics;
import esame.EsameProgrammazione.model.Statistics;
import esame.EsameProgrammazione.model.Tweet;

/**
 * Classe che implementa i metodi dell'interfaccia ServTweets
 * 
 * @author Colucci Antonio
 * @author Andreozzi Carmen
 */
@Service
public class ServTweetsImpl implements ServTweets{
	public ArrayList<Tweet> TweetList = new ArrayList<Tweet>();
	private Map<Long, Tweet> timeline=new HashMap<>();
	private DateStatistics filteredDateStatistics;
	private LocationStatistics filteredLocationStatistics;
	private Statistics[] filteredStatistics = new Statistics[3];
	
	/**
	 * Costruttore che richiama il parsing del JSON e riempe la hashmap di tweet
	 * 
	 * @param hash Hashtag inserito
	 */
	public ServTweetsImpl(Hashtag hash) {
		
		try {
			//Viene richiamata la funzione che effettua il parsing del JSON
			ArrayList<Tweet> lista = JsonParser.parsingDataset(hash); 
			
			for(int i = 0; i < lista.size(); i++) {
				Tweet twt = lista.get(i);
				timeline.put(twt.getID(),twt);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Secondo costruttore usato nei test, per evitare il download dei tweet
	 */
	public ServTweetsImpl(){
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<Tweet> getTweets() {
		
		return timeline.values();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Statistics VisualizeStatsField(Object filter, String field, Hashtag hash) throws FilterNotFoundException, FilterIllegalArgumentException, MalformedURLException, JSONException, InternalGeneralException, ParseException, StatsNotFoundException {
		filteredStatistics[0] = new Statistics(RecognizeFilter.JsonParserColumn(filter, hash), RecognizeField(field));
		return filteredStatistics[0];
	}
	
	/**
	 * Viene riconosciuto il campo da utilizzare per le statistiche
	 * 
	 * @param field Campo
	 * @return Campo da utilizzare nelle statistiche
	 * @throws StatsNotFoundException
	 */
	public String RecognizeField(String field) throws StatsNotFoundException{
		if (field.equals("\"Like\""))
			return "Like";
		if (field.equals("\"Followers\""))
			return "Followers";
		if (field.equals("\"Friends\""))
			return "Friends";
		else
			throw new StatsNotFoundException("Campo non valido");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Statistics[] VisualizeStats(Object filter, Hashtag hash) throws MalformedURLException, JSONException {
		try {
			filteredStatistics[0] = new Statistics(RecognizeFilter.JsonParserColumn(filter, hash), "Like");
			filteredStatistics[1] = new Statistics(RecognizeFilter.JsonParserColumn(filter, hash), "Followers");
			filteredStatistics[2] = new Statistics(RecognizeFilter.JsonParserColumn(filter, hash), "Friends");
		} 
		catch (FilterNotFoundException | FilterIllegalArgumentException | InternalGeneralException
				| ParseException e) {
			e.printStackTrace();
		}
			
		return filteredStatistics;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public DateStatistics StatsVisualizeDate(Object filter, Hashtag hash) throws MalformedURLException, JSONException {
		
		try {
			filteredDateStatistics = new DateStatistics(filter,hash);
		} 
		catch (com.sun.el.parser.ParseException | java.text.ParseException | FilterNotFoundException | FilterIllegalArgumentException | InternalGeneralException
				| ParseException e) {

			e.printStackTrace();
		}

		return filteredDateStatistics;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public LocationStatistics StatsVisualizeLocation(Object filter, Hashtag hash) throws MalformedURLException, JSONException {
		
		try {
			filteredLocationStatistics = new LocationStatistics(filter,hash);
		} 
		catch (com.sun.el.parser.ParseException | java.text.ParseException | FilterNotFoundException | FilterIllegalArgumentException | InternalGeneralException
				| ParseException e) {

			e.printStackTrace();
		}

		return filteredLocationStatistics;
	}
}