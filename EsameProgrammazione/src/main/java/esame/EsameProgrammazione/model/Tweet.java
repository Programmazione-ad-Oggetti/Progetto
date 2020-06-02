package esame.EsameProgrammazione.model;

import java.util.ArrayList;

/////********************************************/////
///// IN QUESTA CLASSE SONO PRESENTI GLI OGGETTI /////
/////  RAPPRESENTANTI LA STRUTTURA DI UN TWEET   /////
/////********************************************/////

/** @author Antonio Colucci
 *  @author Carmen Andreozzi
*/

public class Tweet extends Hashtag{
	protected String data;
	protected ArrayList<Hashtag> hashtag;
	
	//Costruttore
	public Tweet(String data, ArrayList<Hashtag> hashtag) {
		super();
		this.data = data;
		this.hashtag = hashtag;
	}
	
	public Tweet() {
		super();
	}

	
	public ArrayList<Hashtag> getHashtag() {
		return hashtag;
	}


	public void setHashtag(ArrayList<Hashtag> hashtag) {
		this.hashtag = hashtag;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}
	
	
}
