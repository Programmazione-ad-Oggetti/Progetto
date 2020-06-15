package esame.EsameProgrammazione.statistic;

import java.util.ArrayList;

import esame.EsameProgrammazione.model.Tweet;

public class MakeStats {
	/**
	 * The function that calculate the average.
	 * @param tweets i Tweets where to get the information for calcuting the average
	 * @param field the field of which the average has to be calculated
	 * @return the average
	 */
	public double Average(ArrayList<Tweet> tweets, String field) {

		return Sum(tweets,field) / List(tweets,field).size();

	}

	/**
	 * The function that calculate the sum.
	 * @param tweets the Tweets where to get the information for calcuting the sum
	 * @param field the field of which the sum has to be calculated
	 * @return the sum
	 */
	public double Sum(ArrayList<Tweet> tweets,String field) {
		double sum = 0;
		for (int i = 0; i < List(tweets,field).size(); i++)
			sum += List(tweets,field).get(i);
		return sum;
	}

	/**
	 * The function that find the max value of the field passed
	 * @param tweets the Tweets where to get the information for finding the max value
	 * @param field the field of which the max has to be founded
	 * @return the max
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
	 * The function that find the min value of the field passed
	 * @param tweets the Tweets where to get the information for finding the min value
	 * @param field the field of which the min has to be founded
	 * @return the min
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
	 * The function that calculate the variance.
	 * @param tweets the Tweets where to get the information for calcuting the variance
	 * @param field the field of which the variance has to be calculated
	 * @return the variance
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
	 * This function is used to find all the values of a field of the images of the database
	 * @param tweets the Tweets where to take the information to calculate stats
	 * @param field the field of which the stats has to be calculated
	 * @return an ArraList of the value of the images of the records that satisfy the field passed
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
