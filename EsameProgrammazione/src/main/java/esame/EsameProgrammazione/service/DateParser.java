package esame.EsameProgrammazione.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.el.parser.ParseException;

import esame.EsameProgrammazione.filter.EqDataFilter;
import esame.EsameProgrammazione.model.*;

public class DateParser {
	
	private static ArrayList<Tweet> TweetList = new ArrayList<Tweet>();
	private static ArrayList<Tweet> FilteredList = new ArrayList<Tweet>();
	private static OurDate data;
	private static EqDataFilter	fil;
	
	@Autowired
	static ServTweetsImpl support; 
	
	
	public static ArrayList<Tweet> getTwitterDate(Hashtag hash, String data_utente) throws org.json.simple.parser.ParseException, ParseException, java.text.ParseException {
		
		TweetList = (ArrayList<Tweet>) support.getTweets();
		
		for(int i = 0; i<TweetList.size(); i++) {
			data = parsing(TweetList.get(i).getData());
			
			fil = new EqDataFilter(data_utente);
			
			if(fil.filterDate(data)) {
				FilteredList.add(TweetList.get(i));
			}
		}
		return FilteredList;
	}
		
	
	public static OurDate parsing(String date) {
		//RICORDA: LA DATA DI UN TWEET E' FORMATTATA NEL SEGUENTE MODO: "EEE MMM dd HH:mm:ss Z yyyy"
		//String[] months = initialize();
		OurDate data = new OurDate();
		
		//VIENE ELIMINATA LA PARTE "Z "
		date = date.replace("+0000 ", "");
		
		//VIENE ELIMINATA LA PRIMA PARTE DELLA STRINGA CHE FORMA LA DATA DI UN TWEET, OSSIA "EEE "
		String caratteri = "";
		for(int i = 0; i < 4; i++) {
			caratteri += date.charAt(i);
			
		}
		date = date.replaceAll(caratteri, "");
		
		System.out.println(date);
		//VIENE ELIMINATA L'ULTIMA PARTE DELLA STRINGA CHE FORMA LA DATA DI UN TWEET, OSSIA "HH:mm:ss "
		caratteri = "";
		for(int i = 7; i < 16; i++) {
			caratteri += date.charAt(i);
		}
		date = date.replaceAll(caratteri, "");
		
		data.setMonth(date.substring(0,2));
		data.setDay(date.substring(4,5));
		data.setYear(date.substring(7,10));
		
		return data;
	}
	
	public static OurDate userParsing(String user_date) {
		//RICORDA: LA DATA IMMESSA DALL'UTENTE E' FORMATTATA NEL SEGUENTE MODO: "MMM dd yyyy"

		OurDate data = new OurDate();
		
		System.out.println(user_date);
		
		data.setMonth(user_date.substring(0,2));
		data.setDay(user_date.substring(4,5));
		data.setYear(user_date.substring(7,10));
		
		return data;
	}
	//INIZIALIZZA UN VETTORE CON TUTTI I MESI SCRITTI LETTERALMENTE, I QUALI VERRANO TRASFORMATI IN NUMERI
	/*private static String[] initialize() {
		String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		
		return months;
	}*/
	
	/*
	//EFFETTUA IL PARSING DELLA DATA DI UN TWEET
	public static Calendar normalDateParsing(String date) throws ParseException, java.text.ParseException {
		  final String TWITTER="EEE MMM dd HH:mm:ss X yyyy";
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
	}*/
}
