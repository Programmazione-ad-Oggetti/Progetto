package esame.EsameProgrammazione.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import esame.EsameProgrammazione.exceptions.FilterIllegalArgumentException;
import esame.EsameProgrammazione.exceptions.FilterNotFoundException;
import esame.EsameProgrammazione.exceptions.InternalGeneralException;

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
	
	private ArrayList<Tweet> EseguiFiltro;
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
		   				+ " Expected in '"+column+"'");
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
	 * @param     completeTweetList ArrayList di Tweet sulla quale si vuole effettuare il filtraggio.  
	 * @param     filtro che si desidera utilizzare.
	 * @return    ArrayList di Tweet filtrati.
	 */
	public ArrayList<Tweet> Filtering(ArrayList<Tweet> completeTweetList, Filter filtro){
		
		ArrayList<Tweet> filteredTweetList = new ArrayList<Tweet>();
		
		for(Tweet tweet :  completeTweetList) {

			if(filtro.filter(tweet))
				filteredTweetList.add(tweet);
		}		
		
		return filteredTweetList;
	}
}
