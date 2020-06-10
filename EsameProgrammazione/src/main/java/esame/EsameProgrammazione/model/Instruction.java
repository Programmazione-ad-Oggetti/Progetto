package esame.EsameProgrammazione.model;

import java.util.ArrayList;

public class Instruction {
<<<<<<< HEAD
	
	
	//INTRODUZIONE DELL'ISTRUZIONE
	private String introduzione = "";

	//ARRAY DELLE DIVERE POSSIBILITA'
	private ArrayList<String> scelta = new ArrayList<String>();

	/**
	 * GETTER DELL'ATTRIBUTO "introduzione"
	 * @return introduction
	 */
	public String getIntroduzione() {
		return introduzione;
	}

	/**
	 * SETTER DELL'ATTRIBUTO "introduzione"
	 * @param intro L'introduzione da settare
	 */
	 public void setIntroduzione(String intro) {
		this.introduzione = intro;
	}

	/**
	 * GETTER DELL'ARRAYLIST "scelta"
	 * @return scelta
	 */
	public ArrayList<String> getScelta() {
		return scelta;
	}

	/**
	 * SETTER DELL'ARRAYLIST "scelta"
	 * @param choice 
	 */
	 public void setScelta(String[] choice) {
		for(int i=0;i<choice.length;i++)
			this.scelta.add(choice[i]);
	}
=======
	private String introduzione = "";

	/**
	 * An array with the different possibilities.
	 */
	private ArrayList<String> scelta = new ArrayList<String>();

	/**
	 * Getter for variable introduction
	 * @return introduction
	 */
	public String getIntroduzione() {
		return introduzione;
	}

	/**
	 * Setter for variable introduction
	 * @param intro the intro to set
	 */
	 public void setIntroduzione(String intro) {
		this.introduzione = intro;
	}

	/**
	 * Getter for the ArrayList possibilities
	 * @return possibilities
	 */
	public ArrayList<String> getScelta() {
		return scelta;
	}

	/**
	 * Setter for the ArrayList possibilities
	 * @param possibility to add at the end of the array
	 */
	 public void setPossibility(String[] choice) {
		for(int i=0;i<choice.length;i++)
			this.scelta.add(choice[i]);
	}
	
	
>>>>>>> branch 'master' of https://github.com/Programmazione-ad-Oggetti/Progetto.git
}
