package esame.EsameProgrammazione.model;

/** 
 * Classe che descrive la struttura di un tweet
 * 
 * @author Colucci Antonio
 * @author Andreozzi Carmen
 */
public class Tweet extends Hashtag{
	private String data;         //Data di un tweet
	private long ID;			 //ID di un tweet
	private long like;			 //Numero di like di un tweet
	private long followers;		 //Numero di followers dell'utente che ha pubblicato il tweet
	private String text;		 //Testo del tweet
	private String location;	 //Posizione geografica di un tweet
	private String name;		 //Nome dell'utente che ha pubblicato il tweet
	private String screen_name;	 //Screen name dell'utente che ha pubblicato il tweet
	private String url;			 //Url di un tweet
	private long friends;		 //Numero di amici dell'utente che ha pubblicato il tweet
	
	/**
	 * Costruttore che imposta gli attributi del tweet
	 * @param data
	 * @param ID
	 * @param like
	 * @param text
	 */
	public Tweet(String data, long ID, int like, String text) {
		super();
		this.data = data;
		this.ID = ID;
		this.like = like;
		this.text = text;
	}
	
	/**
	 * Costruttore di default
	 */
	public Tweet() {
		super();
	}

	/**
	 * @return numero di amici
	 */
	public long getFriends() {
		return friends;
	}
	/**
	 * @param friends
	 */
	public void setFriends(long friends) {
		this.friends = friends;
	}

	/**
	 * @return posizione geografica
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return nome dell'utente che ha pubblicato il tweet
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return screen name dell'utente che ha pubblicato il tweet
	 */
	public String getScreen_name() {
		return screen_name;
	}
	/**
	 * @param screen_name
	 */
	public void setScreen_name(String screen_name) {
		this.screen_name = screen_name;
	}

	/**
	 * @return url del tweet
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return testo del tweet
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
	}	

	/**
	 * @return data del tweet
	 */
	public String getData() {
		return data;
	}
	/**
	 * @param data
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @return ID del tweet
	 */
	public long getID() {
		return ID;
	}
	/**
	 * @param iD
	 */
	public void setID(long iD) {
		this.ID = iD;
	}

	/**
	 * @return numero di like
	 */
	public long getLike() {
		return like;
	}
	/**
	 * @param like
	 */
	public void setLike(long like) {
		this.like = like;
	}
	
	/**
	 * @return numero di followers
	 */
	public long getFollowers() {
		return followers;
	}
	/**
	 * @param followers
	 */
	public void setFollowers(long followers) {
		this.followers = followers;
	}
}
