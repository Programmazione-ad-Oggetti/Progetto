package esame.EsameProgrammazione.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.parser.ParseException;

import esame.EsameProgrammazione.model.Tweet;
import esame.EsameProgrammazione.service.JsonParser;

public class ServTweetsImpl{
	static Map<Long, Tweet> TweetList = new HashMap<>();
	
	//Costruttore
	public ServTweetsImpl() throws ParseException {
		
		try {
			ArrayList<Tweet> lista = JsonParser.parsingDataset(); //Viene richiamata la funzione che effettua il parsing del Json
			
			for(int i = 0; i < lista.size(); i++) {
				Tweet twt = lista.get(i);
				TweetList.put(twt.getID(), twt);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Collection<Tweet> getTweets() {
		return TweetList.values();
	}
}
