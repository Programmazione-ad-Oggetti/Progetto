package esame.EsameProgrammazione.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

import esame.EsameProgrammazione.exceptions.FilterIllegalArgumentException;
import esame.EsameProgrammazione.exceptions.FilterNotFoundException;
import esame.EsameProgrammazione.exceptions.InternalGeneralException;
import esame.EsameProgrammazione.model.Hashtag;
import esame.EsameProgrammazione.model.OurDate;
import esame.EsameProgrammazione.model.Tweet;
import esame.EsameProgrammazione.filter.EqDataFilter;
import esame.EsameProgrammazione.filter.Filter;

/** 
 * Viene scorsa la lista completa di tutti i tweet scaricati e ne viene effettuato il filtraggio
 * 
 * @author Colucci Antonio
 * @author Andreozzi Carmen
 */
public class ServFilter {
	//Nome del package al quale verrà concatenato la classe da utilizzare
	private final static String path = "esame.EsameProgrammazione.filter."; 
	
	/**
	 * Viene selezionata la classe di filtraggio adatta al filtro inserito
	 * 
	 * @param field Campo del filtro
	 * @param operator Operatore del filtro
	 * @param param Parametro del filtro
	 * @return Filtro
	 * @throws FilterNotFoundException
	 * @throws FilterIllegalArgumentException
	 * @throws InternalGeneralException
	 */
	public static Filter instanceFilter(String field,String operator,Object param) 
			   throws FilterNotFoundException, FilterIllegalArgumentException,InternalGeneralException{
			
			Filter filtro;
			String filterName = new String(operator+field+"Filter");
			String ClassFilterName = path.concat(filterName);
		    
			try {
				
				Class<?> cls = Class.forName(ClassFilterName); //seleziono la classe
			
				Constructor<?> ct = cls.getDeclaredConstructor(Object.class); //seleziono il costruttore
		    
				filtro =(Filter)ct.newInstance(param);  //Istanzio oggetto filtro
			}
			
		    //Entra qui se il nome filtro non e' corretto 
		    catch(ClassNotFoundException e){
		    	throw new FilterNotFoundException("The filter in field: '"+field+"' with operator: '"+
		                                          operator +"' does not exist");
		    }
			
			//Entra qui se sbagliate maiuscole e minuscole
		    catch(NoClassDefFoundError e){
		    	throw new FilterNotFoundException(
		    			"Error typing: '"+filterName+"' uppercase and lowercase error");
		    }

		    //Entra qui se il costruttore chiamato da newInstance lancia un eccezione 
		   	catch (InvocationTargetException e) {  
		   		//genero una nuova eccezione 
		   		throw new FilterIllegalArgumentException(e.getTargetException().getMessage()
		   				+ " Expected in '"+field+"'");
		   	}

		    catch(LinkageError | NoSuchMethodException | SecurityException 
			    	   | InstantiationException | IllegalAccessException e ) {
			    	
			    	e.printStackTrace();
			    	throw new InternalGeneralException("try later");
			}
			
		    return filtro;
		}
	
	
	/**
	 * Filtraggio secondo il macro-operatore AND
	 * 
	 * @param filtro Filtro che si desidera utilizzare.  
	 * @param previousArray ArrayList di Tweet sulla quale si vuole effettuare il filtraggio.
	 * @param hash Hashtag applicato
	 * @param column Campo sul quale fitrare
	 * @param value Valore immesso dall'utente
	 * @return ArrayList di Tweet filtrati.
	 * @throws ParseException 
	 * @throws JSONException 
	 * @throws MalformedURLException 
	 * @throws com.sun.el.parser.ParseException 
	 * @throws java.text.ParseException 
	 * @throws FilterIllegalArgumentException 
	 */
	public static ArrayList<Tweet> Filtering(Filter filtro, ArrayList<Tweet> previousArray, Hashtag hash, String column, Object value) throws MalformedURLException, JSONException, ParseException, com.sun.el.parser.ParseException, java.text.ParseException{
		
		ArrayList<Tweet> tweets = JsonParser.parsingDataset(hash);
		OurDate data;
		EqDataFilter fil;
		ArrayList<Tweet> filteredArray = new ArrayList<Tweet>();
		
		//Nel caso in cui il campo sia uguale a "Data" viene effettuato il filtraggio per la data
		if(column.equals("Data")) {
			for(int i = 0; i<tweets.size(); i++) {
				data = DateParser.parsing(tweets.get(i).getData());
				
				fil = new EqDataFilter(value);
				
				if(fil.filterDate(data)) {
					filteredArray.add(tweets.get(i));
				}
			}
		}
		else{
			for(Tweet tweet :  tweets) {
	
				if(filtro.filter(tweet))
					filteredArray.add(tweet);
			}				
		}
		
		return filteredArray;
	}

	
	/**
	 * Filtraggio secondo il macro-operatore OR
	 * 
	 * @param filtro Filtro inserito
	 * @param previousArray ArrayList di tweet completa
	 * @param hash Hashtag inserito
	 * @param column Campo del filtro
	 * @param value Valore del filtro
	 * @return ArrayList filtrato
	 * @throws MalformedURLException
	 * @throws JSONException
	 * @throws ParseException
	 * @throws com.sun.el.parser.ParseException
	 * @throws java.text.ParseException
	 */
	public static  ArrayList<Tweet> FilteringOR(Filter filtro, ArrayList<Tweet> previousArray, Hashtag hash, String column, Object value) throws MalformedURLException, JSONException, ParseException, com.sun.el.parser.ParseException, java.text.ParseException{
		
		ArrayList<Tweet> tweets = JsonParser.parsingDataset(hash);
		OurDate data;
		EqDataFilter fil;
		ArrayList<Tweet> filteredArray = new ArrayList<Tweet>();
		
		//Nel caso in cui il campo sia uguale a "Data" viene effettuato il filtraggio per la data
		if(column.equals("Data")) {
			for(int i = 0; i<tweets.size(); i++) {
				data = DateParser.parsing(tweets.get(i).getData());
				
				fil = new EqDataFilter(value);
				
				if(fil.filterDate(data)) {
					filteredArray.add(tweets.get(i));
				}
			}
		}
		else{
			for(Tweet tweet : tweets) {

			if(filtro.filter(tweet))
				filteredArray.add(tweet);
			}	
		}
			
		previousArray.removeAll(filteredArray);
		previousArray.addAll(filteredArray);
		
		return previousArray;
	}
}