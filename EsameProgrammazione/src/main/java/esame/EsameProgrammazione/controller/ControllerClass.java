package esame.EsameProgrammazione.controller;

import java.net.MalformedURLException;
import java.util.ArrayList;

import javax.management.openmbean.OpenDataException;
import javax.security.auth.login.FailedLoginException;
import javax.security.sasl.SaslException;

import org.json.JSONException;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;

import esame.EsameProgrammazione.exceptions.FilterIllegalArgumentException;
import esame.EsameProgrammazione.exceptions.FilterNotFoundException;
import esame.EsameProgrammazione.exceptions.InternalGeneralException;
import esame.EsameProgrammazione.exceptions.StatsNotFoundException;
import esame.EsameProgrammazione.model.Hashtag;
import esame.EsameProgrammazione.service.InstructionReader;
import esame.EsameProgrammazione.service.RecognizeFilter;
import esame.EsameProgrammazione.service.ServTweetsImpl;

/**
 * Classe nella quale vengono modellate le richieste API
 * 
 * @author Colucci Antonio
 * @author Andreozzi Carmen
 *
 */

@RestController
public class ControllerClass {
	@Autowired
	ServTweetsImpl ServTweetsImpl;

	
	/**
	 * Viene letto il file contenente le istruzioni d'uso dell'API
	 * 
	 * @return Istruzioni
	 */
	@GetMapping("/GetInstructions")
	public ResponseEntity<Object> getInstruction(){
		InstructionReader instructions = new InstructionReader();
		return new ResponseEntity<>(instructions.getInstructions(), HttpStatus.OK);
	}
	
	
	/**
	 * Viene restituita la lista dei Tweet corrispondenti ad 
	 * un certo hashtag inserito nella rotta
	 * 
	 * @param testo
	 * @return la lista dei tweet
	 * @throws ParseException
	 */
	@RequestMapping(value = "/GetTweets/{hashtag}", method = RequestMethod.GET)
	public ResponseEntity<Object> getTweets(@PathVariable("hashtag") String testo) throws ParseException{
		
		Hashtag hash = new Hashtag();
		hash.setTesto(testo);
		ServTweetsImpl = new ServTweetsImpl(hash);
		return new ResponseEntity<>(ServTweetsImpl.getTweets(), HttpStatus.OK);
	}
	
	
	/**
	 * Viene restituita la lista dei Tweet con un certo Filtro
	 * 
	 * @param testo
	 * @param param
	 * @return lista dei tweet filtrati
	 * @throws ParseException
	 * @throws FilterNotFoundException
	 * @throws FilterIllegalArgumentException
	 * @throws InternalGeneralException
	 * @throws MalformedURLException
	 * @throws JSONException
	 */
	@RequestMapping(value = "/GetFilteredTweets/{hashtag}", method = RequestMethod.GET)
	public ResponseEntity<Object> getFilteredTweets(@PathVariable("hashtag") String testo, @RequestBody Object param) throws ParseException, FilterNotFoundException, FilterIllegalArgumentException, InternalGeneralException, MalformedURLException, JSONException{
		
		Hashtag hash = new Hashtag();
		hash.setTesto(testo);
		ServTweetsImpl = new ServTweetsImpl(hash);
		return new ResponseEntity<>(RecognizeFilter.JsonParserColumn(param, hash), HttpStatus.OK);
	}
	
	
	/**
	 * Vengono restituite tutte le statistiche
	 * 
	 * @param testo
	 * @param filter
	 * @return statistiche relative ai like
	 * @throws InternalGeneralException
	 * @throws StatsNotFoundException
	 * @throws FilterNotFoundException
	 * @throws FilterIllegalArgumentException
	 * @throws MalformedURLException
	 * @throws JSONException
	 */
	@PostMapping("/GetStats/{hashtag}")
	public ResponseEntity<Object> getStats(@PathVariable("hashtag") String testo, 
								  				 @RequestBody Object filter) 
					  	throws InternalGeneralException, StatsNotFoundException, FilterNotFoundException, FilterIllegalArgumentException, MalformedURLException, JSONException {

		Hashtag hash = new Hashtag();
		hash.setTesto(testo);
		
		return new ResponseEntity<>(ServTweetsImpl.VisualizeStats(filter, hash), HttpStatus.OK);
	}
	
	/**
	 * Vengono restituite le statistiche relative ad un determinato campo (Field)
	 * 
	 * @param testo
	 * @param field
	 * @param filter
	 * @return statistiche relative al "field" inserito
	 * @throws FailedLoginException
	 * @throws MismatchedInputException
	 * @throws FailedLoginException
	 * @throws OpenDataException
	 * @throws SaslException
	 * @throws FilterNotFoundException
	 * @throws FilterIllegalArgumentException
	 * @throws MalformedURLException
	 * @throws JSONException
	 * @throws InternalGeneralException
	 * @throws ParseException
	 * @throws StatsNotFoundException 
	 */
	@PostMapping("/GetFieldStats/{hashtag}")
	public ResponseEntity<Object> getFieldStats(@PathVariable("hashtag") String testo, @RequestParam(name="field")String field,@RequestBody Object filter ) throws FailedLoginException, MismatchedInputException, FailedLoginException, OpenDataException, SaslException, FilterNotFoundException, FilterIllegalArgumentException, MalformedURLException, JSONException, InternalGeneralException, ParseException, StatsNotFoundException{

		Hashtag hash = new Hashtag();
		hash.setTesto(testo);
		return new ResponseEntity<>(ServTweetsImpl.VisualizeStatsField(filter, field, hash),HttpStatus.OK);
	}	
	
	/**
	 * Vengono restituite le statistiche relative alla data
	 * 
	 * @param testo
	 * @param filter
	 * @return numero di tweet pubblicati in una certa data
	 * @throws InternalGeneralException
	 * @throws StatsNotFoundException
	 * @throws FilterNotFoundException
	 * @throws FilterIllegalArgumentException
	 * @throws MalformedURLException
	 * @throws JSONException
	 */
	@PostMapping("/GetStatsDate/{hashtag}")
	public ResponseEntity<Object> getStatsOfDate(@PathVariable("hashtag") String testo, 
								  				 @RequestBody Object filter) 
					  	throws InternalGeneralException, StatsNotFoundException, FilterNotFoundException, FilterIllegalArgumentException, MalformedURLException, JSONException {

		Hashtag hash = new Hashtag();
		hash.setTesto(testo);
		
		return new ResponseEntity<>(ServTweetsImpl.StatsVisualizeDate(filter, hash), HttpStatus.OK);
	}
	
	@PostMapping("/GetStatsLocation/{hashtag}")
	public ResponseEntity<Object> getStatsOfLocation(@PathVariable("hashtag") String testo, 
								  				 @RequestBody Object filter) 
					  	throws InternalGeneralException, StatsNotFoundException, FilterNotFoundException, FilterIllegalArgumentException, MalformedURLException, JSONException {

		Hashtag hash = new Hashtag();
		hash.setTesto(testo);
		
		return new ResponseEntity<>(ServTweetsImpl.StatsVisualizeLocation(filter, hash), HttpStatus.OK);
	}
}
