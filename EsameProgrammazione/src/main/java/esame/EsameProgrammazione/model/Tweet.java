package esame.EsameProgrammazione.model;

/////********************************************/////
///// IN QUESTA CLASSE SONO PRESENTI GLI OGGETTI /////
/////  RAPPRESENTANTI LA STRUTTURA DI UN TWEET   /////
/////********************************************/////

/** @author Antonio Colucci
 *  @author Carmen Andreozzi
*/

public class Tweet {
	protected String hashtag;
	protected String data;
	
	//Costruttore
	public Tweet(String hashtag, String data) {
		super();
		this.hashtag = hashtag;
		this.data = data;
	}

	
	public String getHashtag() {
		return hashtag;
	}


	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}
	
	
}
