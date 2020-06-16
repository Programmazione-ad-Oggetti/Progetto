package esame.EsameProgrammazione.model;

import java.util.ArrayList;

/**
 * Classe che descrive la struttura delle istruzioni
 * 
 * @author Colucci Antonio
 * @author Andreozzi Carmen
 */
public class Instruction {
	
	//Introduzione dell'istruzione
	private String introduzione = "";

	//Array delle diverse possibilità
	private ArrayList<String> scelta = new ArrayList<String>();

	/**
	 * @return introduction
	 */
	public String getIntroduzione() {
		return introduzione;
	}

	/**
	 * @param intro L'introduzione da settare
	 */
	 public void setIntroduzione(String intro) {
		this.introduzione = intro;
	}

	/**
	 * @return scelta
	 */
	public ArrayList<String> getScelta() {
		return scelta;
	}

	/**
	 * @param choice
	 */
	 public void setScelta(String[] choice) {
		for(int i=0;i<choice.length;i++)
			this.scelta.add(choice[i]);
	}

}
