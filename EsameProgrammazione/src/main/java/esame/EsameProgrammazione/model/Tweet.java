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
	private String data;
	private ArrayList<Hashtag> hashtag;
	private long ID;
	private int like;
	
	
	//Costruttore
	public Tweet(String data, ArrayList<Hashtag> hashtag, long ID, int like) {
		super();
		this.data = data;
		this.hashtag = hashtag;
		this.ID = ID;
		this.like = like;
	}
	
	public Tweet() {
		super();
	}

	
	public ArrayList<Hashtag> getHashtag() {
		return hashtag;
	}


	public void setHashtag(Hashtag hashtg) {
		hashtag.add(hashtg);
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

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}
	
}
