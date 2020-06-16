package esame.EsameProgrammazione.service;

import java.net.MalformedURLException;
import java.util.ArrayList;

import esame.EsameProgrammazione.database.DatabaseClass;
import esame.EsameProgrammazione.model.Hashtag;
import esame.EsameProgrammazione.model.Tweet;

import org.json.JSONException;
import org.json.simple.*;
import org.json.simple.parser.ParseException;

/** 
 * Classe in cui viene effettuato il parsing del json scaricato dalla classe DatabaseClass.java
 * 
 * @author Colucci Antonio
 * @author Andreozzi Carmen
 */
public class JsonParser {
	
	/**
	 * Viene effettuato il download del JSON dalla classe DatabaseClass.java 
	 * e ne viene effettuato il parsing
	 * 
	 * @param hash Hashtag inserito
	 * @return Lista dei tweet elaborati
	 * @throws ParseException
	 * @throws MalformedURLException
	 * @throws JSONException
	 */
	public static ArrayList<Tweet> parsingDataset(Hashtag hash) throws ParseException, MalformedURLException, JSONException{
			
		JSONObject parser = DatabaseClass.JSONdownloader(hash); //Viene effettuato il download
			
		JSONArray stasuses = (JSONArray) parser.get("statuses");
		
		ArrayList<Tweet> ListaTweets = new ArrayList<Tweet>();
		for(int i = 0; i < stasuses.size(); i++) {
			Tweet tweet = new Tweet();
			
			JSONObject tweetObject = (JSONObject) stasuses.get(i);
			
			//tweet.setHashtag((String) parsedTweet.get("hashtags"));
			tweet.setText((String) tweetObject.get("text")); //Viene preso il testo del tweet
			tweet.setData((String) tweetObject.get("created_at")); //Viene presa la data
			tweet.setID((long) tweetObject.get("id")); //Viene preso l'ID del tweet
			
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
			
			tweet.setLike((long) user.get("favourites_count")); //Viene preso il numero dei like
			tweet.setFollowers((long) user.get("followers_count")); //Viene preso il numero dei followers
			tweet.setFriends((long) user.get("friends_count")); //Viene preso il numero degli amici
			tweet.setLocation((String) user.get("location")); //Viene presa la posizione geografica
			tweet.setName((String) user.get("name")); //Viene preso il nome dell'utente
			tweet.setScreen_name((String) user.get("screen_name")); //Viene preso lo screen name
			tweet.setUrl((String) user.get("url")); //Viene preso l'url
			
			ListaTweets.add(tweet);
		}
		
		return ListaTweets;
	}
}
