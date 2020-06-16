package esame.EsameProgrammazione.model;

import java.net.MalformedURLException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

import esame.EsameProgrammazione.exceptions.FilterIllegalArgumentException;
import esame.EsameProgrammazione.exceptions.FilterNotFoundException;
import esame.EsameProgrammazione.exceptions.InternalGeneralException;
import esame.EsameProgrammazione.service.RecognizeFilter;

public class LocationStatistics {
	private int numeroTweetPerLocation;
	
	public LocationStatistics(Object filter, Hashtag hash) throws ParseException, com.sun.el.parser.ParseException, java.text.ParseException, FilterNotFoundException, FilterIllegalArgumentException, MalformedURLException, JSONException, InternalGeneralException {
		
		ArrayList<Tweet> tweets = RecognizeFilter.JsonParserColumn(filter, hash);
		
		numeroTweetPerLocation=tweets.size();
	}
	
	public int getNumeroTweetPerLocation() {
		return numeroTweetPerLocation;
	}
}
