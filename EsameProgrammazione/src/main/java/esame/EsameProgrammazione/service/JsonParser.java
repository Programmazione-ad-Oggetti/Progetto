package esame.EsameProgrammazione.service;

import java.io.Reader;
import java.util.ArrayList;

import esame.EsameProgrammazione.database.DatabaseClass;
import esame.EsameProgrammazione.model.Hashtag;
import esame.EsameProgrammazione.model.Tweet;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

/////********************************************************/////
/////     IN QUESTA CLASSE VIENE EFFETTUATO IL PARSING  	 /////
/////  DEL JSON SCARICATO DALLA CLASSE DatabaseClass.java    /////
/////********************************************************/////

/** @author Antonio Colucci
*   @author Carmen Andreozzi
*/

public class JsonParser {
	
	public static ArrayList<Tweet> parsingDataset(Hashtag hash) throws ParseException{
			
		JSONObject parser = DatabaseClass.JSONdownloader(hash);
			
		ArrayList<Tweet> ListaTweets = new ArrayList<Tweet>();
		for(int i = 0; i < parser.size(); i++) {
			Tweet tweet = new Tweet();
			
			JSONObject parsedTweet = (JSONObject) JSONValue.parse((Reader) parser.get(i));
			
			//tweet.setHashtag((String) parsedTweet.get("hashtags"));
			tweet.setData((String) parsedTweet.get("created_at")); //Viene presa la data
			tweet.setID((long) parsedTweet.get("id"));
			
			Hashtag hashtg;
			
			//Creazione dell'oggetto entities che permette di effetttuare la get() dell'hashtag, 
			//in quanto (nel JSON) il campo Hashtag � inserito dentro l'oggetto "entities"
			JSONObject entities = (JSONObject) parsedTweet.get("entities");
			JSONArray Hashtag = (JSONArray) entities.get("hashtags"); //Viene preso l'hashtag
			
			for(int j=0; j<Hashtag.size(); j++) {
				JSONObject text = (JSONObject) Hashtag.get(j);
				hashtg = new Hashtag();
				hashtg.setTesto((String) text.get("text"));
				tweet.setHashtag(hashtg);
			}
			
			//Creazione dell'oggetto retweeted_status che permette di effetttuare la get() del campo "favorite_count" (ossia il numero dei Like del post), 
			//in quanto (nel JSON) il campo "favorite_count" � inserito dentro l'oggetto "retweeted_status"
			JSONObject retweeted_status = (JSONObject) parsedTweet.get("retweeted_status"); 
			
			tweet.setLike((int) retweeted_status.get("favorite_count")); //Viene preso il numero dei Like
			
			ListaTweets.add(tweet);
		}
		
		return ListaTweets;
	}

}
