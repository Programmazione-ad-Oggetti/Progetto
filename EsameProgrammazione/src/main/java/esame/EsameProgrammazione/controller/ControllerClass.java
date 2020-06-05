package esame.EsameProgrammazione.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import esame.EsameProgrammazione.model.Hashtag;
import esame.EsameProgrammazione.service.ServTweetsImpl;

@RestController
public class ControllerClass {
	
	
	//VIENE RESTITUITA LA LISTA DEI PRODOTTI
	@RequestMapping(value = "/tweets/{hashtag}")
	public ResponseEntity<Object> setTesto(@PathVariable("hashtag") String testo){
		
		Hashtag hash = new Hashtag();
		hash.setTesto(testo);
		return new ResponseEntity<>(ServTweetsImpl.getTweets(), HttpStatus.OK);
	}
}
