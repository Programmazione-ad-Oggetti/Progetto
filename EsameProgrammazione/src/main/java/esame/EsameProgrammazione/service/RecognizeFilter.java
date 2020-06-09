package esame.EsameProgrammazione.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import esame.EsameProgrammazione.service.ServFilter;

import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;
import esame.EsameProgrammazione.exceptions.FilterIllegalArgumentException;
import esame.EsameProgrammazione.exceptions.FilterNotFoundException;
import esame.EsameProgrammazione.exceptions.InternalGeneralException;
import esame.EsameProgrammazione.model.*;

public class RecognizeFilter {
			
			public static ArrayList<Tweet> jsonParserOperator(Object filterParam, 
														       ArrayList<Tweet> previousArray,Hashtag hash) 
			throws FilterNotFoundException, FilterIllegalArgumentException, InternalGeneralException, ParseException {
				
				String type="";
				FilterStruct filter;
				String field = "Like";
				ArrayList<Tweet> filteredArray = new ArrayList<Tweet>();
				HashMap<String, Object> result = new ObjectMapper().convertValue(filterParam, HashMap.class);
			
				for(Map.Entry<String, Object> entry : result.entrySet()) {
					
				    String operator = entry.getKey();
				    Object value = entry.getValue();
				    // Se operatore è type allora guarda se il valore è 'and' o 'or'
				    // lancia il metodo runfilter corrispondente
				    if(operator.equals("type") || operator.equals("Type")) {
				    	type = (String) value;
				    	if(!(value.equals("and")) && !(value.equals("or"))) {
				    		throw new FilterIllegalArgumentException("'and' o 'or' expected after 'type'");
				    	}
				    	continue;
				    }
				   
				    
				    filter = ServFilter.instanceFilter(field, operator, value);
				    switch(type) {
				    
					    case "and":
					    	filteredArray = ServFilter.Filtering(previousArray, filter);
					    	break;
					    case "or":
					    	filteredArray = ServFilter.FilteringOr(filter, previousArray,hash);
					    	break;
					    default:
					    	filteredArray = ServFilter.FilteringOr(filter, previousArray,hash);		    	
				    }
				}
				return filteredArray;	
			}
}
