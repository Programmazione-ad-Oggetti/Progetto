package esame.EsameProgrammazione.filter;

/////*********************************************************************/////
/////   QUESTA E' LA SUPERCLASSE PER LE CLASSI CHE IMPLEMENTANO I FILTRI  /////
/////*********************************************************************/////

/** @author Antonio Colucci
* 	@author Carmen Andreozzi
*/

public class FilterParent {
	
	protected int parametro;

	
	//Costruttore in cui viene controllato il tipo di parametro preso in input, nel nostro caso un intero.
	public FilterParent(Object parametro) {
		if (parametro instanceof Integer)
			this.parametro = (Integer)parametro;
		else {
			throw new IllegalArgumentException("Il valore inserito non e' un intero");
		}
	}
	
	public void setParametro(Object parametro) {
		if (parametro instanceof Integer)
			this.parametro = (Integer)parametro;
		else {
			throw new IllegalArgumentException("Il valore inserito non e' un intero");
		}
	}

	public int getParametro() {
		return parametro;
	}

	public void setParametro(int parametro) {
		this.parametro = parametro;
	}

}
