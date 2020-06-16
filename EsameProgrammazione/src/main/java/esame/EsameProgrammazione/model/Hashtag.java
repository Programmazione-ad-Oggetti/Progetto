package esame.EsameProgrammazione.model;

import org.springframework.stereotype.Service;

/** 
 * Classe che rappresenta la struttura di un hashtag
 * 
 * @author Colucci Antonio
 * @author Andreozzi Carmen
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

	/**
	 * Costruttore di default
	 */
	public Hashtag() {}

	/**
	 * @return Testo dell'hashtag
	 */
	public String getTesto() {
		return testo;
	}

	/**
	 * @param testo
	 */
	public void setTesto(String testo) {
		this.testo = testo;
	}
	
}
