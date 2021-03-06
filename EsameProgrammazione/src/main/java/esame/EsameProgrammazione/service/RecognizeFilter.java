package esame.EsameProgrammazione.service;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import esame.EsameProgrammazione.service.ServFilter;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;
import esame.EsameProgrammazione.exceptions.FilterIllegalArgumentException;
import esame.EsameProgrammazione.exceptions.FilterNotFoundException;
import esame.EsameProgrammazione.exceptions.InternalGeneralException;
import esame.EsameProgrammazione.filter.Filter;
import esame.EsameProgrammazione.model.*;

/**
 * Classe che elabora il campo e il macro-operatore di un filtro in modo da 
 * eseguire il filtraggio secondo i due macro-operatori
 * 
 * @author Colucci Antonio
 * @author Andreozzi Carmen
 */
public class RecognizeFilter {
	
	/**
	 * Viene elaborato il campo da analizzare
	 * 
	 * @param filter Filtro da applicare
	 * @param hash Hashtag applicato
	 * @return ArrayList di Tweet filtrati
	 * @throws InternalGeneralException
	 * @throws FilterNotFoundException 
	 * @throws FilterIllegalArgumentException 
	 * @throws ParseException 
	 * @throws JSONException 
	 * @throws MalformedURLException 
	 */
	public static ArrayList<Tweet> JsonParserColumn(Object filter, Hashtag hash)
		throws InternalGeneralException, FilterNotFoundException, FilterIllegalArgumentException, ParseException, MalformedURLException, JSONException{ 
			ArrayList<Tweet> previousArray= new ArrayList<Tweet>();
			ArrayList<Tweet> filteredArray= new ArrayList<Tweet>();
			HashMap<String,Object> result= new ObjectMapper().convertValue(filter, HashMap.class);

		//Ciclo con tutti gli elementi dell'ArrayList
			for(Map.Entry<String, Object> entry: result.entrySet()) {
				filteredArray= new ArrayList<Tweet>();
				String column=entry.getKey();
				Object filterParam=entry.getValue();
				try {
						filteredArray=jsonParserOperator(column, filterParam, previousArray, hash);
				}catch (SecurityException e) {
					throw new InternalGeneralException ("Error in I/O parsing information");
				}
				
				previousArray=new ArrayList<Tweet>();
				previousArray.addAll(filteredArray);
			}
			
			return filteredArray;
	}
			
	
	/**
	 * Viene elaborato il macro-operatore del filtro
	 * 
	 * @param column Campo del filtro
	 * @param filterParam Filtro da analizzare
	 * @param previousArray Array di tweet
	 * @param hash Hashtag inserito
	 * @return Lista filtrata
	 * @throws InternalGeneralException
	 * @throws FilterNotFoundException
	 * @throws FilterIllegalArgumentException
	 * @throws ParseException
	 * @throws MalformedURLException
	 * @throws JSONException
	 */
	public static  ArrayList<Tweet> jsonParserOperator (String column,Object filterParam,
            ArrayList<Tweet> previousArray, Hashtag hash)
	throws InternalGeneralException, FilterNotFoundException, FilterIllegalArgumentException, ParseException, MalformedURLException, JSONException {
		
		String type="";
		Filter filter;
		ArrayList<Tweet> filteredArray= new ArrayList <Tweet>();
		HashMap<String, Object> result= new ObjectMapper().convertValue(filterParam,HashMap.class);
		
		for(Map.Entry<String, Object> entry: result.entrySet()) {
			String operator= entry.getKey();
			Object value=entry.getValue();
		
			if(operator.equals("type") || operator.equals("Type")) {
				type=(String) value;
				
				if((!(value.equals("And"))) && (!(value.equals("Or")))) {
					throw new FilterIllegalArgumentException("'And' o 'Or' expected after 'type'");
				}
				continue;
			}
			
			filter= ServFilter.instanceFilter(column, operator, value);
			
			if (type == "And")
				try {
					filteredArray = ServFilter.Filtering(filter, previousArray, hash, column, value);
				} 
				catch (MalformedURLException | JSONException | ParseException | com.sun.el.parser.ParseException
						| java.text.ParseException e) {
					e.printStackTrace();
				}
			else if(type == "Or")
				try {
					filteredArray = ServFilter.FilteringOR(filter, previousArray, hash, column, value);
				} 
				catch (MalformedURLException | JSONException | ParseException | com.sun.el.parser.ParseException
						| java.text.ParseException e) {
					e.printStackTrace();
				}
			else
				try {
					filteredArray = ServFilter.FilteringOR(filter, previousArray, hash, column, value);
				} 
				catch (MalformedURLException | JSONException | ParseException | com.sun.el.parser.ParseException
						| java.text.ParseException e) {
					e.printStackTrace();
				}
		
		}
		
		return filteredArray;
	}
}
	
