package esame.EsameProgrammazione.model;

import java.util.ArrayList;

/** 
 * Classe che descrive la struttura di un filtro
 * 
 * @author Antonio Colucci
 * @author Carmen Andreozzi
 */
public class FilterStruct {
	
	private String field = ""; //Campo inserito 
	private String operator = ""; //Operatore inserito
	private ArrayList<String> values = new ArrayList<String>();

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public ArrayList<String> getValues() {
		return values;
	}

	public void setValues(String[] values) {
		for(String str : values) {
			this.values.add(str);
		}
	}
	
}
