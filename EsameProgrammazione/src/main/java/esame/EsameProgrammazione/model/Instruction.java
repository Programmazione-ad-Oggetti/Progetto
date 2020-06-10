package esame.EsameProgrammazione.model;

import java.util.ArrayList;

public class Instruction {
	
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
}
