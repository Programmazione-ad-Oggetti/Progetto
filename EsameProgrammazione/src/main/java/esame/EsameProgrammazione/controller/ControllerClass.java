package esame.EsameProgrammazione.controller;


import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import esame.EsameProgrammazione.model.Hashtag;
import esame.EsameProgrammazione.service.InstructionReader;
import esame.EsameProgrammazione.service.ServTweetsImpl;

@RestController
public class ControllerClass {
	@Autowired
	ServTweetsImpl ServTweetsImpl;
	
	
	@GetMapping("/GetInstructions")
	public ResponseEntity<Object> getInstruction(){
		return new ResponseEntity<>(InstructionReader.getInstructions(),HttpStatus.OK);
	}
	
	//VIENE RESTITUITA LA LISTA DEI PRODOTTI
	@RequestMapping(value = "/tweets/{hashtag}", method = RequestMethod.GET)
	public ResponseEntity<Object> setTesto(@PathVariable("hashtag") String testo) throws ParseException{
		
		Hashtag hash = new Hashtag();
		hash.setTesto(testo);
		ServTweetsImpl = new ServTweetsImpl(hash);
		return new ResponseEntity<>(ServTweetsImpl.getTweets(), HttpStatus.OK);
	}
}
