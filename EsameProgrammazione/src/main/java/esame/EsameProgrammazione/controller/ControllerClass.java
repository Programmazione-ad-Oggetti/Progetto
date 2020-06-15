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

@RestController
public class ControllerClass {
	@Autowired
	ServTweetsImpl ServTweetsImpl;

	
	//VIENE LETTO IL FILE CONTENENTE LE ISTRUZIONI D'USO DELL'API
	@GetMapping("/GetInstructions")
	public ResponseEntity<Object> getInstruction(){
		InstructionReader instructions = new InstructionReader();
		return new ResponseEntity<>(instructions.getInstructions(), HttpStatus.OK);
	}
	
	
	//VIENE RESTITUITA LA LISTA DEI TWEET
	@RequestMapping(value = "/GetTweets/{hashtag}", method = RequestMethod.GET)
	public ResponseEntity<Object> setTesto(@PathVariable("hashtag") String testo) throws ParseException{
		
		Hashtag hash = new Hashtag();
		hash.setTesto(testo);
		ServTweetsImpl = new ServTweetsImpl(hash);
		return new ResponseEntity<>(ServTweetsImpl.getTweets(), HttpStatus.OK);
	}
	
	
	//VIENE RESTITUITA LA LISTA DEI TWEET CON UN CERTO FILTRO
	@RequestMapping(value = "/GetFilteredTweets/{hashtag}", method = RequestMethod.GET)
	public ResponseEntity<Object> setTesto(@PathVariable("hashtag") String testo, @RequestBody Object param) throws ParseException, FilterNotFoundException, FilterIllegalArgumentException, InternalGeneralException, MalformedURLException, JSONException{
		
		Hashtag hash = new Hashtag();
		hash.setTesto(testo);
		ServTweetsImpl = new ServTweetsImpl(hash);
		return new ResponseEntity<>(RecognizeFilter.JsonParserColumn(param, hash), HttpStatus.OK);
	}
	
	
	//VENGONO RESTITUITE LE STATISTICHE RELATIVE AI LIKE
	@PostMapping("/GetStats/{hashtag}")
	public ResponseEntity<Object> getStatsOfLike(@PathVariable("hashtag") String testo, 
								  				 @RequestBody Object filter) 
					  	throws InternalGeneralException, StatsNotFoundException, FilterNotFoundException, FilterIllegalArgumentException, MalformedURLException, JSONException {

		Hashtag hash = new Hashtag();
		hash.setTesto(testo);
		
		return new ResponseEntity<>(ServTweetsImpl.VisualizeStats(filter, hash), HttpStatus.OK);
	}
	
	@PostMapping("/GetFieldStats/{hashtag}")
	public ResponseEntity<Object> getFieldStatistic(@PathVariable("hashtag") String testo, @RequestParam(name="field")String field,@RequestBody Object filter ) throws FailedLoginException, MismatchedInputException, FailedLoginException, OpenDataException, SaslException, FilterNotFoundException, FilterIllegalArgumentException, MalformedURLException, JSONException, InternalGeneralException, ParseException{

		Hashtag hash = new Hashtag();
		hash.setTesto(testo);
		return new ResponseEntity<>(ServTweetsImpl.VisualizeStatsField(filter, field, hash),HttpStatus.OK);
	}	
	
	//VENGONO RESTITUITE LE STATISTICHE RELATIVE ALLA DATA
	@PostMapping("/GetStatsDate/{hashtag}")
	public ResponseEntity<Object> getStatsOfDate(@PathVariable("hashtag") String testo, 
								  				 @RequestBody Object filter) 
					  	throws InternalGeneralException, StatsNotFoundException, FilterNotFoundException, FilterIllegalArgumentException, MalformedURLException, JSONException {

		Hashtag hash = new Hashtag();
		hash.setTesto(testo);
		
		return new ResponseEntity<>(ServTweetsImpl.StatsVisualizeDate(filter, hash), HttpStatus.OK);
	}
}
