package esame.EsameProgrammazione.model;

/** In questa classe sono presenti gli oggetti rappresentanti la struttura di un Tweet.
 * @author Antonio Colucci
 * @author Carmen Andreozzi
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
