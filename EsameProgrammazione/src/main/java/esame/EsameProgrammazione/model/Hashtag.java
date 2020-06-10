package esame.EsameProgrammazione.model;

import org.springframework.stereotype.Service;

/////*****************************************/////
///// QUESTA CLASSE RAPPRESENTA LA STRUTTURA  /////
/////             DI UN HASHTAG               /////
/////*****************************************/////

/** @author Antonio Colucci
*  @author Carmen Andreozzi
*/

@Service
public class Hashtag {
	
	protected String testo;

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
