package esame.EsameProgrammazione.model;

/**
 * Classe che descrive la struttura di una data
 * 
 * @author Colucci Antonio
 * @author Andreozzi Carmen
 */
public class OurDate {
	private String day;
	private String month;
	private String year;
	
	/**
	 * @return day
	 */
	public String getDay() {
		return day;
	}
	
	/**
	 * @param day Giorno del mese scritto in numeri
	 */
	public void setDay(String day) {
		this.day = day;
	}
	
	/**
	 * @return month
	 */
	public String getMonth() {
		return month;
	}
	
	/**
	 * @param month Mese scritto in inglese, ma solo con le prime 3 lettere
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	
	/**
	 * @return year
	 */
	public String getYear() {
		return year;
	}
	
	/**
	 * @param year Anno
	 */
	public void setYear(String year) {
		this.year = year;
	}
}
