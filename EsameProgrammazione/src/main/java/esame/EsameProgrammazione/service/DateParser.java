package esame.EsameProgrammazione.service;

import esame.EsameProgrammazione.model.*;

public class DateParser {
	
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
	
	public static OurDate userParsing(String user_date) {
		//RICORDA: LA DATA IMMESSA DALL'UTENTE E' FORMATTATA NEL SEGUENTE MODO: "MMM dd yyyy"

		OurDate data = new OurDate();
		
		data.setMonth(user_date.substring(0,3));
		data.setDay(user_date.substring(4,6));
		data.setYear(user_date.substring(7,11));
		
		return data;
	}
	
}
