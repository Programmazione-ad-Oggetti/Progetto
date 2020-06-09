package esame.EsameProgrammazione.model;

import java.sql.Date;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import esame.EsameProgrammazione.statistic.MakeStatsDate;

public class DateStatistics extends MakeStatsDate{
	private int numeroTweet;
	
	public DateStatistics(Hashtag hash, String data_utente) throws ParseException, com.sun.el.parser.ParseException, java.text.ParseException {
		ArrayList<Tweet> lista = DateList(hash, data_utente);
		
		numeroTweet=lista.size();
	}
	
	public int getNumeroTweet() {
		return numeroTweet;
	}
}
