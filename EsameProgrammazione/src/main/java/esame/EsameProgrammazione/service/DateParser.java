package esame.EsameProgrammazione.service;

import esame.EsameProgrammazione.model.*;

/**
 * Classe che effettua il parsing della data di ogni tweet e della data inserita dall'utente
 * 
 * @author Colucci Antonio
 * @author Andreozzi Carmen
 */
public class DateParser {
	
	/**
	 * Viene effettuato il parsing della data di ogni tweet.  
	 * RICORDA: LA DATA DI UN TWEET E' FORMATTATA NEL SEGUENTE MODO: "EEE MMM dd HH:mm:ss Z yyyy"
	 * 
	 * @param date La data di un tweet
	 * @return Data elaborata di tipo OurDate
	 */
	public static OurDate parsing(String date) {
		OurDate data = new OurDate();
		
		//VIENE ELIMINATA LA PARTE "Z "
		date = date.replace("+0000 ", "");
		
		//VIENE ELIMINATA LA PRIMA PARTE DELLA STRINGA CHE FORMA LA DATA DI UN TWEET, OSSIA "EEE "
		String caratteri = "";
		for(int i = 0; i < 4; i++) {
			caratteri += date.charAt(i);
			
		}
		date = date.replaceAll(caratteri, "");
		
		//VIENE ELIMINATA L'ULTIMA PARTE DELLA STRINGA CHE FORMA LA DATA DI UN TWEET, OSSIA "HH:mm:ss "
		caratteri = "";
		for(int i = 7; i < 16; i++) {
			caratteri += date.charAt(i);
		}
		date = date.replaceAll(caratteri, "");
		
		data.setMonth(date.substring(0,3));
		data.setDay(date.substring(4,6));
		data.setYear(date.substring(7,11));
		
		return data;
	}
	
	/**
	 * Viene effettuato il parsing della data inserita dall'utente.  
	 * RICORDA: LA DATA IMMESSA DALL'UTENTE E' FORMATTATA NEL SEGUENTE MODO: "MMM dd yyyy"
	 * 
	 * @param user_date La data inserita dall'utente
	 * @return Data elaborata di tipo OurDate
	 */
	public static OurDate userParsing(String user_date) {
		OurDate data = new OurDate();
		
		data.setMonth(user_date.substring(0,3));
		data.setDay(user_date.substring(4,6));
		data.setYear(user_date.substring(7,11));
		
		return data;
	}
}
