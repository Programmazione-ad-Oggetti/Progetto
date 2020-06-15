package esame.EsameProgrammazione.filter;


/** 
 * Superclasse ereditata dalla classe EqDataFilter
 * 
 * @author Antonio Colucci
 * @author Carmen Andreozzi
*/

public class FilterParentString {

	protected String parametro;

	
	/**
	 * Costruttore in cui viene controllato il tipo di parametro preso in input, nel nostro caso una stringa.
	 * 
	 * @param parametro
	 */
	public FilterParentString(Object parametro) {
		if (parametro instanceof String)
			this.parametro = (String)parametro;
		else {
			throw new IllegalArgumentException("Il valore inserito non e' una stringa");
		}
	}
	
	/**
	 * Viene controllato il tipo di parametro preso in input, nel nostro caso una stringa.
	 * 
	 * @param parametro
	 */
	public void setParametro(Object parametro) {
		if (parametro instanceof String)
			this.parametro = (String)parametro;
		else {
			throw new IllegalArgumentException("Il valore inserito non e' una stringa");
		}
	}

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

}
