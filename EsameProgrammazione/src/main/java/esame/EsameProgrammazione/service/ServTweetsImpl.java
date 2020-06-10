package esame.EsameProgrammazione.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import esame.EsameProgrammazione.model.Hashtag;
import esame.EsameProgrammazione.model.Tweet;
import esame.EsameProgrammazione.service.JsonParser;

@Service
public class ServTweetsImpl implements ServTweets{
	//public ArrayList<Tweet> TweetList = new ArrayList<Tweet>();
	private Map<Long, Tweet> timeline=new HashMap<>();
	
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
	
}

