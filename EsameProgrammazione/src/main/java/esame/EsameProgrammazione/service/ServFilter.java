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
import esame.EsameProgrammazione.model.Tweet;
import esame.EsameProgrammazione.filter.Filter;

/////*******************************************************************/////
/////   VIENE SCORSA LA LISTA COMPLETA DI TUTTI I TWEET SCARICATI E     /////
///// NE VIENE EFFETTUATO IL FILTRAGGIO, MEDIANTE IL METODO Filtering() /////
/////*******************************************************************/////

/** @author Antonio Colucci
 * 	@author Carmen Andreozzi
 */

public class ServFilter {
	
	private final static String path = "esame.EsameProgrammazione.filter.";
	
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
			
		    //entra qui se il nome filtro non e' corretto 
		    catch(ClassNotFoundException e){
		    	throw new FilterNotFoundException("The filter in field: '"+field+"' with operator: '"+
		                                          operator +"' does not exist");
		    }
			
			//entra qui se sbagliate maiuscole e minuscole
		    catch(NoClassDefFoundError e){
		    	throw new FilterNotFoundException(
		    			"Error typing: '"+filterName+"' uppercase and lowercase error");
		    }

		    //entra qui se il costruttore chiamato da newInstance lancia un eccezione 
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
	 * Questo metodo restitusce una lista di tweet composta da soli tweet 
	 * che rispettano le condizioni del filtro.
	 * @param     filtro Filtro che si desidera utilizzare.  
	 * @param     previousArray ArrayList di Tweet sulla quale si vuole effettuare il filtraggio.
	 * @return    ArrayList di Tweet filtrati.
	 * @throws ParseException 
	 * @throws JSONException 
	 * @throws MalformedURLException 
	 * @throws InternalGeneralException 
	 * @throws FilterIllegalArgumentException 
	 * @throws FilterNotFoundException 
	 */
	public static ArrayList<Tweet> Filtering(Filter filtro, ArrayList<Tweet> previousArray, Hashtag hash) throws MalformedURLException, JSONException, ParseException{
		
		ArrayList<Tweet> tweets = JsonParser.parsingDataset(hash);

		ArrayList<Tweet> filteredArray = new ArrayList<Tweet>();
		
		for(Tweet tweet :  tweets) {

			if(filtro.filter(tweet))
				filteredArray.add(tweet);
		}				
		
		return filteredArray;
	}

	
	public static  ArrayList<Tweet> FilteringOR(Filter filtro, ArrayList<Tweet> previousArray, Hashtag hash) throws MalformedURLException, JSONException, ParseException{
		
		ArrayList<Tweet> tweets = JsonParser.parsingDataset(hash);

		ArrayList<Tweet> filteredArray = new ArrayList<Tweet>();
		
		for(Tweet tweet : tweets) {

			if(filtro.filter(tweet))
				filteredArray.add(tweet);
		}	
		
		previousArray.removeAll(filteredArray);
		previousArray.addAll(filteredArray);
		return previousArray;
	}
}