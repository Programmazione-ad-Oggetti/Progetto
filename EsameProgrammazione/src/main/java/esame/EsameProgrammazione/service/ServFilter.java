package esame.EsameProgrammazione.service;

import java.util.ArrayList;

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
