package esame.EsameProgrammazione.filter;

/////*********************************************************************/////
/////   QUESTA E' LA SUPERCLASSE PER LE CLASSI CHE IMPLEMENTANO I FILTR   /////
/////*********************************************************************/////

/** @author Antonio Colucci
* 	@author Carmen Andreozzi
*/

public class FilterParent {
	
	protected String parametro;

	
	//Costruttore in cui viene controllato il tipo di parametro preso in input, nel nostro caso una stringa.
	public FilterParent(Object parametro) {
		if (parametro instanceof String)
			this.parametro = (String)parametro;
		else {
			throw new IllegalArgumentException("Il valore inserito non è una stringa");
		}
	}
	
	public void setParametro(Object parametro) {
		if (parametro instanceof String)
			this.parametro = (String)parametro;
		else {
			throw new IllegalArgumentException("Il valore inserito non è una stringa");
		}
	}

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

		
	
	
	
	
	

}
