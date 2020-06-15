package esame.EsameProgrammazione.service;

import java.net.MalformedURLException;
import java.util.ArrayList;

import esame.EsameProgrammazione.database.DatabaseClass;
import esame.EsameProgrammazione.model.Hashtag;
import esame.EsameProgrammazione.model.Tweet;

import org.json.JSONException;
import org.json.simple.*;
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
			
		JSONArray stasuses = (JSONArray) parser.get("statuses");
		
		ArrayList<Tweet> ListaTweets = new ArrayList<Tweet>();
		for(int i = 0; i < stasuses.size(); i++) {
			Tweet tweet = new Tweet();
			
			JSONObject tweetObject = (JSONObject) stasuses.get(i);
			
			//tweet.setHashtag((String) parsedTweet.get("hashtags"));
			tweet.setText((String) tweetObject.get("text"));
			tweet.setData((String) tweetObject.get("created_at")); //Viene presa la data
			tweet.setID((long) tweetObject.get("id"));
			
		/*	Hashtag hashtg;
			
			//Creazione dell'oggetto entities che permette di effetttuare la get() dell'hashtag, 
			//in quanto (nel JSON) il campo Hashtag e' inserito dentro l'oggetto "entities"
			JSONObject entities = (JSONObject) tweetObject.get("entities");
			JSONArray Hashtag = (JSONArray) entities.get("hashtags"); //Viene preso l'hashtag
			
			for(int j=0; j<Hashtag.size(); j++) {
				JSONObject text = (JSONObject) Hashtag.get(j);
				hashtg = new Hashtag();
				hashtg.setTesto((String) text.get("text"));
			}
			
			//Creazione dell'oggetto retweeted_status che permette di effetttuare la get() del campo "favorite_count" (ossia il numero dei Like del post), 
			//in quanto (nel JSON) il campo "favorite_count" e' inserito dentro l'oggetto "retweeted_status"
		
			 */
			JSONObject user = (JSONObject) tweetObject.get("user"); 
			
			tweet.setLike((long) user.get("favourites_count"));
			tweet.setFollowers((long) user.get("followers_count"));//Viene preso il numero dei Like
			tweet.setFriends((long) user.get("friends_count"));
			tweet.setLocation((String) user.get("location"));
			tweet.setName((String) user.get("name"));
			tweet.setScreen_name((String) user.get("screen_name"));
			tweet.setUrl((String) user.get("url"));
			
			ListaTweets.add(tweet);
		}
		
		return ListaTweets;
	}

}
