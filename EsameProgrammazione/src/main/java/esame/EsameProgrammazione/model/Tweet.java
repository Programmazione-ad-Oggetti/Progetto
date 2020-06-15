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
	private long followers;
	private String text;
	private String location;
	private String name;
	private String screen_name;
	private String url;
	
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScreen_name() {
		return screen_name;
	}

	public void setScreen_name(String screen_name) {
		this.screen_name = screen_name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

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
	
	public long getFollowers() {
		return followers;
	}

	public void setFollowers(long followers) {
		this.followers = followers;
	}
	
	
}
