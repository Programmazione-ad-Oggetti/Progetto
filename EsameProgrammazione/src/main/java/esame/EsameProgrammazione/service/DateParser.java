package esame.EsameProgrammazione.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.el.parser.ParseException;

import esame.EsameProgrammazione.filter.EqDataFilter;
import esame.EsameProgrammazione.model.*;

public class DateParser {
	
	private static ArrayList<Tweet> TweetList = new ArrayList<Tweet>();
	private static ArrayList<Tweet> FilteredList = new ArrayList<Tweet>();
	private static Calendar data;
	private static EqDataFilter	fil;
	
	@Autowired
	static ServTweetsImpl support; 
	
	
	public static ArrayList<Tweet> getTwitterDate(Hashtag hash, String data_utente) throws org.json.simple.parser.ParseException, ParseException, java.text.ParseException {
		
		TweetList = (ArrayList<Tweet>) support.getTweets();
		
		for(int i = 0; i<TweetList.size(); i++) {
			data = normalDateParsing(TweetList.get(i).getData());
			
			fil = new EqDataFilter(data_utente);
			
			if(fil.filterDate(data)) {
				FilteredList.add(TweetList.get(i));
			}
		}
		return FilteredList;
	}
		
	
	//EFFETTUA IL PARSING DELLA DATA DI UN TWEET
	public static Calendar normalDateParsing(String date) throws ParseException, java.text.ParseException {
		  final String TWITTER="EEE MMM dd HH:mm:ss X yyyy ";
		  SimpleDateFormat sf = new SimpleDateFormat(TWITTER);
		  
		  //date = date.replace("+0000 ", "") + " UTC";
		  Date Date = (Date) sf.parse(date);
		  sf.setLenient(true);
		  
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(Date);
		  
		  return cal;
	}
	
	//EFFETTUA IL PARSING DELLA DATA IMMESSA DALL'UTENTE NELLA RICHIESTA
	public static Calendar userDateParsing(String user_date) throws ParseException, java.text.ParseException {
		  final String Data_utente = "MM dd";
		  SimpleDateFormat sf = new SimpleDateFormat(Data_utente);
		  
		  Date Date = (Date) sf.parse(user_date);
		  sf.setLenient(true);
		  
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(Date);
		  
		  return cal;
	}
}
