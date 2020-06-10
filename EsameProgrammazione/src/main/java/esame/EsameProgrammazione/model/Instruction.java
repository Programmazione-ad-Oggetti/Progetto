package esame.EsameProgrammazione.model;

import java.util.ArrayList;

public class Instruction {
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
	
	
}
