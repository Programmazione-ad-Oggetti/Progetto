package esame.EsameProgrammazione.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.parser.ParseException;

import esame.EsameProgrammazione.model.Tweet;
import esame.EsameProgrammazione.service.JsonParser;

public class ServTweetsImpl{
	static ArrayList<Tweet> TweetList = new ArrayList<Tweet>();
	
	//Costruttore
	public ServTweetsImpl() throws ParseException {
		
		try {
			ArrayList<Tweet> lista = JsonParser.parsingDataset(); //Viene richiamata la funzione che effettua il parsing del Json
			
			for(int i = 0; i < lista.size(); i++) {
				Tweet twt = lista.get(i);
				TweetList.add(twt);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Tweet> getTweets() {
		return TweetList;
	}
}
