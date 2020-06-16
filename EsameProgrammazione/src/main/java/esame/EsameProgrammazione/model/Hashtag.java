package esame.EsameProgrammazione.model;

import org.springframework.stereotype.Service;

/** 
 * Classe che rappresenta la struttura di un hashtag
 * 
 * @author Antonio Colucci
 * @author Carmen Andreozzi
 */
@Service
public class Hashtag {
	
	protected String testo; //Il testo dell'hashtag
	
	/**
	 * Costruttore che imposta il testo passato
	 * 
	 * @param testo
	 */
	public Hashtag(String testo) {
		this.testo = testo;
	}

	public Hashtag() {}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}
	
}
