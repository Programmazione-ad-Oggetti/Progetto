package esame.EsameProgrammazione.service;

import java.io.Reader;
import java.util.ArrayList;

import esame.EsameProgrammazione.database.DatabaseClass;
import esame.EsameProgrammazione.model.Tweet;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

public class JsonParser {
	
	public ArrayList<Tweet> parsingDataset() throws ParseException{
			
		JSONObject parser = DatabaseClass.JSONdownloader();
			
		ArrayList<Tweet> ListaTweets = new ArrayList<Tweet>();
		for(int i = 0; i < parser.size(); i++) {
			Tweet tweet = new Tweet();
			
			JSONObject parsedTweet = (JSONObject) JSONValue.parse((Reader) parser.get(i));
			
			tweet.setHashtag((String) parsedTweet.get("hashtags"));
			tweet.setData((String) parsedTweet.get("created at"));
		}
	}
}
