package esame.EsameProgrammazione.model;

import java.util.ArrayList;

/////*****************************************/////
/////   CREAZIONE DELLA CLASSE CHE DESCRIVE   /////
/////      LA STRUTTURA DI UN FILTRO          /////
/////*****************************************/////

/** @author Antonio Colucci
* 	@author Carmen Andreozzi
*/

public class FilterStruct {
	
	private String field = "";
	private String operator = "";
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
