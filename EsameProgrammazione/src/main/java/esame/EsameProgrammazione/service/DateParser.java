package esame.EsameProgrammazione.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.sun.el.parser.ParseException;

import esame.EsameProgrammazione.model.*;

public class DateParser {
	
	public static ArrayList<Tweet> TweetList = new ArrayList<Tweet>();
	
	public static ArrayList<Tweet> getTwitterDate(Hashtag hash) throws org.json.simple.parser.ParseException {
		TweetList = ServTweetsImpl.getTweets(hash);
		for(int i = 0; i<TweetList.size(); i++) {
			dateParsing(TweetList.get(i).getData());
		}
		return 
	}
		
	
	public static Date dateParsing(String date) throws ParseException, java.text.ParseException {
		  final String TWITTER="EEE MMM dd HH:mm:ss ZZZZZ yyyy";
		  SimpleDateFormat sf = new SimpleDateFormat(TWITTER);
		  sf.setLenient(true);
		  return (Date) sf.parse(date);
		  }
}
