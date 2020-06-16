package esame.EsameProgrammazione.statistic;

import java.util.ArrayList;

import esame.EsameProgrammazione.model.Tweet;

/**
 * Classe che implementa tutti i metodi per eseguire le statistiche
 * 
 * @author Colucci Antonio
 * @author Andreozzi Carmen
 */
public class MakeStats {
	
	/**
	 * Viene calcolata la media
	 * 
	 * @param tweets I Tweets da cui vengono prese le informazioni per il calcolo della media
	 * @param field Il campo sul quale verrà calcolata la media
	 * @return La media
	 */
	public double Average(ArrayList<Tweet> tweets, String field) {

		return Sum(tweets,field) / List(tweets,field).size();

	}

	/**
	 * Viene calcolata la somma
	 * 
	 * @param tweets I Tweets da cui vengono prese le informazioni per il calcolo della somma
	 * @param field Il campo sul quale verrà calcolata la somma
	 * @return La somma
	 */
	public double Sum(ArrayList<Tweet> tweets,String field) {
		double sum = 0;
		for (int i = 0; i < List(tweets,field).size(); i++)
			sum += List(tweets,field).get(i);
		return sum;
	}

	/**
	 * Viene determinato il massimo valore del campo inserito
	 * 
	 * @param tweets I Tweets da cui vengono prese le informazioni per determinare il massimo
	 * @param field Il campo sul quale verrà determinato il massimo
	 * @return Il massimo valore
	 */
	public double Max(ArrayList<Tweet> tweets,String field) {
		double max = Double.MIN_VALUE;
		ArrayList<Double> support = List(tweets,field);
		for (int i = 0; i < support.size(); i++) {
			if (support.get(i) > max)
				max = support.get(i);
		}
		return max;
	}

	/**
	 * Viene determinato il minimo valore del campo inserito
	 * 
	 * @param tweets I Tweets da cui vengono prese le informazioni per determinare il minimo
	 * @param field Il campo sul quale verrà determinato il minimo
	 * @return Il minimo valore
	 */
	public double Min(ArrayList<Tweet> tweets,String field) {
		double min = Double.MAX_VALUE;
		ArrayList<Double> support = List(tweets,field);
		for (int i = 0; i < support.size(); i++) {
			if (support.get(i) < min)
				min = support.get(i);
		}
		return min;
	}

	/**
	 * Viene calcolata la varianza
	 * 
	 * @param tweets I Tweets da cui vengono prese le informazioni per il calcolo della varianza
	 * @param field Il campo sul quale verrà calcolata la varianza
	 * @return La varianza
	 */
	public double Variance(ArrayList<Tweet> tweets,String field) {
		double variance = 0;

		ArrayList<Double> support = List(tweets,field);
		for (int i=0; i<support.size();i++) {
			variance += Math.pow((support.get(i) - Average(tweets,field)), 2);
		}
		return variance / support.size();
	}

	/**
	 * Viene riempita la lista con i tweet di un certo campo
	 * 
	 * @param tweets I Tweets da cui vengono prese le informazioni per il calcolo delle statistiche
	 * @param field Il campo sul quale verranno calcolate le statistiche
	 * @return La lista dei tweet relitivi ad un certo campo
	 */
	public ArrayList<Double> List(ArrayList<Tweet> tweets, String field){
		
		ArrayList<Double> listaTweet = new ArrayList<Double>();
		
		for(int i =0; i < tweets.size();i++) {
				if(field.equals("Like"))
					listaTweet.add((double)tweets.get(i).getLike());
				else if(field.equals("Followers"))
					listaTweet.add((double)tweets.get(i).getFollowers());
				else if(field.equals("Friends"))
					listaTweet.add((double)tweets.get(i).getFriends());
		}
		return listaTweet;
	}
}
