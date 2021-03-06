package esame.EsameProgrammazione.database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONException;
import org.json.simple.*;
import org.json.simple.parser.ParseException;

import esame.EsameProgrammazione.model.Hashtag;

/** 
 * Rappresenta la classe che gestisce l'inizializzazione del dataset
 * 
 * @author Antonio Colucci
 * @author Carmen Andreozzi
*/
public class DatabaseClass {
	
	/**
	 * Questo metodo effettua il download del JSON contenente i tweet dall'URL impostato
	 * 
	 * @param hash
	 * @return il JSON scaricato
	 * @throws ParseException
	 * @throws MalformedURLException
	 */
	public static JSONObject JSONdownloader(Hashtag hash) throws ParseException, MalformedURLException {
		String url = "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/search/tweets.json?q="+hash.getTesto()+"&count=100000";
		
		String data = "";
		String line = "";
		
		try {
			URLConnection openConnection = new URL(url).openConnection();
			openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
			InputStream in = openConnection.getInputStream();
			
		
			try {
				   InputStreamReader inR = new InputStreamReader( in );
				   
				   BufferedReader buf = new BufferedReader( inR );
				  
				   while ( ( line = buf.readLine() ) != null ) {
					   data+= line;
				   }
			} finally {
				 in.close();
			}
		} catch (IOException e) {	
			e.printStackTrace();	
		} catch (Exception e) {	
			e.printStackTrace();	
			}
		
		JSONObject json = new JSONObject();
		
		json = (JSONObject) JSONValue.parse(data);
		
		return json;
		
	 }
}


