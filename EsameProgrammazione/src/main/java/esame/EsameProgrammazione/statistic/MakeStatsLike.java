package esame.EsameProgrammazione.statistic;

import java.util.ArrayList;

import esame.EsameProgrammazione.model.Tweet;

public class MakeStatsLike {
	/**
	 * The function that calculate the average.
	 * @param data the Records where to get the information for calcuting the average
	 * @param field the field of which the average has to be calculated
	 * @return the average
	 */
	public double LikeAverage(ArrayList<Tweet> tweets) {

		return LikeSum(tweets) / LikeList(tweets).size();

	}

	/**
	 * The function that calculate the sum.
	 * @param data the Records where to get the information for calcuting the sum
	 * @param field the field of which the sum has to be calculated
	 * @return the sum
	 */
	public double LikeSum(ArrayList<Tweet> tweets) {
		double sum = 0;
		for (int i = 0; i < LikeList(tweets).size(); i++)
			sum += LikeList(tweets).get(i);
		return sum;
	}

	/**
	 * The function that find the max value of the field passed
	 * @param data the Records where to get the information for finding the max value
	 * @param field the field of which the max has to be founded
	 * @return the max
	 */
	public double LikeMax(ArrayList<Tweet> tweets) {
		double max = Double.MIN_VALUE;
		ArrayList<Double> support = LikeList(tweets);
		for (int i = 0; i < support.size(); i++) {
			if (support.get(i) > max)
				max = support.get(i);
		}
		return max;
	}

	/**
	 * The function that find the min value of the field passed
	 * @param data the Records where to get the information for finding the min value
	 * @param field the field of which the min has to be founded
	 * @return the min
	 */
	public double LikeMin(ArrayList<Tweet> tweets) {
		double min = Double.MAX_VALUE;
		ArrayList<Double> support = LikeList(tweets);
		for (int i = 0; i < support.size(); i++) {
			if (support.get(i) < min)
				min = support.get(i);
		}
		return min;
	}

	/**
	 * The function that calculate the variance.
	 * @param data the Records where to get the information for calcuting the variance
	 * @param field the field of which the variance has to be calculated
	 * @return the variance
	 */
	public double LikeVariance(ArrayList<Tweet> tweets) {
		double variance = 0;

		ArrayList<Double> support = LikeList(tweets);
		for (int i=0; i<support.size();i++) {
			variance += Math.pow((support.get(i) - LikeAverage(tweets)), 2);
		}
		return variance / support.size();
	}

	/**
	 * This function is used to find all the values of a field of the images of the database
	 * @param data the Records where to take the information to calculate stats
	 * @param field the field of which the stats has to be calculated
	 * @return an ArraList of the value of the images of the records that satisfy the field passed
	 */
	public ArrayList<Double> LikeList(ArrayList<Tweet> tweets){
		
		ArrayList<Double> listaTweet = new ArrayList<Double>();
		
		//this for is used to take all the image information that are usefull to calculate the different stats, switching between the different field passed
		for(int i =0; i < tweets.size();i++) {
			listaTweet.add((double)tweets.get(i).getLike());
		}
	
		return listaTweet;
	}
}
