package esame.EsameProgrammazione.model;

import java.util.ArrayList;

/** 
 * Classe che descrive la struttura di un filtro
 * 
 * @author Colucci Antonio
 * @author Andreozzi Carmen
 */
public class FilterStruct {
	
	private String field = ""; //Campo inserito 
	private String operator = ""; //Operatore inserito
	private ArrayList<String> values = new ArrayList<String>();

	/**
	 * @return Il campo del filtro
	 */
	public String getField() {
		return field;
	}

	/**
	 * @param field
	 */
	public void setField(String field) {
		this.field = field;
	}

	/**
	 * @return L'operatore del filtro
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * @param operator
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	
	/**
	 * @return Lista dei valori
	 */
	public ArrayList<String> getValues() {
		return values;
	}

	/**
	 * @param values
	 */
	public void setValues(String[] values) {
		for(String str : values) {
			this.values.add(str);
		}
	}
}
