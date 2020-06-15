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

public class RecognizeFilter {
	
	/**Effettua il parsing dei dati esterni (Campo da analizzare)
	 * @param filter filtro da applicare
	 * @param hash Hashtag applicato
	 * @return ArrayList di Tweet filtrati
	 * @throws InternalGeneralException
	 * @throws  FilterNotFoundException 
	 * @throws FilterIllegalArgumentException 
	 * @throws ParseException 
	 * @throws JSONException 
	 * @throws MalformedURLException 
	 */
	public static ArrayList<Tweet> JsonParserColumn(Object filter, Hashtag hash)
			throws InternalGeneralException, FilterNotFoundException, FilterIllegalArgumentException, ParseException, MalformedURLException, JSONException{ 
				ArrayList<Tweet> previousArray= new ArrayList<Tweet>();
				ArrayList<Tweet> filteredArray= new ArrayList<Tweet>();
			//vedere se posso anche non istanziarlo qui
				HashMap<String,Object> result= new ObjectMapper().convertValue(filter, HashMap.class);

			//Itera con tutti gli elementi dell'ArrayList
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
				
				if(!(value.equals("and"))&&!(value.equals("or"))) {
					throw new FilterIllegalArgumentException("'and' o 'or' expected after 'type'");
				}
				continue;
			}
			
			filter= ServFilter.instanceFilter(column, operator, value);
			
			if (type == "and")
				try {
					filteredArray = ServFilter.Filtering(filter, previousArray, hash, column, value);
				} 
				catch (MalformedURLException | JSONException | ParseException | com.sun.el.parser.ParseException
						| java.text.ParseException e) {
					e.printStackTrace();
				}
			else if(type == "or")
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
	
