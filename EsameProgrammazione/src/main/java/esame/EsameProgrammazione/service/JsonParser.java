package esame.EsameProgrammazione.service;

import java.io.Reader;
import java.net.MalformedURLException;
import java.util.ArrayList;

import esame.EsameProgrammazione.database.DatabaseClass;
import esame.EsameProgrammazione.model.Hashtag;
import esame.EsameProgrammazione.model.Tweet;

import org.json.*;
import org.json.simple.parser.ParseException;

/////********************************************************/////
/////     IN QUESTA CLASSE VIENE EFFETTUATO IL PARSING  	 /////
/////  DEL JSON SCARICATO DALLA CLASSE DatabaseClass.java    /////
/////********************************************************/////

/** @author Antonio Colucci
*   @author Carmen Andreozzi
*/

public class JsonParser {
	
	public static ArrayList<Tweet> parsingDataset(Hashtag hash) throws ParseException, MalformedURLException, JSONException{
			
		JSONObject parser = DatabaseClass.JSONdownloader(hash);
			
		JSONArray parsedTweet = (JSONArray) parser.getJSONArray("statuses");
		
		ArrayList<Tweet> ListaTweets = new ArrayList<Tweet>();
		for(int i = 0; i < parsedTweet.length(); i++) {
			Tweet tweet = new Tweet();
			
			JSONObject parsed = (JSONObject) parsedTweet.get(i);
			
			//tweet.setHashtag((String) parsedTweet.get("hashtags"));
			tweet.setData((String) parsed.getString("created_at")); //Viene presa la data
			tweet.setID((long) parsed.getInt("id"));
			
			Hashtag hashtg;
			
			//Creazione dell'oggetto entities che permette di effetttuare la get() dell'hashtag, 
			//in quanto (nel JSON) il campo Hashtag e' inserito dentro l'oggetto "entities"
			JSONObject entities = (JSONObject) parsed.get("entities");
			JSONArray Hashtag = (JSONArray) entities.get("hashtags"); //Viene preso l'hashtag
			
			for(int j=0; j<Hashtag.length(); j++) {
				JSONObject text = (JSONObject) Hashtag.get(j);
				hashtg = new Hashtag();
				hashtg.setTesto((String) text.get("text"));
				tweet.setHashtag(hashtg);
			}
			
			//Creazione dell'oggetto retweeted_status che permette di effetttuare la get() del campo "favorite_count" (ossia il numero dei Like del post), 
			//in quanto (nel JSON) il campo "favorite_count" e' inserito dentro l'oggetto "retweeted_status"
			JSONObject retweeted_status = (JSONObject) parsed.get("retweeted_status"); 
			
			tweet.setLike((int) retweeted_status.get("favorite_count")); //Viene preso il numero dei Like
			
			ListaTweets.add(tweet);
		}
		
		return ListaTweets;
	}

}
