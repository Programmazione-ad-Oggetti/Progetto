package esame.EsameProgrammazione.model;

/////********************************************/////
///// IN QUESTA CLASSE SONO PRESENTI GLI OGGETTI /////
/////  RAPPRESENTANTI LA STRUTTURA DI UN TWEET   /////
/////********************************************/////

/** @author Antonio Colucci
 *  @author Carmen Andreozzi
*/

public class Tweet extends Hashtag{
	private String data;
	private long ID;
	private long like;
	private String text;
	
	
	//Costruttore
	public Tweet(String data, long ID, int like,String text) {
		super();
		this.data = data;
		this.ID = ID;
		this.like = like;
		this.text = text;
	}
	
	public Tweet() {
		super();
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}	


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		this.ID = iD;
	}

	public long getLike() {
		return like;
	}

	public void setLike(long like) {
		this.like = like;
	}
	
}
