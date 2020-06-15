package esame.EsameProgrammazione.filter;

import java.util.ArrayList;

/**
 * Superclasse implementata da tutte le classi di filtraggio
 *  
 * @author Antonio Colucci
 * @author Carmen Andreozzi
*/

public class FilterParent {

	protected int parametro1;
	protected int parametro2;

	
	/**
	 * Costruttore in cui viene controllato il tipo di parametro preso in input: 
	 * un intero, oppure un ArrayList di interi
	 * 
	 * @param parametro
	 */
	public FilterParent(Object parametro) {
		//Condizione per controllare se "parametro" e' un intero
		if (parametro instanceof Integer)
			this.parametro1 = (Integer)parametro;
		
		//Serie di condizioni per controllare se "parametro" e' un ArrayList di interi
		else if (parametro instanceof ArrayList<?>) {
			if ( ((ArrayList<?>) parametro).size() != 2) {
				throw new IndexOutOfBoundsException("Inserire due interi!") ;
			}
												
			if(((ArrayList<?>) parametro).get(0) instanceof Integer) {
				parametro1 = (int) ((ArrayList<?>) parametro).get(0) ;
			} else {
				throw new IllegalArgumentException("Type: Integer ");
				}
					
			if(((ArrayList<?>) parametro).get(1) instanceof Integer) {
				parametro2 = (int) ((ArrayList<?>) parametro).get(1) ;
			} else {
				throw new IllegalArgumentException("Type: Integer ");
				}	
			}
		else throw new IllegalArgumentException("Il valore inserito non e' un intero");
	}
	
	/**
	 * Viene controllato il tipo di parametro preso in input: 
	 * un intero, oppure un ArrayList di interi
	 * 
	 * @param parametro
	 */
	public void setParametro(Object parametro) {
		//Condizione per controllare se "parametro" e' un intero
		if (parametro instanceof Integer)
			this.parametro1 = (Integer)parametro;
		
		//Serie di condizioni per controllare se "parametro" e' un ArrayList di interi
		else if (parametro instanceof ArrayList<?>) {
			if ( ((ArrayList<?>) parametro).size() != 2) {
				throw new IndexOutOfBoundsException("Inserire due interi!") ;
			}
												
			if(((ArrayList<?>) parametro).get(0) instanceof Integer) {
				parametro1 = (int) ((ArrayList<?>) parametro).get(0) ;
			} else {
				throw new IllegalArgumentException("Type: Integer ");
				}
					
			if(((ArrayList<?>) parametro).get(1) instanceof Integer) {
				parametro2 = (int) ((ArrayList<?>) parametro).get(1) ;
			} else {
				throw new IllegalArgumentException("Type: Integer ");
				}	
			}
		else throw new IllegalArgumentException("Il valore inserito non e' un intero");	
	}


	public int getParametro1() {
		return parametro1;
	}

	public void setParametro1(int parametro1) {
		this.parametro1 = parametro1;
	}

	public int getParametro2() {
		return parametro2;
	}

	public void setParametro2(int parametro2) {
		this.parametro2 = parametro2;
	}


}
