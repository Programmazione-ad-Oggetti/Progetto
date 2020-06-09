package esame.EsameProgrammazione.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

import org.json.simple.parser.ParseException;

import esame.EsameProgrammazione.exceptions.FilterIllegalArgumentException;
import esame.EsameProgrammazione.exceptions.FilterNotFoundException;
import esame.EsameProgrammazione.exceptions.InternalGeneralException;
import esame.EsameProgrammazione.model.FilterStruct;
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
	
	public static FilterStruct instanceFilter(String field,String operator,Object param) 
			   throws FilterNotFoundException, FilterIllegalArgumentException,InternalGeneralException{
			
			FilterStruct filtro;
			String filterName = new String(operator+field+"Filter");
			String ClassFilterName = path.concat(filterName);
		    
			try {
				
				Class<?> cls = Class.forName(ClassFilterName); //seleziono la classe
			
				Constructor<?> ct = cls.getDeclaredConstructor(Object.class); //seleziono il costruttore
		    
				filtro =(FilterStruct)ct.newInstance(param);  //Istanzio oggetto filtro
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
	 * @param     completeTweetList ArrayList di Tweet sulla quale si vuole effettuare il filtraggio.  
	 * @param     filtro che si desidera utilizzare.
	 * @return    ArrayList di Tweet filtrati.
	 * @throws InternalGeneralException 
	 * @throws FilterIllegalArgumentException 
	 * @throws FilterNotFoundException 
	 */
	public static ArrayList<Tweet> Filtering(ArrayList<Tweet> completeTweetList, FilterStruct filtro) throws FilterNotFoundException, FilterIllegalArgumentException, InternalGeneralException{
		
		ArrayList<Tweet> filteredTweetList = new ArrayList<Tweet>();
		
		Filter filtraggio = (Filter) instanceFilter(filtro.getField(), filtro.getOperator(), filtro.getValues());
		
		for(int i = 0; i < completeTweetList.size(); i++) {

			if(filtraggio.filter(filtro.getValues() , completeTweetList.get(i)))
				filteredTweetList.add(completeTweetList.get(i));
		}
		
		return filteredTweetList;
	}
	
	public static ArrayList<Tweet> FilteringOr(FilterStruct filtro, ArrayList<Tweet> completeTweetList, Hashtag hash) throws FilterNotFoundException, FilterIllegalArgumentException, InternalGeneralException, ParseException{

		Collection<Tweet> tweets = ServTweetsImpl.getTweets(hash);
		ArrayList<Tweet> filteredTweetList = new ArrayList<Tweet>();
		
		Filter filtraggio = (Filter) instanceFilter(filtro.getField(), filtro.getOperator(), filtro.getValues());
		
		for(int i = 0; i < tweets.size(); i++) {

			if(filtraggio.filter(filtro.getValues(), ((ArrayList<Tweet>) tweets).get(i)))
				filteredTweetList.add(((ArrayList<Tweet>) tweets).get(i));
		}	
		
		completeTweetList.removeAll(filteredTweetList);
		completeTweetList.addAll(filteredTweetList);
		return completeTweetList;
	}
	
	
}
