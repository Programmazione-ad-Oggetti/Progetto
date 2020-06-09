package esame.EsameProgrammazione.statistic;

import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import esame.EsameProgrammazione.model.Hashtag;
import esame.EsameProgrammazione.model.Tweet;
import esame.EsameProgrammazione.service.DateParser;

public class MakeStatsDate {
public ArrayList<Tweet> DateList(Hashtag hash, String data_utente) throws ParseException, com.sun.el.parser.ParseException, java.text.ParseException{
		
		ArrayList<Tweet> listaTweet = DateParser.getTwitterDate(hash, data_utente);
	
		return listaTweet;
	}
}
